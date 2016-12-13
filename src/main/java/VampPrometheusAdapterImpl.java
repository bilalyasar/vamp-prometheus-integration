import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.MetricsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bilal on 12/13/16.
 */
public class VampPrometheusAdapterImpl implements VampPrometheusAdapter {

    static final Gauge eventHandler = Gauge.build()
            .name("events").help("events").labelNames("services", "metrics", "routes", "value").register();

    VampPrometheusAdapterImpl() {
        setup();
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

    public boolean putEvent(String value, String timestamp, String... tags) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.addAll(Arrays.asList(tags));
        arrayList.add(value);
        eventHandler.labels((String[]) arrayList.toArray(new String[0])).set(1);
        return false;
    }

    public ArrayList<Event> getEvents() {
        return null;
    }

    public Object query(Query query) {
        return null;
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
}
