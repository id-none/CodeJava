package company;

import java.util.HashMap;

public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int i = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int num : nums){
            hashMap.put(num, hashMap.getOrDefault(num,0) + 1);
        }
        for(int num : nums){
            if(hashMap.get(num) == 1){
                ans[i++] = num;
            }
        }
        return ans;
    }
}
