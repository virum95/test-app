package test.java.app;

import main.java.app.Event;
import main.java.app.EventStore;
import main.java.app.Utils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AppTest {
    private EventStore events;
    @Before
    public void init_data(){
        events = new EventStore(Utils.file_to_events("resources/Events.txt"));
    }
    @Test
    public void test_search_name() {
        List<Event> home_events = events.search_event_by_sensor_name("Home");
        Assert.assertEquals(13, home_events.size());
        List<Event> office_events = events.search_event_by_sensor_name("Office");
        Assert.assertEquals(8, office_events.size());
        List<Event> dorm_events = events.search_event_by_sensor_name("dorm");
        Assert.assertEquals(6, dorm_events.size());
        List<Event> room_events = events.search_event_by_sensor_name("room");
        Assert.assertEquals(7, room_events.size());
    }
    @Test
    public void test_search_between_dates() {
        List<Event> last_year_ev = events.search_event_between_dates(Utils.date_to_timestamp("2022/01/01 00:00:00"), Utils.date_to_timestamp("2023/01/01 00:00:00"));
        Assert.assertEquals(9, last_year_ev.size());
        List<Event> empty_ev = events.search_event_between_dates(Utils.date_to_timestamp("1990/01/01 00:00:00"), Utils.date_to_timestamp("1991/01/01 00:00:00"));
        Assert.assertTrue(empty_ev.isEmpty());
        List<Event> one_hour_ev = events.search_event_between_dates(Utils.date_to_timestamp("2023/01/06 16:30:00"), Utils.date_to_timestamp("2023/01/06 17:30:00"));
        Assert.assertEquals(3, one_hour_ev.size());
    }
    @Test
    public void test_search_value_in_range() {
        List<Event> big_values_ev = events.search_event_value_in_range(75, 1000);
        Assert.assertEquals(2, big_values_ev.size());
        List<Event> empty_ev = events.search_event_between_dates(-50,-25);
        Assert.assertTrue(empty_ev.isEmpty());
        List<Event> zero_ev = events.search_event_value_in_range(-0.01, 0.01);
        Assert.assertEquals(3, zero_ev.size());
    }
}
