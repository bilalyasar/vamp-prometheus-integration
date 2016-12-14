import query.QueryResult;

import java.util.ArrayList;

/**
 * Created by bilal on 12/13/16.
 */
public interface VampPrometheusAdapter {
    public boolean putEvent(String value, String timestamp, String... tags);

    public ArrayList<Event> getEvents();

    public QueryResult query(String value, String... tags);

    public QueryResult count(String value, String... tags);

    public QueryResult min(String value, String... tags);

    public QueryResult max(String value, String... tags);


}
