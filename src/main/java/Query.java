import java.util.ArrayList;

/**
 * Created by bilal on 12/13/16.
 */
public class Query {
    String[] tags;
    String value;

    Query(String value, String... tags) {
        this.tags = tags;
        this.value = value;
    }

    public String generateQueryString() {
//        "events{instance=\"localhost:1234\",job=\"prometheus\",metrics=\"metric2\",routes=\"route2\",services=\"service2\",value=\"one\"}"
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("events{instance=\"localhost:1234\",");
        if (tags[0] != null) {
            stringBuilder.append("value=\"");
            stringBuilder.append(tags[0]);
            stringBuilder.append("\",");
        }
        if (tags[1] != null) {
            stringBuilder.append("services=\"");
            stringBuilder.append(tags[1]);
            stringBuilder.append("\",");
        }
        if (tags[2] != null) {
            stringBuilder.append("metrics=\"");
            stringBuilder.append(tags[2]);
            stringBuilder.append("\",");
        }
        if (tags[3] != null) {
            stringBuilder.append("routes=\"");
            stringBuilder.append(tags[3]);
        }
        stringBuilder.append("\"}");
        return stringBuilder.toString();
    }

}
