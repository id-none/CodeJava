package qipanfugai;

import javax.swing.*;

public class Main {
    static int k = 0;//规模的指数
    static int[] ar = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};//查表快
    static int[][] ju = null;
    static int tile = 0;//当前L型骨牌号
    static int h = 5, u = 1;//特殊坐标1,1

    public static void main(String[] args) {
        Input ip = new Input();//输入窗口
        while (0 == Main.k)//等待输入条件成立
        {
            System.out.print("");//在我这个jdk下必须要做事情而不能用空语句
        }
        ju = new int[ar[k]][ar[k]];//(2^k)*(2^k)的矩阵用来记录号
        ju[h][u] = -1;
        new Main().ChessBoard(0, 0, h, u, ar[k]);//开始棋盘覆盖
        QiPan qp = new QiPan();//演示窗口
    }//end of main()

    //算法部分
    void ChessBoard(int tr, int tc, int dr, int dc, int size) {
        //tr:棋盘左上角行号
        //tc:棋盘左上角列号
        //dc:当前特殊方格列号
        //dc:当前特殊方格行号
        //size:当前规模(子棋盘长)
        if (size == 1)
            return;
        int t = tile++;//t是当前递归层的L型骨牌号
        int s = size / 2;//分割棋盘
        //对于四个子棋盘,如果当前特殊方格就在这个子棋盘里,只要对其继续递归
        //否则,用一个格子填充这个棋盘靠近父棋盘中心的角,并以此为特殊格子递归
        try {
            //左上
            if (dr < tr + s && dc < tc + s) {
                ChessBoard(tr, tc, dr, dc, s);
            } else {
                ju[tr + s - 1][tc + s - 1] = t;
                ChessBoard(tr, tc, tr + s - 1, tc + s - 1, s);
            }
            //右上
            if (dr < tr + s && dc >= tc + s)
                ChessBoard(tr, tc + s, dr, dc, s);
            else {
                ju[tr + s - 1][tc + s] = t;
                ChessBoard(tr, tc + s, tr + s - 1, tc + s, s);
            }
            //左下
            if (dr >= tr + s && dc < tc + s)
                ChessBoard(tr + s, tc, dr, dc, s);
            else {
                ju[tr + s][tc + s - 1] = t;
                ChessBoard(tr + s, tc, tr + s, tc + s - 1, s);
            }
            //右下
            if (dr >= tr + s && dc >= tc + s)
                ChessBoard(tr + s, tc + s, dr, dc, s);
            else {
                ju[tr + s][tc + s] = t;
                ChessBoard(tr + s, tc + s, tr + s, tc + s, s);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "出现了奇怪的异常");
        }
    }//end of算法
}
