package qipanfugai;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



class Input extends JFrame implements ActionListener
{
    int k=0;//输入的值
    int n1=1,n2=1;//n1,n2存输入的x,y坐标
    Container con;//顶层容器
    JPanel jp;//中间容器
    JTextField tf;//文本框
    JTextField tf2,tf3;//文本框:输入x,y坐标
    JLabel jl0,jl1,jl2;//标签
    JButton jb;//按钮

    //构造器
    Input()
    {
        /*关于窗体*/
        super("输入规模的指数位(范围2~6)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);//按关闭时:退出
        setExtendedState(NORMAL);//扩展状态
        setLocation(400,250);//位置
        setSize(250,150);//尺寸

        /*初始化顶层容器Container和中间容器JPanel*/
        con=getContentPane();//顶层容器直接从JFrame获得
        jp=new JPanel();//初始化一个中间容器JPanel

        /*初始化其它容器*/
        tf=new JTextField(10);//文本框
        jl0=new JLabel("规模的指数位:");
        jl1=new JLabel("特殊点x坐标: ");//标签
        jl2=new JLabel("特殊点y坐标: ");
        tf2=new JTextField(10);//横坐标
        tf3=new JTextField(10);//纵坐标
        jb=new JButton("开始演示");//按钮

        /*键盘事件：判断键入的是否为数字*/
        tf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int temp = e.getKeyChar();//ASCII码
                //System.out.println(temp);
                if(temp == 10){//按回车时
                }
                else if(temp != 8)//没有按backspace时
                {
                    //下面检查是不是在0~9之间
                    if(temp>57){
                        e.consume();//如果不是则消除key事件,也就是按了键盘以后没有反应;
                    }else if(temp<48){
                        e.consume();
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
            }
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
            }
        });

        /*键盘事件：判断键入的是否为数字*/
        tf2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int temp = e.getKeyChar();//ASCII码
                if(temp == 10){//按回车时
                }
                else if(temp != 8)//没有按backspace时
                {
                    //下面检查是不是在0~9之间
                    if(temp>57){
                        e.consume();//如果不是则消除key事件,也就是按了键盘以后没有反应;
                    }else if(temp<48){
                        e.consume();
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
            }
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
            }
        });

        /*键盘事件：判断键入的是否为数字*/
        tf3.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int temp = e.getKeyChar();//ASCII码
                if(temp == 10){//按回车时
                }
                else if(temp != 8)//没有按backspace时
                {
                    //下面检查是不是在0~9之间
                    if(temp>57){
                        e.consume();//如果不是则消除key事件,也就是按了键盘以后没有反应;
                    }else if(temp<48){
                        e.consume();
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
            }
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
            }
        });

        //为按钮添加动作响应
        jb.addActionListener(this);

        //以下容器嵌套给了JPanel
        jp.add(jl0);
        jp.add(tf);
        jp.add(jl1);
        jp.add(tf3);
        jp.add(jl2);
        jp.add(tf2);
        jp.add(jb);

        //最后顶层容器Container里嵌套了这个JPanel
        con.add(jp);

        setVisible(true);
    }//end of构造器


    //动作监听并响应
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();// 根据动作命令,来进行分别处理
        if (cmd.equals("开始演示"))//单击按钮时
        {
            String s_num=tf.getText();//获取内容
            String s_x=tf2.getText();
            String s_y=tf3.getText();
            if(s_num.equals("")||s_x.equals("")||s_y.equals(""))//没输入东西
            {
                JOptionPane.showMessageDialog(null, "缺少输入!");
                return ;
            }
            k=Integer.parseInt(s_num);//转换成数字
            n1=Integer.parseInt(s_x);
            n2=Integer.parseInt(s_y);
            //System.out.println(k);
            if(k<2 || k>6)
                JOptionPane.showMessageDialog(null, "规模指数位需要2~6之间的数字!");
            else if(n1>=Main.ar[k]||n2>=Main.ar[k])//注意它们机制上就不可能为负
                JOptionPane.showMessageDialog(null, "在该规模下你的下标越界了!");
            else//输入正确，交给Main来开始另一个JFrame
            {
                Main.k=this.k;//把值传给Main类
                Main.h=this.n1;
                Main.u=this.n2;
                dispose();//本窗口销毁
            }
        }
    }//end of动作监听
}