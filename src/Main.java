import main.java.app.Event;
import main.java.app.EventStore;
import main.java.app.Source;
import main.java.app.Utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        // Load the data
        Source s1 = new Source(1, "Kitchen temperature sensor");
        Source s2 = new Source(2, "Dorm temperature sensor");
        Source s3 = new Source(3, "Entry sensor");
        EventStore data = new EventStore();
        System.out.println();
        Event e1 = new Event(1, "Temperature main", s1, Utils.date_to_timestamp("2023/02/02 21:11:30"), 20);
        data.add_event(e1);
        Event e2 = new Event(2, "Temperature bed", s2, Utils.date_to_timestamp("2023/01/12 21:11:30"), 18);
        data.add_event(e2);
        Event e3 = new Event(3, "Open door", s3, Utils.date_to_timestamp("2023/01/24 21:11:30"), 1);
        data.add_event(e3);
        Event e4 = new Event(4, "Humidity main", s1, Utils.date_to_timestamp("2023/01/09 21:11:30"), 60);
        data.add_event(e4);

        List<Event> evs = data.search_event_by_sensor_name("temperature");
        for (Event e : evs) {
            System.out.println(e);
        }

    }
}