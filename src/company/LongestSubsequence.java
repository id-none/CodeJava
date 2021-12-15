package company;

import java.util.HashMap;

public class LongestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 0;
        for (int a : arr) {
            dp.put(a, dp.getOrDefault(a - difference, 0) + 1);
            ans = Math.max(ans, dp.get(a));
        }
        return ans;
    }
}
