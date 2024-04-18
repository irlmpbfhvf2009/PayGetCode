package init;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonObject {
    private final Map<String, String> map = new LinkedHashMap<>();

    public void put(String key, String value) {
        map.put(key, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (i++ > 0) {
                sb.append(",");
            }
            sb.append("\"").append(entry.getKey()).append("\":");
            if (entry.getValue() != null) {
                sb.append("\"").append(entry.getValue()).append("\"");
            } else {
                sb.append("null");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
