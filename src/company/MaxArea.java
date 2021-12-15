package company;

public class MaxArea {
    public int maxArea(int[] height) {
        int n = height.length;
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][i] = 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j + 1],Math.min(height[i], height[j])));
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.print(new MaxArea().maxArea(a));
    }
}
