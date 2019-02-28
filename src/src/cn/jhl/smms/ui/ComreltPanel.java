/**
 * 
 */
package cn.jhl.smms.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.jhl.smms.dao.impl.ComreltDaoSQLServerImpl;
import cn.jhl.smms.entity.Comrelt;

/**
 * 功能描述：
 * 
 * @author 贾恒
 * @Date 2018年7月19日 上午10:37:56
 * @version 1.0.0
 */
public class ComreltPanel extends JPanel {
	// JButton updateButton = new JButton("刷新");
	private String[] heads = { "比赛编号", "赛事名称", "运动员编号", "运动员姓名", "比赛级别", "名次", "成绩" };
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

	public ComreltPanel() {
		table.getTableHeader().setReorderingAllowed(false);
		scrollpane.setBounds(100, 10, 400, 300);
		add(scrollpane);
		setVisible(true);
	}

	public void showComrelt(List<Comrelt> list) {
		int i = 0;
		while (list.get(i) != null) {
			model.addRow(new Object[] { list.get(i).getComsnum(), list.get(i).getComname(), list.get(i).getAthnum(),
					list.get(i).getAthename(), list.get(i).getComlevel(), list.get(i).getPosition(),
					list.get(i).getAchment() });
			i++;
		}
	}
}

class OperateComrelt extends JPanel {
	int count = 7; // 列数
	int i; // 计数变量

	String[] heads = { "赛事编号", "赛事名称", "世界纪录", "本赛事历史记录" };

	JButton addButton = new JButton("录入"), deleteButton = new JButton("删除"), updateButton = new JButton("更改"),
			selectButton = new JButton("查找");

	JLabel jlabel[] = new JLabel[count];
	JTextField jtextfield[] = new JTextField[count];

	ComreltDaoSQLServerImpl cdssi = new ComreltDaoSQLServerImpl();

	ActionListener addAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null && jtextfield[1].getText() != null) {
				Comrelt comrelt = new Comrelt();
				comrelt.set(jtextfield[0].getText(), jtextfield[1].getText(), jtextfield[2].getText(),
						jtextfield[3].getText(), jtextfield[4].getText(), jtextfield[5].getText(),
						jtextfield[6].getText());
				if (cdssi.save(comrelt) != 0) {
					JOptionPane.showMessageDialog(null, "信息录入成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息录入失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "赛事编号和名称不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	ActionListener deleteAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null) {
				Comrelt comrelt = new Comrelt();
				comrelt.setComsnum(jtextfield[0].getText());
				if (cdssi.del(comrelt) != 0) {
					JOptionPane.showMessageDialog(null, "信息删除成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息删除失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "赛事编号不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	ActionListener updateAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null && jtextfield[1].getText() != null && jtextfield[2].getText() != null
					&& jtextfield[3].getText() != null) {
				Comrelt comrelt = new Comrelt();
				/**
				 * 仅更新有输入的数据项
				 */
				if (jtextfield[0].getText() != null) {
					comrelt.setComsnum(jtextfield[0].getText());
				}
				if (jtextfield[1].getText() != null) {
					comrelt.setComname(jtextfield[1].getText());
				}
				if (jtextfield[2].getText() != null) {
					comrelt.setAthnum(jtextfield[2].getText());
				}
				if (jtextfield[3].getText() != null) {
					comrelt.setAthename(jtextfield[3].getText());
				}
				if (jtextfield[4].getText() != null) {
					comrelt.setComlevel(jtextfield[4].getText());
				}
				if (jtextfield[5].getText() != null) {
					comrelt.setPosition(jtextfield[5].getText());
				}
				if (jtextfield[6].getText() != null) {
					comrelt.setAchment(jtextfield[6].getText());
				}

				if (cdssi.update(comrelt) != 0) {
					JOptionPane.showMessageDialog(null, "信息更新成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息更新失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "赛事编号、名称、运动员编号、姓名不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	ActionListener selectAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			List<Comrelt> list = cdssi.getAll();
			if (jtextfield[0].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getComsnum() != jtextfield[0].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[1].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getComname() != jtextfield[1].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[2].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getAthnum() != jtextfield[2].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[3].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getAthename() != jtextfield[3].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[4].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getComlevel() != jtextfield[4].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[5].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getPosition() != jtextfield[5].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[6].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getAchment() != jtextfield[6].getText()) {
						list.remove(i);
					}
				}
			}
			if(list!=null) {
				// 显示list
				ComreltPanel sp = new ComreltPanel();
				sp.showComrelt(list);
			}
			else {
				JOptionPane.showMessageDialog(null, "查找失败，未查找到相关信息！", "提示", JOptionPane.ERROR_MESSAGE);
			}
			for (i = 0; i < count; i++) {
				jtextfield[i].setText(null);
			}
		}
	};

	public OperateComrelt() {
		for (i = 0; i < count; i++) {
			jlabel[i] = new JLabel(heads[i]);
		}
		for (i = 0; i < count; i++) {
			jtextfield[i] = new JTextField(20);
		}
		setLayout(new GridLayout(i + 2, 2));
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
