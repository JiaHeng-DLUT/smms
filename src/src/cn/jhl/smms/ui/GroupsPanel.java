/**
 * 
 */
package cn.jhl.smms.ui;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import cn.jhl.smms.dao.impl.*;
import cn.jhl.smms.entity.*;

/**
 * 功能描述：
 * 
 * @author 贾恒
 * @Date 2018年7月19日 下午1:32:49
 * @version 1.0.0
 */
public class GroupsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	//JButton updateButton = new JButton("刷新");
	private String[] heads = { "团体编号", "名称", "运动员人数", "金牌数", "银牌数", "铜牌数" };
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

	
	public GroupsPanel() {
		table.getTableHeader().setReorderingAllowed(false);
		scrollpane.setBounds(100, 10, 400, 300);
		add(scrollpane);
		setVisible(true);
	}
	public void showGroups(List<Groups> list) {
		int i = 0;
		while (list.get(i) != null) {
			model.addRow(new Object[] { list.get(i).getGnum(),list.get(i).getGname(),list.get(i).getAnum(),list.get(i).getGoldnum(),list.get(i).getSilvernum(),list.get(i).getCoppernum() });
			i++;
		}
	}
}
class OperateGroups extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int count = 6; // 列数
	int i; // 计数变量

	String[] heads = { "团体编号", "名称", "运动员人数", "金牌数", "银牌数", "铜牌数" };

	JButton addButton = new JButton("录入"), deleteButton = new JButton("删除"), updateButton = new JButton("更改"),
			selectButton = new JButton("查找");

	JLabel jlabel[] = new JLabel[count];
	JTextField jtextfield[] = new JTextField[count];

	GroupsDaoSQLServerImpl sdssi = new GroupsDaoSQLServerImpl();
	

    ActionListener addAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null && jtextfield[1].getText() != null) {
				Groups groups = new Groups();
				groups.set(jtextfield[0].getText(), jtextfield[1].getText(), jtextfield[2].getText(),
						jtextfield[3].getText(),jtextfield[4].getText(),jtextfield[5].getText());
				if (sdssi.save(groups) != 0) {
					JOptionPane.showMessageDialog(null, "信息录入成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息录入失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "参赛团体编号和名称不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};
	ActionListener deleteAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null) {
				Groups groups = new Groups();
				groups.setGnum(jtextfield[0].getText());
				if (sdssi.del(groups) != 0) {
					JOptionPane.showMessageDialog(null, "信息删除成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息删除失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "参赛团体编号不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	ActionListener updateAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null) {
				Groups groups = new Groups();
				/**
				 * 仅更新有输入的数据项
				 */
				if (jtextfield[0].getText() != null) {
					groups.setGnum(jtextfield[0].getText());
				}
				if (jtextfield[1].getText() != null) {
					groups.setGname(jtextfield[1].getText());
				}
				if (jtextfield[2].getText() != null) {
					groups.setAnum(jtextfield[2].getText());
				}
				if (jtextfield[3].getText() != null) {
					groups.setGoldnum(jtextfield[3].getText());
				}
				if (jtextfield[4].getText() != null) {
					groups.setSilvernum(jtextfield[4].getText());
				}
				if (jtextfield[5].getText() != null) {
					groups.setCoppernum(jtextfield[5].getText());
				}

				if (sdssi.update(groups) != 0) {
					JOptionPane.showMessageDialog(null, "信息更新成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息更新失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "参赛团体编号不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	ActionListener selectAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			List<Groups> list = sdssi.getAll();
			// 查询
			if (jtextfield[0].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getGnum() != jtextfield[0].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[1].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getGname() != jtextfield[1].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[2].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getAnum() != jtextfield[2].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[3].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getGoldnum() != jtextfield[3].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[4].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getSilvernum() != jtextfield[4].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[5].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getCoppernum() != jtextfield[5].getText()) {
						list.remove(i);
					}
				}
			}

			if(list!=null) {
				// 显示list
				GroupsPanel sp = new GroupsPanel();
				sp.showGroups(list);
			}
			else {
				JOptionPane.showMessageDialog(null, "查找失败，未查找到相关信息！", "提示", JOptionPane.ERROR_MESSAGE);
			}
			for (i = 0; i < count; i++) {
				jtextfield[i].setText(null);
			}
		}
	};
	public OperateGroups() {
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