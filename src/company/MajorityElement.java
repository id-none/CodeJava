package company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num,0) + 1);
            if ((hashMap.get(num) >= nums.length / 3) && !list.contains(num)){
                list.add(num);
            }
        }
        return list;
    }

}
