import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Table } from 'react-bootstrap';
import './ReservationTable.css';

export interface Reservation {
  id: number;
  confirmation_number: string;
  hotel_id: number;
  arrival_date: string;
  arrival_time: string | null;
  departure_date: string;
  departure_time: string | null;
  object: string;
  status: string;
}

function ReservationTable() {
  const [reservations, setReservations] = useState<Reservation[]>([]);

  useEffect(() => {
    async function getReservations() {
      const response = await axios.get<Reservation[]>('http://localhost:8081/api/v2/reservation');
      setReservations(response.data);
    }

    getReservations();
  }, []);

  return (
    <div>
      <h1>Reservation Table</h1>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>Confirmation Number</th>
            <th>Hotel ID</th>
            <th>Arrival Date</th>
            <th>Arrival Time</th>
            <th>Departure Date</th>
            <th>Departure Time</th>
            <th>object</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {reservations.map(reservation => (
            <tr key={reservation.id}>
              <td>{reservation.id}</td>
              <td>{reservation.confirmation_number}</td>
              <td>{reservation.hotel_id}</td>
              <td>{reservation.arrival_date}</td>
              <td>{reservation.arrival_time}</td>
              <td>{reservation.departure_date}</td>
              <td>{reservation.departure_time}</td>
              <td>{reservation.object}</td>
              <td>{reservation.status}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
}

export default ReservationTable;
