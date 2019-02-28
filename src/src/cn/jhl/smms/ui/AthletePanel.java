/**
 * Copyright (C), 2017-2018, DaLian
 * FileName: athlete.java
 * 
 * @author 韩晨晨
 * @Date 2018年7月18日 上午1:01:33
 * @version 1.0.0
*/
package cn.jhl.smms.ui;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
//import static net.mindview.until.SwingConsole.*;
import cn.jhl.smms.entity.*;
import cn.jhl.smms.dao.impl.*;
import cn.jhl.smms.ui.*;

/**
 * 功能描述：
 * 
 * @author 韩晨晨
 * @Date 2018年7月18日 上午1:01:33
 * @version 1.0.0
 */
public class AthletePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	//JButton updateButton = new JButton("刷新");
	private String[] heads = { "运动员编号", "姓名", "所属团体", "年龄", "性别", "参赛项目" };
	private DefaultTableModel model = new DefaultTableModel(null, heads);
	private JTable table = new JTable(model) {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	JScrollPane scrollpane = new JScrollPane(table);

	
	public AthletePanel() {
		table.getTableHeader().setReorderingAllowed(false);
		scrollpane.setBounds(100, 10, 400, 300);
		add(scrollpane);
		setVisible(true);
	}
	public void showAthlete(List<Athlete> list) {
		int i = 0;
		while (list.get(i) != null) {
			model.addRow(new Object[] { list.get(i).getAid(),list.get(i).getAname(),list.get(i).getGnum(),list.get(i).getAage(),list.get(i).getAsex(),list.get(i).getSnum() });
			i++;
		}
	}
}
class OperateAthlete extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int count = 6; // 列数
	int i; // 计数变量

	String[] heads = { "运动员编号", "运动员姓名", "所属团体","性别", "年龄","参赛项目"};

	JButton addButton = new JButton("录入"), deleteButton = new JButton("删除"), updateButton = new JButton("更改"),
			selectButton = new JButton("查找");

	JLabel jlabel[] = new JLabel[count];
	JTextField jtextfield[] = new JTextField[count];

	AthleteDaoSQLServerImpl sdssi = new AthleteDaoSQLServerImpl();
	

    ActionListener addAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null && jtextfield[1].getText() != null) {
				Athlete athlete = new Athlete();
				athlete.set(jtextfield[0].getText(), jtextfield[1].getText(), jtextfield[2].getText(),
						jtextfield[3].getText(),jtextfield[4].getText(),jtextfield[5].getText());
				if (sdssi.save(athlete) != 0) {
					JOptionPane.showMessageDialog(null, "信息录入成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息录入失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "运动员编号和运动员姓名不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};
	ActionListener deleteAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null) {
				Athlete athlete = new Athlete();
				athlete.setSnum(jtextfield[0].getText());
				if (sdssi.del(athlete) != 0) {
					JOptionPane.showMessageDialog(null, "信息删除成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息删除失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "运动员编号不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	ActionListener updateAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null) {
				Athlete athlete = new Athlete();
				/**
				 * 仅更新有输入的数据项
				 */
				if (jtextfield[0].getText() != null) {
					athlete.setAid(jtextfield[0].getText());
				}
				if (jtextfield[1].getText() != null) {
					athlete.setAname(jtextfield[1].getText());
				}
				if (jtextfield[2].getText() != null) {
					athlete.setGnum(jtextfield[2].getText());
				}
				if (jtextfield[3].getText() != null) {
					athlete.setAage(jtextfield[3].getText());
				}
				if (jtextfield[3].getText() != null) {
					athlete.setAsex(jtextfield[4].getText());
				}
				if (jtextfield[3].getText() != null) {
					athlete.setSnum(jtextfield[5].getText());
				}
				if (sdssi.update(athlete) != 0) {
					JOptionPane.showMessageDialog(null, "信息更新成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息更新失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "运动员编号不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	ActionListener selectAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			List<Athlete> list = sdssi.getAll();
			// 查询
			if (jtextfield[0].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getAid() != jtextfield[0].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[1].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getAname() != jtextfield[1].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[2].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getGnum() != jtextfield[2].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[3].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getAsex() != jtextfield[3].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[4].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getAage() != jtextfield[4].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[5].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getSnum() != jtextfield[5].getText()) {
						list.remove(i);
					}
				}
			}

			if(list!=null) {
				// 显示list
				AthletePanel sp = new AthletePanel();
				sp.showAthlete(list);
			}
			else {
				JOptionPane.showMessageDialog(null, "查找失败，未查找到相关信息！", "提示", JOptionPane.ERROR_MESSAGE);
			}
			for (i = 0; i < count; i++) {
				jtextfield[i].setText(null);
			}
		}
	};
	public OperateAthlete() {
		for (i = 0; i < count; i++) {
			jlabel[i] = new JLabel(heads[i]);
		}
		for (i = 0; i < count; i++) {
			jtextfield[i] = new JTextField(20);
		}
		setLayout(new GridLayout(count+2, 2));
		addButton.addActionListener(addAction);
		deleteButton.addActionListener(deleteAction);
		updateButton.addActionListener(updateAction);
		selectButton.addActionListener(selectAction);
		for (i = 0; i < count; i++) {
			add(jlabel[i]); 
			add(jtextfield[i]); 
		}
		
		add(addButton);
		add(deleteButton);
		add(updateButton);
		add(selectButton);
	}
}
