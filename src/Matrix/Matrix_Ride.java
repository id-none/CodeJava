package Matrix;

import java.util.Scanner;

public class Matrix_Ride {
    static int[][] m = new int[50][50];//存放子问题的最优解
    static int[][] s = new int[50][50];//存放子问题的最佳断点

    public static void jzlc(int[] p, int[][] m, int[][] s, int n) {
        for (int r = 2; r <= n; r++)//矩阵连乘的个数
        {
            for (int i = 1; i <= n - r + 1; i++)//i为开始的矩阵，小于n-r+1，因为n-r+1+r=n+1
            {
                int j = i + r - 1;//j为当前循环的最后的一个矩阵
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];//这个为最佳断点为i时的公式
                s[i][j] = i;
                for (int k = i + 1; k < j; k++)//寻找最佳断点
                {

                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    public static void dy(int i, int j, int[][] s)//递归求出答案，并打印
    {
        if (i == j) return;
        dy(i, s[i][j], s);
        dy(s[i][j] + 1, j, s);
        System.out.print("Multiply A" + i + "," + s[i][j]);
        System.out.println(" and A" + (s[i][j] + 1) + "," + j);
    }

    public static void main(String[] args) {
        //6 30 35 15 5 10 20 25          输入
        System.out.println("请输入矩阵相乘的矩阵个数");
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] p = new int[n + 1];//存放矩阵的行和列
        System.out.println("请依次输入矩阵的行和烈（如A*B，A=20*30，B=30*40，即输入20 30 40)");
        for (int i = 0; i < n + 1; i++)
            p[i] = reader.nextInt();
        jzlc(p, m, s, n);
        for (int i = 0; i <= n; i++)//打印存储最优值和最优解的数组，这里要注意i和j的对于数组的位置以及for循环的结束条件
        {
            for (int j = 0; j <= n; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
        dy(1, n, s);//打印结果
    }
}
