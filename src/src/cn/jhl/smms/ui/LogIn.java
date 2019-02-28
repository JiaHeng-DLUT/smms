/**
 * Copyright (C), 2017-2018, DaLian
 * FileName: LogIn.java
 * 
 * @author 韩晨晨
 * @Date 2018年7月17日 下午10:52:35
 * @version 1.0.0
*/
package cn.jhl.smms.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import cn.jhl.smms.dao.*;

/**
 * 功能描述：登录窗口
 * 
 * @author 贾恒
 * @Date 2018年7月17日 下午10:52:35
 * @version 1.0.0
 */
public class LogIn extends JFrame implements ActionListener {
	String DRIVER;
	String URL;
	String USER;
	String PASSWORD;
	private static final long serialVersionUID = 1L;
	JPanel logIn;// 登录窗口
	int i = 0;

	ImageIcon icon = new ImageIcon("picture/23.jpg"); // 背景图片
	JLabel tp = new JLabel(icon, JLabel.CENTER);

	JLabel j1 = new JLabel("用户名: ");
	JLabel j2 = new JLabel("密码: ");

	JButton b1 = new JButton("登录");
	// JButton b2 = new JButton("取 消");

	TextField t1 = new TextField(20);
	TextField t2 = new TextField(16);

	public LogIn() {
		try {
			Init();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	private void Init() throws Exception {
		BaseDao bd = new BaseDao();
		DRIVER = bd.getDriver();
		URL = bd.getUrl();
		USER = bd.getUser();
		PASSWORD = bd.getPassword();

		logIn = (JPanel) this.getContentPane();
		logIn.setLayout(null); // 清空窗口布局
		this.setTitle("系统登录");
		this.setResizable(false); // 设定窗口大小不可变
		this.setSize(360, 270);

		j1.setBounds(70, 40, 85, 30); // setBounds(x, y, width, height);
		j1.setFont(new java.awt.Font("Dialog", 0, 17)); // dialog: 字体, 0、1: 样式(1是粗体，0是平常的), 20: 字号

		j2.setBounds(70, 80, 85, 30);
		j2.setFont(new java.awt.Font("Dialog", 0, 17));

		t1.setBounds(155, 40, 150, 30);
		t1.setFont(new java.awt.Font("Dialog", 0, 15));
		// t1.setText("");

		t2.setBounds(155, 80, 150, 30);
		t2.setFont(new java.awt.Font("Dialog", 0, 14));
		// t2.setText("");

		b1.setBounds(135, 160, 90, 38);
		b1.setFont(new java.awt.Font("Dialog", 0, 17));
		b1.addActionListener(this);

		// b2.setBounds(190, 160, 90, 38);
		// b2.setFont(new java.awt.Font("Dialog", 0, 24));
		// b2.addActionListener(this);

		// tp.setText("");
		// tp.setSize(360, 270);

		JCheckBox bCheckBox = new JCheckBox("记住密码");
		bCheckBox.setSelected(true); // 设置默认选中
		bCheckBox.setBounds(70, 120, 130, 30);

		JCheckBox bCheckBox2 = new JCheckBox("自动登录");
		bCheckBox2.setBounds(200, 120, 130, 30);
		// 判断是否被选中
		// System.out.println(bCheckBox2.isSelected());

		logIn.add(j1, null);
		logIn.add(j2, null);

		logIn.add(t1, null);
		logIn.add(t2, null);

		logIn.add(b1, null);
		// logIn.add(b2, null);

		logIn.add(bCheckBox);
		logIn.add(bCheckBox2);

		logIn.add(tp, null);
		t2.setEchoChar('*');

		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}

	public void actionPerformed(ActionEvent e) {
		if (t1.getText().equals("")) { // 用户名为空
			JOptionPane.showMessageDialog(null, "请输入用户名!");
			t1.requestFocus();
			t2.setText(""); // 密码置空
		} else if (t2.getText().equals("")) { // 密码为空
			JOptionPane.showMessageDialog(null, "请输入密码！");
			t2.requestFocus();
		} else if (t1.getText().equals(USER) && t2.getText().equals(PASSWORD)) { // 用户名和密码均正确
			try {
				Class.forName(DRIVER);
				DriverManager.getConnection(URL, USER, PASSWORD);
				// bd.getConnection();
			} catch (Exception err) {
				err.printStackTrace();
				JOptionPane.showMessageDialog(null, "数据库连接出错！");
				return;
			}
			this.dispose(); // 本窗口消失
			new WelcomePanel(); // 显示欢迎窗口
		} else { // 用户名或密码输入错误
			i++;
			if (i == 3) {
				JOptionPane.showMessageDialog(null, "连续三次输入错误，系统自动关闭！");
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误，请重新输入！");
				t1.setText(""); // 用户名置空
				t2.setText(""); // 密码置空
				t1.requestFocus();
			}
		}
	}

	/**
	 * 功能描述：main方法
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 下午10:55:25
	 * @version 1.0.0
	 * 
	 * @param
	 * @return
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LogIn(); // 显示登录窗口
	}
}
