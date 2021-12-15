package company;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ToHex {
    public int countSegments(String s) {
        String[] ans = s.trim().split(" ");
        return ans.length;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        int iPos = 0;
        int iLen = s.length();
        while (iLen >= 10) {
            String tmp = s.substring(0, 10);
            result.add(tmp);
            s = s.substring(10);
            iLen = s.length();
        }
        return result;
    }

    public String destCity(List<List<String>> paths) {
        Set<String> citiesA = new HashSet<String>();
        for (List<String> path : paths) {
            citiesA.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!citiesA.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int i = 0;
        int j = 0;
        int[][] bp = new int[n + 1][m + 1];
        for (i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (j = 1; j <= m; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    bp[i][j] = bp[i - 1][j - 1];
                } else
                    bp[i][j] = Math.max(bp[i - 1][j], bp[i][j - 1]);
            }
        }
        return bp[m][n];
    }

    public int maxSubArray(int[] nums, int m) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n - m; i++) {
            max = Math.max(max, get_sum(m, i, nums));
        }
        return max;
    }

    public int get_sum(int m, int i, int[] nums) {
        int sum = 0;
        for (int j = i; j < m + i; j++)
            sum += nums[i - 1];
        return sum;
    }

    public int divide(int dividend, int divisor) {
        String flag = ((dividend >= 0 && divisor >= 0) || ((dividend <= 0 && divisor <= 0))) ? "" : "-";
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int sum = 0, i;
        for (i = 0; ; i++) {
            sum += divisor;
            if (sum > dividend) break;
        }
        return Integer.parseInt(flag + i);
    }

    public int minDistance(String word1, String word2) {
        int length1 = word1.length(), length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        //初始化边界
        for (int i = 0; i < length1; ++i) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < length2; ++i) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                // 删除操作：dp[i - 1][j]
                // 增加操作：dp[i][j - 1]
                // 替换操作：dp[i - 1][j - 1]
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % 3 == 0 && n % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (n % 3 == 0) {
                ans.add("Fizz");
            } else if (n % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(i + "");
            }
        }
        return ans;
    }

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        return 0;
    }

    public String countAndSay(int n) {
        if (n == 1) return "11";
        char[] s = countAndSay(n - 1).toCharArray();
        int i = 1;
        String ans = "";
        for (char c : s) {
            if (c == s[i]) {
                i++;
            } else {
                ans = ans + i + c;
                i = 1;
            }
        }
        return "";
    }
}

