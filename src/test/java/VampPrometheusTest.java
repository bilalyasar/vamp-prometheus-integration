import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import query.Metric;
import query.QueryResult;

import static org.junit.Assert.assertEquals;

/**
 * Created by bilal on 12/13/16.
 */
public class VampPrometheusTest {

    static VampPrometheusAdapter adapter;

    @BeforeClass
    public static void setup() throws InterruptedException {
        adapter = new VampPrometheusAdapterImpl();
        adapter.putEvent("1", null, "service1", "metric1", "route1");
        adapter.putEvent("2", null, "service2", "metric2", "route2");
        adapter.putEvent("3", null, "service3", "metric3", "route3");
        Thread.sleep(5000);
    }

    @Test
    public void testCount() throws InterruptedException {
        QueryResult result = adapter.count("one", null, "service3", "metric3", "route3");
        assertEquals(result.getData().getResult()[0].getValue()[1], "1");
    }

    @Test
    public void testCountAll() {
        QueryResult result = adapter.count("one", null, null, null, null);
        assertEquals(result.getData().getResult()[0].getValue()[1], "3");
    }

    @Test
    public void testSimpleQuery(){
        QueryResult result = adapter.query("one", null, "service3", "metric3", "route3");
        Metric metric = result.getData().getResult()[0].getMetric();
        assertEquals(metric.getRoutes(),"route3");
        assertEquals(metric.getServices(),"service3");
        assertEquals(metric.getMetrics(),"metric3");
    }

    @Test
    public void testMin(){
        QueryResult result = adapter.max(null, null, null, null, null);
        System.out.println();
    }

    @Test
    public void testMax(){

    }
}
