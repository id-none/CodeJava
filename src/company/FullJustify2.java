package company;

public class FullJustify2 {
    public void get_badness(int[] w, int[][] b, int s) {
        for (int i = 0; i < w.length; i++) {
            double sum = 0;
            for (int j = i; j < w.length; j++) {
                sum = sum + w[j];
                if ((double) s > sum) {
                    b[i][j] = (int) Math.pow(((double) s - sum), 3);
                } else {
                    b[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public void TextAlignment(int[] w, int s, int[] dp) {
        int len = w.length;
        int[][] b = new int[len][len];
        get_badness(w, b, s);
        dp[len] = 0;
        dp[len - 1] = b[len - 1][len - 1];
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = b[i][len - 1];
            for (int j = i; j < len; j++) {
                if (b[i][j] + dp[j + 1] < dp[i]) {
                    dp[i] = b[i][j] + dp[j + 1];
                }
            }
        }
    }
}
