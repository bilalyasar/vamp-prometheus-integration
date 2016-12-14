import org.junit.Before;
import org.junit.Test;
import query.QueryResult;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by bilal on 12/13/16.
 */
public class VampPrometheusTest {

    VampPrometheusAdapter adapter;

    @Before
    public void setup() {
        adapter = new VampPrometheusAdapterImpl();
    }

    @Test
    public void prometheusTest() throws InterruptedException {
        adapter.putEvent("one", null, "service1", "metric1", "route1");
        adapter.putEvent("one", null, "service2", "metric2", "route2");
        adapter.putEvent("one", null, "service3", "metric3", "route3");
//        query.Query query = new

        Thread.sleep(5000);
        QueryResult result = adapter.query("one", null, "service3", "metric3", "route3");
//        ArrayList<String> tags = new ArrayList<String>();
        assertEquals(result.getData().getResult()[0].getMetric().getMetrics(), "metric3");
        assertEquals(result.getData().getResult()[0].getMetric().getServices(), "service3");
        assertEquals(result.getData().getResult()[0].getMetric().getRoutes(), "route3");
//        tags.add("service1");
//        tags.add("");
//        tags.add("");

        System.out.println(adapter.query("one", null, "service3", "metric3", "route3"));
    }
}
