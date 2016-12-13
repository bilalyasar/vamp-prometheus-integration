import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.MetricsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
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
//        String endpoint = query.tags.
        URL url = null;
        try {
            url = new URL("http://localhost:9090/api/v1/query?query=" + URLEncoder.encode("events{metrics=\"metric1\", routes=\"route1\",services=\"service1\",value=\"one\"}", "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            for (String line; (line = reader.readLine()) != null; ) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
