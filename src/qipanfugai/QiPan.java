package qipanfugai;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class QiPan extends JFrame implements ActionListener {
    Container con;//顶层容器
    JPanel jp;//中间容器
    JLabel[][] jl;//JLabel数组
    static int n = 0;//参数，保存数组长

    //构造器
    QiPan() {
        /*关于窗体*/
        super("棋盘覆盖演示-19122557王波");
        setDefaultCloseOperation(EXIT_ON_CLOSE);//按关闭时:退出
        setLocation(200, 70);//位置
        setSize(650, 650);//尺寸
        setExtendedState(MAXIMIZED_BOTH);//扩展状态

        /*初始化顶层容器Container和中间容器JPanel*/
        con = getContentPane();//顶层容器直接从JFrame获得
        jp = new JPanel();//初始化一个中间容器JPanel

        /*布局设为空,这样JLabel才能用setBounds*/
        //setLayout(null);
        //con.setLayout(null);
        jp.setLayout(null);

        n = Main.ar[Main.k];//n就是数组长宽

        /*为JLabel数组分配空间*/
        jl = new JLabel[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                jl[i][j] = new JLabel();//每个单独申请空间
                jl[i][j].setBounds(600 / n * i, 600 / n * j, 600 / n, 600 / n);
                jl[i][j].setOpaque(true);//设置非透明
                jl[i][j].setBackground(Color.white);//白色
                jp.add(jl[i][j]);//嵌套给中间容器JPanel
            }

        //JPanel再嵌套给顶层容器
        con.add(jp);

        setVisible(true);//设置可见

        int numL = (n * n - 1) / 3;//L型骨牌在当前规模下的数目
        //int r=0;//调试用的
        for (int t = 0; t <= numL; t++) {
            int numr = 0;//记录骨牌找到几个了
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (Main.ju[i][j] == t)//如果是这次要找的
                    {
                        jl[i][j].setBackground(new Color(0x00AAAA + 99999 * t));
                        //jl[i][j].setBounds(600/n*i, 600/n*j, 600/n, 600/n);
                        if (3 == ++numr)
                            break;
                    }
                }
                if (3 == numr)
                    break;
            }
            //repaint();//不需要重画
            //setVisible(true);//不需要重新设置可见
            try {
                Thread.sleep(100);//每次结束等0.1s
                //System.out.println(r++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                numr = 0;//3的一组的计数需要归零
            }
        }//end of for循环

    }//end of构造器

    //动作监听并响应
    public void actionPerformed(ActionEvent e) {
        //这个JFrame没有什么需要监听的动作
    }//end of动作监听
}