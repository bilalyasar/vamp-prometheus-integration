import query.Query;
import query.QueryResult;

import java.util.ArrayList;

/**
 * Created by bilal on 12/13/16.
 */
public interface VampPrometheusAdapter {
    public boolean putEvent(String value, String timestamp, String... tags);

    public ArrayList<Event> getEvents();

    public QueryResult query(String value, String... tags);

    public int count(Query query);

    public double min(Query query);

    public double max(Query query);


}
