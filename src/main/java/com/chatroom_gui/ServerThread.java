package com.chatroom_gui;

import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.JTextArea;
/**
 * 聊天监听处理线程类
 * @author Administrator
 */
public class ServerThread extends Thread {
	//聊天记录框
	JTextArea txtare;
	//端口框
	JTextField txtF;

	public ServerThread(JTextArea txtare1, JTextField txtFile) {
		this.txtare = txtare1;
		this.txtF = txtFile;
	}

	@Override
	public void run() {
		int port;
		port = Integer.parseInt(txtF.getText());
		ServerSocket server;
		Socket socket=null;
		String line;
		BufferedReader br;
		try {
			server = new ServerSocket(port);
			do {
//				System.out.println("服务已启动！");=cm,d xc

			} while (false );
			socket.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
