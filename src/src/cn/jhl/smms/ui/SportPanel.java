/**
 * 
 */
package cn.jhl.smms.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import cn.jhl.smms.dao.impl.SportDaoSQLServerImpl;
import cn.jhl.smms.entity.*;

/**
 * 功能描述：
 * 
 * @author 贾恒
 * @Date 2018年7月18日 下午8:13:32
 * @version 1.0.0
 */
public class SportPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JButton updateButton = new JButton("刷新");
	private String[] heads = { "赛事编号", "赛事名称", "世界纪录", "本赛事历史记录" };
	private DefaultTableModel model = new DefaultTableModel(null, heads);
	private JTable table = new JTable(model) {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5375350605889042628L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	JScrollPane scrollpane = new JScrollPane(table);

	public SportPanel() {
		table.getTableHeader().setReorderingAllowed(false);
		scrollpane.setBounds(100, 10, 400, 300);
		add(scrollpane);
		setVisible(true);
	}

	public void showSport(List<Sport> list) {
		int i = 0;
		while (list.get(i) != null) {
			model.addRow(new Object[] { list.get(i).getSnum(),list.get(i).getSname(),list.get(i).getWrecord(),list.get(i).getLhrecord() });
			i++;
		}
	}
}

class OperateSport extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int count = 4; // 列数
	int i; // 计数变量

	String[] heads = { "赛事编号", "赛事名称", "世界纪录", "本赛事历史记录" };

	JButton addButton = new JButton("录入"), deleteButton = new JButton("删除"), updateButton = new JButton("更改"),
			selectButton = new JButton("查找");

	JLabel jlabel[] = new JLabel[count];
	JTextField jtextfield[] = new JTextField[count];

	SportDaoSQLServerImpl sdssi = new SportDaoSQLServerImpl();
	

	ActionListener addAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null && jtextfield[1].getText() != null) {
				Sport sport = new Sport();
				sport.set(jtextfield[0].getText(), jtextfield[1].getText(), jtextfield[2].getText(),
						jtextfield[3].getText());
				if (sdssi.save(sport) != 0) {
					JOptionPane.showMessageDialog(null, "信息录入成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息录入失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "比赛项目编号和名称不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	ActionListener deleteAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null) {
				Sport sport = new Sport();
				sport.setSnum(jtextfield[0].getText());
				if (sdssi.del(sport) != 0) {
					JOptionPane.showMessageDialog(null, "信息删除成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息删除失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "比赛项目编号不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	ActionListener updateAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null) {
				Sport sport = new Sport();
				/**
				 * 仅更新有输入的数据项
				 */
				if (jtextfield[0].getText() != null) {
					sport.setSnum(jtextfield[0].getText());
				}
				if (jtextfield[1].getText() != null) {
					sport.setSname(jtextfield[1].getText());
				}
				if (jtextfield[2].getText() != null) {
					sport.setWrecord(jtextfield[2].getText());
				}
				if (jtextfield[3].getText() != null) {
					sport.setWrecord(jtextfield[3].getText());
				}

				if (sdssi.update(sport) != 0) {
					JOptionPane.showMessageDialog(null, "信息更新成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息更新失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "比赛项目编号不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	ActionListener selectAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			List<Sport> list = sdssi.getAll();
			if (jtextfield[0].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getSnum() != jtextfield[0].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[1].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getSname() != jtextfield[1].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[2].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getWrecord() != jtextfield[2].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[3].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getLhrecord() != jtextfield[3].getText()) {
						list.remove(i);
					}
				}
			}
			
			if(list!=null) {
				// 显示list
				SportPanel sp = new SportPanel();
				sp.showSport(list);
			}
			else {
				JOptionPane.showMessageDialog(null, "查找失败，未查找到相关信息！", "提示", JOptionPane.ERROR_MESSAGE);
			}
			for (i = 0; i < count; i++) {
				jtextfield[i].setText(null);
			}
		}
	};

	public OperateSport() {
		for (i = 0; i < count; i++) {
			jlabel[i] = new JLabel(heads[i]);
		}
		for (i = 0; i < count; i++) {
			jtextfield[i] = new JTextField(20);
		}
		setLayout(new GridLayout(i+2, 2));
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
