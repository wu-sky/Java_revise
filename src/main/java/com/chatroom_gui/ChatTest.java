package com.chatroom_gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.*;
import java.io.*;
/**
 * 一个简单的聊天程序
 */
public class ChatTest {
 
	private JFrame frame;
	private JTextField ipF1;
	private JTextField portF2;
	private JTextArea txtare1;
	private JTextArea txtare2;
 
	public static void main(String[] args) {
		//线程延迟调用功能
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatTest window = new ChatTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 * 构造函数
	 */
	public ChatTest() {
		initialize();
	}
 
	/**
	 * 初始化程序窗口
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//没有设置布局，控件通过setBounds(10, 10, 54, 15)进行绝对定位
		frame.getContentPane().setLayout(null);
		
		JLabel idLabel = new JLabel("IP地址:");
		idLabel.setBounds(10, 10, 54, 15);
		frame.getContentPane().add(idLabel);
		
		ipF1 = new JTextField();
		ipF1.setText("127.0.0.1");
		ipF1.setBounds(55, 7, 90, 21);
		frame.getContentPane().add(ipF1);
		ipF1.setColumns(10);
		
		JLabel portLb = new JLabel("端口:");
		portLb.setBounds(177, 10, 54, 15);
		frame.getContentPane().add(portLb);
		
		portF2 = new JTextField();
		portF2.setText("8898");
		portF2.setBounds(215, 7, 66, 21);
		frame.getContentPane().add(portF2);
		portF2.setColumns(10);
		
		JScrollPane scpl1 = new JScrollPane();
		scpl1.setBounds(10, 36, 414, 274);
		frame.getContentPane().add(scpl1);
		
		txtare1 = new JTextArea();
		scpl1.setViewportView(txtare1);
		
		JScrollPane scpl2 = new JScrollPane();
		scpl2.setBounds(10, 332, 414, 83);
		frame.getContentPane().add(scpl2);
		
		txtare2 = new JTextArea();
		scpl2.setViewportView(txtare2);
		
		JButton bt1 = new JButton("关闭窗口");
		//增加事件监听
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		bt1.setBounds(40, 428, 93, 23);
		frame.getContentPane().add(bt1);
		
		JButton bt2 = new JButton("发送消息");
		//增加消息发送监听
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//------------------------------------------------------------------------------------------------
				String host=ipF1.getText();//目录IP地址
				int port=Integer.parseInt(portF2.getText());
				try {
					Socket client=new Socket(host,port);
					Writer wt=new OutputStreamWriter(client.getOutputStream());
					wt.write(txtare2.getText());
					wt.flush();
					wt.close();
					client.close();
					txtare2.setText(null);//清空消息框
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
					System.out.println("服务器连接失败！");
				}
			}
			//---------------------------------------------------------------------------------------------------------
		});
		bt2.setBounds(294, 428, 93, 23);
		frame.getContentPane().add(bt2);
		
		JButton bt3 = new JButton("启动服务监听");
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServerThread st=new ServerThread(txtare1,portF2);
				st.start();
			}
		});
		bt3.setBounds(300, 6, 113, 23);
		frame.getContentPane().add(bt3);
	}
}
