package com.sky.gui;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

/**
 * @author : wushikai
 * <p>
 * date : 2020-06-09
 *
 * Java GUI:
 * 第一代 awt  第二代 swing 第三代 JavaFx
 *
 *
 */
public class GuiDemo {


    public static void main(String[] args) {


//        createAWindow();
//        createAwindow1();

         //   createCalc();
       // createCall();
        //creteNotepad();
       // checkBoxForm();
       // radioForm();
        selectForm();
    }


    public  static void createAWindow ( ){
        JFrame jFrame = new JFrame("Java天下第一");    //创建一个JFrame对象
        jFrame.setBounds(300, 100, 400, 400);    //设置窗口大小和位置
        JPanel jPanel = new JPanel();    //创建一个JPanel对象
        JLabel jLabel = new JLabel("这是放在JPanel上的标签");    //创建一个标签
        jPanel.setBackground(Color.white);    //设置背景色


        jPanel.add(jLabel);    //将标签添加到面板
        jFrame.add(jPanel);    //将面板添加到窗口
        jFrame.setVisible(true);

        //jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //点击 x 直接 system.exit
        ///System.out.println("我会被执行吗???");

    }

    public  static void createAwindow1 ( ){

        JFrame frame=new JFrame("Java第五个程序");    //创建Frame窗口
        JPanel p1=new JPanel();    //面板1
        JPanel p2=new JPanel();    //面板2
        JPanel jPanel=new JPanel(new CardLayout());    //卡片式布局的面板
        p1.add(new JButton("登录按钮"));
        p1.add(new JButton("注册按钮"));
        p1.add(new JButton("找回密码按钮"));
        p2.add(new JTextField("用户名文本框",20));
        p2.add(new JTextField("密码文本框",20));
        p2.add(new JTextField("验证码文本框",20));
        jPanel.add(p1,"card1");    //向卡片式布局面板中添加面板1
        jPanel.add(p2,"card2");    //向卡片式布局面板中添加面板2
        CardLayout cardLayout=(CardLayout)(jPanel.getLayout());
        cardLayout.show(jPanel,"card1");    //调用show()方法显示面板2
        frame.add(jPanel);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public  static void createCalc ( ){
        JFrame jFrame=new JFrame(" jPanel.setLayout(new GridLayout(4,4,5,5))");
        JPanel jPanel=new JPanel();    //创建面板
        //指定面板的布局为GridLayout，4行4列，间隙为5
        jPanel.setLayout(new GridLayout(4,4,5,5));
        jPanel.add(new JButton("7"));    //添加按钮
        jPanel.add(new JButton("8"));
        jPanel.add(new JButton("9"));
        jPanel.add(new JButton("/"));
        jPanel.add(new JButton("4"));
        jPanel.add(new JButton("5"));
        jPanel.add(new JButton("6"));
        jPanel.add(new JButton("*"));
        jPanel.add(new JButton("1"));
        jPanel.add(new JButton("2"));
        jPanel.add(new JButton("3"));
        jPanel.add(new JButton("-"));
        jPanel.add(new JButton("0"));
        jPanel.add(new JButton("."));
        jPanel.add(new JButton("="));
        jPanel.add(new JButton("+"));
        jFrame.add(jPanel);    //添加面板到容器
        jFrame.setBounds(300,200,400,400);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public  static void createCall ( ){
        JFrame frame=new JFrame("拨号盘");
        GridBagLayout gbaglayout=new GridBagLayout();    //创建GridBagLayout布局管理器
        GridBagConstraints constraints=new GridBagConstraints();
        frame.setLayout(gbaglayout);    //使用GridBagLayout布局管理器
        constraints.fill=GridBagConstraints.BOTH;    //组件填充显示区域
        constraints.weightx=0.0;    //恢复默认值
        constraints.gridwidth = GridBagConstraints.REMAINDER;    //结束行
        JTextField tf=new JTextField("13612345678");
        gbaglayout.setConstraints(tf, constraints);
        frame.add(tf);
        constraints.weightx=0.5;    // 指定组件的分配区域
        constraints.weighty=0.2;
        constraints.gridwidth=1;
        for (int i = 2  ; i < 0; i--) {

            for (int j = 1; j <= 3; j++) {
                JButton button=new JButton( ""+(i*3 +j));    //创建Button对象
                gbaglayout.setConstraints(button,constraints);
                frame.add(button);
            }
            constraints.gridwidth=GridBagConstraints.REMAINDER;    //结束行
            constraints.gridwidth=1;    //重新设置gridwidth的值

        }

        JButton retButton=new JButton("返回");    //创建Button对象
        gbaglayout.setConstraints(retButton,constraints);
        frame.add(retButton);
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        JButton button=new JButton("拨号");    //创建Button对象
        gbaglayout.setConstraints(button,constraints);
        frame.add(button);
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        constraints.gridwidth=1;
        frame.setBounds(400,400,400,400);    //设置容器大小
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




    public  static void creteNotepad ( ){
        JFrame jFrame=new JFrame("Java文本域组件示例");    //创建Frame窗口
        JPanel jPanel=new JPanel();    //创建一个JPanel对象
        JTextArea jTextArea=new JTextArea("请输入内容",7,30);
        jTextArea.setLineWrap(true);    //设置文本域中的文本为自动换行
        jTextArea.setForeground(Color.BLACK);    //设置组件的背景色
        jTextArea.setFont(new Font("黑体",Font.BOLD,16));    //修改字体样式
        jTextArea.setBackground(Color.WHITE);    //设置按钮背景色
        JScrollPane jScrollPane=new JScrollPane(jTextArea);    //将文本域放入滚动窗口
        Dimension size=jTextArea.getPreferredSize();    //获得文本域的首选大小
        jScrollPane.setBounds(110,90,size.width,size.height);
        jPanel.add(jScrollPane);    //将JScrollPane添加到JPanel容器中
        jPanel.setBackground(Color.white);
        jFrame.add(jPanel);    //将JPanel容器添加到JFrame容器中
        jFrame.setBackground(Color.WHITE);
        jFrame.setSize(400,200);    //设置JFrame容器的大小
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public  static void checkBoxForm ( ){
        JFrame jFrame=new JFrame("Java复选组件示例");    //创建Frame窗口
        JPanel jPanel=new JPanel();    //创建面板
        JLabel jLabel=new JLabel("流行编程语言有：");
        jLabel.setFont(new Font("黑体",Font.BOLD,16));    //修改字体样式
        JCheckBox jCheckBox1=new JCheckBox("C#", true);    //创建指定文本和状态的复选框
        JCheckBox jCheckBox2=new JCheckBox("C++");    //创建指定文本的复选框
        JCheckBox jCheckBox3=new JCheckBox("Java");    //创建指定文本的复选框
        JCheckBox jCheckBox4=new JCheckBox("Python");    //创建指定文本的复选框
        JCheckBox jCheckBox5=new JCheckBox("PHP");    //创建指定文本的复选框
        JCheckBox jCheckBox6=new JCheckBox("golang");    //创建指定文本的复选框
        jPanel.add(jLabel);
        jPanel.add(jCheckBox1);
        jPanel.add(jCheckBox2);
        jPanel.add(jCheckBox3);
        jPanel.add(jCheckBox4);
        jPanel.add(jCheckBox5);
        jPanel.add(jCheckBox6);
        jPanel.setBackground(Color.white);
        jFrame.add(jPanel);
        jFrame.setBounds(300,200,400,100);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public  static void radioForm ( ){
        JFrame jFrame=new JFrame("Java单选组件示例");    //创建Frame窗口
        JPanel jPanel=new JPanel();    //创建面板
        JLabel label1=new JLabel("现在是哪个季节：");
        JRadioButton rb1=new JRadioButton("春天");    //创建JRadioButton对象
        JRadioButton rb2=new JRadioButton("夏天");    //创建JRadioButton对象
        JRadioButton rb3=new JRadioButton("秋天",true);    //创建JRadioButton对象
        JRadioButton rb4=new JRadioButton("冬天");    //创建JRadioButton对象
        label1.setFont(new Font("黑体",Font.BOLD,16));    //修改字体样式
        ButtonGroup group=new ButtonGroup();
        //添加JRadioButton到ButtonGroup中
        group.add(rb1);
        group.add(rb2);
        jPanel.add(label1);
        jPanel.add(rb1);
        jPanel.add(rb2);
        jPanel.add(rb3);
        jPanel.add(rb4);
        jPanel.setBackground(Color.WHITE);
        jFrame.add(jPanel);
        jFrame.setBounds(300, 200, 400, 100);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public  static void selectForm ( ){
        JFrame jFrame=new JFrame("Java下拉列表组件示例");
        JPanel jPanel=new JPanel();    //创建面板
        JLabel label1=new JLabel("证件类型：");    //创建标签
        JComboBox cmb=new JComboBox();    //创建JComboBox
        cmb.addItem("--请选择--");    //向下拉列表中添加一项
        cmb.addItem("身份证");
        cmb.addItem("驾驶证");
        cmb.addItem("军官证");
        jPanel.add(label1);
        jPanel.add(cmb);
        jPanel.setBackground(Color.white);
        jFrame.add(jPanel);
        jFrame.setBounds(300,200,400,100);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public  static void jListForm ( ){
        JFrame frame=new JFrame("Java列表框组件示例");
        JPanel jp=new JPanel();    //创建面板
        JLabel label1=new JLabel("证件类型：");    //创建标签
        String[] items=new String[]{"身份证","驾驶证","军官证"};
        JList list=new JList(items);    //创建JList
        jp.add(label1);
        jp.add(list);
        frame.add(jp);
        frame.setBounds(300,200,400,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }











}
