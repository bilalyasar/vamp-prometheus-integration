import java.util.ArrayList;

/**
 * Created by bilal on 12/13/16.
 */
public class Query {
    ArrayList<String> tags = new ArrayList<String>();
    String value;

    Query(ArrayList<String> tags, String value) {
        this.tags = tags;
        this.value = value;
    }

    public String generateQueryString() {
        return null;
    }
}
