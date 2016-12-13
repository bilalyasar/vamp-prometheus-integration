/**
 * Created by bilal on 12/12/16.
 */

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.Summary;
import io.prometheus.client.exporter.MetricsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    static final Summary requestLatency = Summary.build()
            .name("requests_latency_seconds")
            .help("Request latency in seconds.").register();
    static final Counter requestFailures = Counter.build()
            .name("requests_failures_total")
            .help("Request failures.").register();
    static final Gauge inprogressRequests = Gauge.build()
            .name("inprogress_requests").help("Inprogress requests.").labelNames("method").register();

    public static void main(String[] args) throws Exception {

        Server server = new Server(1234);
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(
                new MetricsServlet()), "/metrics");
        // Put your application setup code here.

        server.start();

        processGetRequest();
//        CollectorRegistry registry = new CollectorRegistry();
        inprogressRequests.labels("1").inc();
        inprogressRequests.labels("2").inc();
        inprogressRequests.labels("3").inc();
//        gauge.labels("1", "2");
//        gauge.inc();
        server.join();

    }

    static void processGetRequest() throws Exception {
        Summary.Timer requestTimer = requestLatency.startTimer();
        try {
            requestFailures.inc();
            // Your code here.
        } catch (Exception e) {
            requestFailures.inc();
            throw e;
        } finally {
            requestTimer.observeDuration();
        }
    }
}
