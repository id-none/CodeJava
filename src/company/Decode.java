package company;

import java.util.Arrays;

/**
 * @author 王波
 */
public class Decode {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] ans = new int[n];
        ans[0] = first;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }
        return ans;
    }

    public void test() {
        System.out.println(Arrays.toString(decode(new int[]{6, 2, 7, 3}, 4)));
    }
}
