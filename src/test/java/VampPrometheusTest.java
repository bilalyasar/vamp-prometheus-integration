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

        ArrayList<String> tags = new ArrayList<String>();
        tags.add("service1");
        tags.add("");
        tags.add("");
        Query query = new Query(tags);
        Thread.sleep(1000000);
    }
}
