import java.util.ArrayList;
import java.util.Arrays;


/*
possible tags: services,metrics,routes
 */


public class Event {
    String[] tags;
    String value;
    String timestamp;


    public Event(String value, String timestamp, String[] tags) {
        this.tags = tags;
        this.value = value;
        this.timestamp = timestamp;
    }

    public String[] getData() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.addAll(Arrays.asList(tags));
        arrayList.add(value);
        return arrayList.toArray(new String[0]);
    }
}
