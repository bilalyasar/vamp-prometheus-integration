import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by bilal on 12/14/16.
 */
public class QueryRestService {

    public QueryRestService() {

    }

    public String makeCall(String query) {
        URL url = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            url = new URL("http://localhost:9090/api/v1/query?query=" + URLEncoder.encode(query, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            for (String line; (line = reader.readLine()) != null; ) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
