package company;

import java.math.BigInteger;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        StringBuilder ans = new StringBuilder();
        for (int num : digits) {
            ans.append(num);
        }
        BigInteger bigInteger = new BigInteger(ans.toString());
        bigInteger = bigInteger.add(BigInteger.valueOf(1));
        String res = bigInteger.toString();
        int n = res.length();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(res.charAt(i) + "");
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int[] b = new PlusOne().plusOne(a);
        for (int bs : b) {
            System.out.print(bs + " ");
        }
    }
}
