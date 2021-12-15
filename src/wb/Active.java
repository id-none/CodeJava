package wb;

/**
 * @author 王波
 */
public class Active {
    public void GreedySelector(int n, int[] s, int[] f, boolean[] A) {

        A[1] = true;
        int j = 1;
        //记录最近一次加入A中的活动
        //依次检查活动i是否与当前已选择的活动相容
        for (int i = 2; i <= n; i++) {
            if (s[i] >= f[j]) {
                A[i] = true;
                j = i;
            } else {
                A[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        //下标从1开始,存储活动开始时间
        int[] s = new int[]{0, 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};

        //下标从1开始,存储活动结束时间
        int[] f = new int[]{0, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        boolean[] A = new boolean[12];

        System.out.println("各活动的开始时间,结束时间分别为：");
        for (int i = 1; i <= 11; i++) {
            System.out.println("[" + i + "]:" + "(" + s[i] + "," + f[i] + ")");
        }
        new Active().GreedySelector(11, s, f, A);
        System.out.println("最大相容活动子集为：");
        for (int i = 1; i <= 11; i++) {
            if (A[i]) {
                System.out.println("[" + i + "]:" + "(" + s[i] + "," + f[i] + ")");
            }
        }
    }
}
