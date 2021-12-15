package company;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    Map<String,Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key,val);
    }

    public int sum(String prefix) {
        int res = 0;
        for (String s : map.keySet()){
            if(s.startsWith(prefix)){
                res += map.get(s);
            }
        }
        return res;
    }
}
