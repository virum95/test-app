package main.java.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventStore {

    private List<Event> events;

    public EventStore() {
        this.events = new ArrayList<>();
    }
    public EventStore(List<Event> events) {
        this.events = events;
    }

    public void setEvents(List<Event> events){
        this.events = events;
    }

    public void add_event(Event event) {
        this.events.add(event);
    }

    public List<Event> search_event_by_sensor_name(String name) {
        return this.events.stream()
                .filter(event -> event.getSourceName().contains(name))
                .collect(Collectors.toList());
    }
    public List<Event> search_event_between_dates(long begin, long end) {
        return this.events.stream()
                .filter(event -> event.isBetweenDates(begin, end))
                .collect(Collectors.toList());
    }
    public List<Event> search_event_value_in_range(double low, double high) {
        return this.events.stream()
                .filter(event -> event.isValueInRange(low, high))
                .collect(Collectors.toList());
    }

    public List<Event> search_event_by_values(int min, int max) {
        List<Event> events = new ArrayList<>();

        return events;
    }


}
