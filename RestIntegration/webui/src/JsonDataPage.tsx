import { useState, useEffect } from 'react';
import axios from 'axios';
import CollapsibleJSON from './CollapsibleJSON';

export interface JsonData {
  [key: string]: any;
}

function JsonDataPage() {
  const [reservations, setReservations] = useState<JsonData[]>([]);

  useEffect(() => {
    async function getReservations() {
      const response = await axios.get<JsonData[]>('http://localhost:8081/api/v2/jsondata');
      setReservations(response.data);
    }

    getReservations();
  }, []);

  return (
    <div>
      <h1>Reservation Table</h1>
      {reservations.map(reservation => (
        <CollapsibleJSON key={reservation.id} data={reservation} />
      ))}
    </div>
  );
}

export default JsonDataPage;
