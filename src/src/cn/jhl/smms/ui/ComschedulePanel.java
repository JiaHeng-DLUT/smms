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

import cn.jhl.smms.dao.impl.ComscheduleDaoSQLServerImpl;
import cn.jhl.smms.entity.Comschedule;

/**
 * 功能描述：
 * 
 * @author 贾恒
 * @Date 2018年7月19日 下午12:50:12
 * @version 1.0.0
 */
public class ComschedulePanel extends JPanel {
	// JButton updateButton = new JButton("刷新");
	private String[] heads = { "比赛编号","比赛时间","比赛日期","赛事名称","比赛地点","参赛人数","比赛级别","组别","主裁判" };
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

	public ComschedulePanel() {
		table.getTableHeader().setReorderingAllowed(false);
		scrollpane.setBounds(100, 10, 400, 300);
		add(scrollpane);
		setVisible(true);
	}

	public void showComschedule(List<Comschedule> list) {
		int i = 0;
		while (list.get(i) != null) {
			model.addRow(new Object[] { list.get(i).getComsnum(),list.get(i).getComsdate(),list.get(i).getComstime(),list.get(i).getSportname(),list.get(i).getComsaddr(),list.get(i).getPathamt(),list.get(i).getGroups(),list.get(i).getComlevel(),list.get(i).getRefername() });
			i++;
		}
	}
}

class OperateComschedule extends JPanel {
	int count = 9; // 列数
	int i; // 计数变量

	String[] heads = {"赛事编号","比赛日期","比赛时间","赛事名称","比赛地点","参赛人数","比赛级别","组别","主裁判"  };

	JButton addButton = new JButton("录入"), deleteButton = new JButton("删除"), updateButton = new JButton("更改"),
			selectButton = new JButton("查找");

	JLabel jlabel[] = new JLabel[count];
	JTextField jtextfield[] = new JTextField[count];

	ComscheduleDaoSQLServerImpl cdssi = new ComscheduleDaoSQLServerImpl();

	ActionListener addAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null && jtextfield[1].getText() != null &&jtextfield[3].getText() != null) {
				Comschedule comschedule = new Comschedule();
				comschedule.set(jtextfield[0].getText(), jtextfield[1].getText(), jtextfield[2].getText(),
						jtextfield[3].getText(), jtextfield[4].getText(), jtextfield[5].getText(),
						jtextfield[6].getText(),jtextfield[7].getText(),jtextfield[8].getText());
				if (cdssi.save(comschedule) != 0) {
					JOptionPane.showMessageDialog(null, "信息录入成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息录入失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "赛事编号，比赛日期和项目名称不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	ActionListener deleteAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null) {
				Comschedule comschedule = new Comschedule();
				comschedule.setComsnum(jtextfield[0].getText());
				if (cdssi.del(comschedule) != 0) {
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
				Comschedule comschedule = new Comschedule();
				/**
				 * 仅更新有输入的数据项
				 */
				if (jtextfield[0].getText() != null) {
					comschedule.setComsnum(jtextfield[0].getText());
				}
				if (jtextfield[1].getText() != null) {
					comschedule.setComsdate(jtextfield[1].getText());
				}
				if (jtextfield[2].getText() != null) {
					comschedule.setComstime(jtextfield[2].getText());
				}
				if (jtextfield[3].getText() != null) {
					comschedule.setSportname(jtextfield[3].getText());
				}
				if (jtextfield[4].getText() != null) {
					comschedule.setComsaddr(jtextfield[4].getText());
				}
				if (jtextfield[5].getText() != null) {
					comschedule.setPathamt(jtextfield[5].getText());
				}
				if (jtextfield[6].getText() != null) {
					comschedule.setGroups(jtextfield[6].getText());
				}
				if (jtextfield[7].getText() != null) {
					comschedule.setComlevel(jtextfield[6].getText());
				}
				if (jtextfield[8].getText() != null) {
					comschedule.setRefername(jtextfield[6].getText());
				}

				if (cdssi.update(comschedule) != 0) {
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
			List<Comschedule> list = cdssi.getAll();
			if (jtextfield[0].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getComsnum() != jtextfield[0].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[1].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getComsdate() != jtextfield[1].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[2].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getComstime() != jtextfield[2].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[3].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getSportname() != jtextfield[3].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[4].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getComsaddr() != jtextfield[4].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[5].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getPathamt() != jtextfield[5].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[6].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getGroups() != jtextfield[6].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[7].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getComlevel() != jtextfield[7].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[8].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getRefername() != jtextfield[8].getText()) {
						list.remove(i);
					}
				}
			}
			if(list!=null) {
				// 显示list
				ComschedulePanel sp = new ComschedulePanel();
				sp.showComschedule(list);
			}
			else {
				JOptionPane.showMessageDialog(null, "查找失败，未查找到相关信息！", "提示", JOptionPane.ERROR_MESSAGE);
			}
			for (i = 0; i < count; i++) {
				jtextfield[i].setText(null);
			}
		}
	};

	public OperateComschedule() {
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

