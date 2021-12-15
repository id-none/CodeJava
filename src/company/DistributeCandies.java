package company;

import java.util.HashMap;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length / 2;
        int ans = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : candyType) {
            hashMap.put(num, hashMap.getOrDefault(num,0) + 1);
            if (hashMap.get(num) >= 1) {
                ans++;
            }
        }
        return Math.min(ans, n);
    }
}
