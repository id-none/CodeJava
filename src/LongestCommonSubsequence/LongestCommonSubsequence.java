package LongestCommonSubsequence;

public class LongestCommonSubsequence {
    static public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    //System.out.print(c1+" ");
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
//        Scanner nums = new Scanner(System.in);
//        int num = nums.nextInt();
//        while (num-- != 0) {
//            StringBuilder text1 = new StringBuilder();
//            StringBuilder text2 = new StringBuilder();
//            int n = nums.nextInt();
//            int m = nums.nextInt();
//            for (int i = 0; i < n; i++) {
//                text1.append(nums.next().charAt(0));
//            }
//            for (int i = 0; i < m; i++) {
//                text2.append(nums.next().charAt(0));
//            }
//            System.out.println(longestCommonSubsequence(text1.toString(), text2.toString()));
//        }
    }
}
