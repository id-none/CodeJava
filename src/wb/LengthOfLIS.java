package wb;


public class LengthOfLIS {
    int n = 10;
    int[] dp = new int[n];

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        dp[0] = 1;
        int max_length = 1;
        for (int i = 1; i < n; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max_length = Math.max(max_length, dp[i]);
        }
        return max_length;
    }

    public void trace_back(int max_length, int[] nums) {
        int n = 0;
        for (n = 0; n < nums.length; n++) {
            if (max_length == dp[n])
                break;
        }

    }

}
