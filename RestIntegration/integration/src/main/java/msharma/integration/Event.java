package innovyt.stayntouch;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Event {

    public String id;
    public Date arrival_date;
    public Date arrival_time;
    public String confirmation_number;
    public Date departure_date;
    public Date departure_time;
    public String hotel_id;
    public String object;
    public String status;
    public long timestamp;
    public static String[] validStatus = new String[] { "reserved", "Cancelled" };
    
    public Event(){

    }

    public Event createEvent() {
        long days = (long) ((Math.random() * (10 - 1)) + 1);
        this.arrival_date = Date.from(LocalDateTime.now().plusDays(days).atZone(ZoneId.systemDefault()).toInstant());
        this.arrival_time = Date.from(LocalDateTime.now().plusMinutes(30).atZone(ZoneId.systemDefault()).toInstant());
        this.confirmation_number = Long.toString((long) (Math.random() * (199999 - 100000 )) + 100000);
        this.departure_date = Date.from(LocalDateTime.now().plusDays(days + 2).atZone(ZoneId.systemDefault()).toInstant());
        this.hotel_id = Long.toString((long) (Math.random() * (199999 - 100000)) + 100000);
        this.object = "reservation";
        this.status = validStatus[(int) Math.random() < 0.5 ? 0 : 1];
        this.id = Long.toString((long) (Math.random() * (1999999 - 1000000 )) + 1000000);
        this.timestamp = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()).getTime();
        return this;
    }

}
