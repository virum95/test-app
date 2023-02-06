package main.java.app;

public class Event {
    private int id;
    private String name;
    private Source source;
    private long timestamp;
    private double value;

    public Event(int id, String name, Source source, long timestamp, double value) {
        this.id = id;
        this.name = name;
        this.source = source;
        this.timestamp = timestamp;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Source getSource() {
        return source;
    }

    public String getSourceName() {
        return source.getName();
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isBetweenDates(long begin, long end){
        return (this.timestamp > begin && this.timestamp < end);
    }

    public boolean isValueInRange(double low, double high){
        return (this.value > low && this.value < high);
    }

    @Override
    public String toString() {
        return "(" + this.getSourceName() + "): " + this.name + ": " + this.value;
    }
}
