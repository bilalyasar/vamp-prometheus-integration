import java.util.ArrayList;


/*
possible tags: services,metrics,routes
 */


public class Event {
    ArrayList<String> tags = new ArrayList<String>();
    String value;
    String timestamp;

    Event(ArrayList<String> tags, String value, String timestamp) {
        this.tags = tags;
        this.value = value;
        this.timestamp = timestamp;
    }

}
