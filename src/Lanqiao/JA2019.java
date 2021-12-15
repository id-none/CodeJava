package Lanqiao;

import java.math.BigInteger;
import java.sql.Struct;
import java.util.PriorityQueue;
import java.util.Queue;

public class JA2019 {

    // 试题 A: 平方和
//    public static void main(String[] args) {
//        BigInteger sum = BigInteger.ZERO;
//        for (int i = 1; i <= 2019; i++) {
//            if ((i + "").contains(new StringBuffer("2")) || (i + "").contains(new StringBuffer("0")) || (i + "").contains(new StringBuffer("1")) || (i + "").contains(new StringBuffer("9"))) {
//                sum = sum.add(new BigInteger(i * i + ""));
//            }
//        }
//        System.out.println(sum);
//    }
    // 试题 B: 数列求值
//    public static void main(String[] args) {
//        BigInteger a = BigInteger.ONE;
//        BigInteger b = BigInteger.ONE;
//        BigInteger c = BigInteger.ONE;
//        BigInteger d = new BigInteger("3");
//        for (int i = 5; i <= 20190324; i++) {
//            a = b.mod(new BigInteger("10000"));
//            b = c.mod(new BigInteger("10000"));
//            c = d.mod(new BigInteger("10000"));
//            d = a.add(b.add(c)).mod(new BigInteger("10000"));
//        }
//        System.out.println(d);
//    }

    // 试题 C: 最大降雨量 34
    // 试题 D： 迷宫

}

class Node {
    public int x;
    public int y;
    boolean visited = false;
    public int[][] walk = new int[][]{
            {0, -1}, {0, 1}, {-1, 0}, {1, 0}
    };
    static public int best;

    public void bfs() {
        Queue<Node> q = new PriorityQueue<>();
        Node tmp = new Node();
        q.add(tmp);
        tmp.visited = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int k = 0; k < 4; k++) {
                now.x = now.x + walk[k][0];
                now.y = now.y + walk[k][1];
            }
        }
    }
}