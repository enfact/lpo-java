package util;

import com.jakewharton.fliptables.FlipTableConverters;

import java.util.HashMap;

public class MapUtil {
    public static <T1, T2> void displayAsTable(HashMap<T1, T2> map, String... headers) {
        Object[][] content = new Object[map.keySet().size()][2];
        int i = 0;
        for (T1 x : map.keySet()) {
            content[i][0] = x;
            content[i][1] = map.get(x);
        }
        System.out.println(FlipTableConverters.fromObjects(headers, content));
    }
}
