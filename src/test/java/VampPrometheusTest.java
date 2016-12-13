import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        adapter.query(null);
        ArrayList<String> tags = new ArrayList<String>();
        tags.add("service1");
        tags.add("");
        tags.add("");
        Thread.sleep(1000000);
    }
}
