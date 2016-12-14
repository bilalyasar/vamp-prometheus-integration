import com.google.gson.Gson;
import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.MetricsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import query.Query;
import query.QueryResult;

import java.util.ArrayList;

/**
 * Created by bilal on 12/13/16.
 */
public class VampPrometheusAdapterImpl implements VampPrometheusAdapter {

    static final Gauge eventHandler = Gauge.build()
            .name("events").help("events").labelNames("services", "metrics", "routes", "value").register();
    QueryRestService queryRestService;
    Gson gson = new Gson();

    VampPrometheusAdapterImpl() {
        setup();
        queryRestService = new QueryRestService();
    }

    public boolean putEvent(String value, String timestamp, String... tags) {
        Event event = new Event(value, timestamp, tags);
        eventHandler.labels(event.getData()).set(1);
        return false;
    }

    public ArrayList<Event> getEvents() {
        return null;
    }

    public QueryResult query(String value, String... tags) {
        Query query = new Query(value, tags);
//        String endpoint = query.tags.
        return gson.fromJson(queryRestService.makeCall(query.generateQueryString()), QueryResult.class);
    }

    public int count(Query query) {
        return 0;
    }

    public double min(Query query) {
        return 0;
    }

    public double max(Query query) {
        return 0;
    }


    private void setup() {
        Server server = new Server(1234);
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(
                new MetricsServlet()), "/metrics");
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
