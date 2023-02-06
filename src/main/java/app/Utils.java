package main.java.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;

public final class Utils {
    public static long date_to_timestamp(String date) {
        try {
            return new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(date).getTime() / 1000;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Event> file_to_events(String filename) {
        List<Event> events = new ArrayList<>();
        try {
            Map<Integer, Source> sources = new HashMap();
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int id = Integer.parseInt(data.split(",")[1]);
                String name = data.split(",")[2];
                if (data.split(",")[0].equals("Source")) {
                    sources.put(id, new Source(id, name));
                } else {
                    int source_id = Integer.parseInt(data.split(",")[3]);
                    long timestamp = date_to_timestamp(data.split(",")[4]);
                    int value = Integer.parseInt(data.split(",")[5]);
                    events.add(new Event(id, name, sources.get(source_id), timestamp, value));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return events;
    }

    private Utils() {
    }
}
