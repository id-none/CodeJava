package company;

public class mid_num {
    public int rank(int[] a, int lo, int hi) {
        if (lo > hi)
            return -1;//表示notfound;
        int i = lo + (hi - lo) / 2;
        if (a[i] < i)
            return rank(a, i + 1, hi);
        else if (a[i] > i)
            return rank(a, lo, i - 1);
        else {
            return i;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,3,5,6,7,8,9};
        System.out.println(new mid_num().rank(a, 0, 8));
        //key是想要查找的值，a是数组名称，0和n-1是数组的上下界限
    }
}
