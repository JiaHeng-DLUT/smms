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

import cn.jhl.smms.dao.impl.ReferDaoSQLServerImpl;
import cn.jhl.smms.entity.Refer;

/**
 * 功能描述：
 * 
 * @author 贾恒
 * @Date 2018年7月19日 下午1:11:36
 * @version 1.0.0
 */
public class ReferPanel extends JPanel {
	// JButton updateButton = new JButton("刷新");
	private String[] heads = { "裁判编号","裁判姓名","级别","负责赛事" };
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

	public ReferPanel() {
		table.getTableHeader().setReorderingAllowed(false);
		scrollpane.setBounds(100, 10, 400, 300);
		add(scrollpane);
		setVisible(true);
	}

	public void showRefer(List<Refer> list) {
		int i = 0;
		while (list.get(i) != null) {
			model.addRow(new Object[] { list.get(i).getReferid(),list.get(i).getRefername(),list.get(i).getLevel(),list.get(i).getRecomptn() });
			i++;
		}
	}
}

class OperateRefer extends JPanel {
	int count = 4; // 列数
	int i; // 计数变量

	String[] heads = { "赛事编号", "赛事名称", "世界纪录", "本赛事历史记录" };

	JButton addButton = new JButton("录入"), deleteButton = new JButton("删除"), updateButton = new JButton("更改"),
			selectButton = new JButton("查找");

	JLabel jlabel[] = new JLabel[count];
	JTextField jtextfield[] = new JTextField[count];

	ReferDaoSQLServerImpl cdssi = new ReferDaoSQLServerImpl();

	ActionListener addAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null && jtextfield[1].getText() != null) {
				Refer refer = new Refer();
				refer.set(jtextfield[0].getText(), jtextfield[1].getText(), jtextfield[2].getText(),
						jtextfield[3].getText());
				if (cdssi.save(refer) != 0) {
					JOptionPane.showMessageDialog(null, "信息录入成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息录入失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "裁判编号和姓名不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	ActionListener deleteAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null) {
				Refer refer = new Refer();
				refer.setReferid(jtextfield[0].getText());
				if (cdssi.del(refer) != 0) {
					JOptionPane.showMessageDialog(null, "信息删除成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息删除失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "裁判编号和姓名不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	ActionListener updateAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (jtextfield[0].getText() != null && jtextfield[1].getText() != null && jtextfield[2].getText() != null
					&& jtextfield[3].getText() != null) {
				Refer refer = new Refer();
				/**
				 * 仅更新有输入的数据项
				 */
				if (jtextfield[0].getText() != null) {
					refer.setReferid(jtextfield[0].getText());
				}
				if (jtextfield[1].getText() != null) {
					refer.setRefername(jtextfield[1].getText());
				}
				if (jtextfield[2].getText() != null) {
					refer.setLevel(jtextfield[2].getText());
				}
				if (jtextfield[3].getText() != null) {
					refer.setRecomptn(jtextfield[3].getText());
				}

				if (cdssi.update(refer) != 0) {
					JOptionPane.showMessageDialog(null, "信息更新成功", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "信息更新失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				for (i = 0; i < count; i++) {
					jtextfield[i].setText(null);
				}
			} else {
				JOptionPane.showMessageDialog(null, "裁判编号和姓名不能为空，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	ActionListener selectAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			List<Refer> list = cdssi.getAll();
			if (jtextfield[0].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getReferid() != jtextfield[0].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[1].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getRefername() != jtextfield[1].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[2].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getLevel() != jtextfield[2].getText()) {
						list.remove(i);
					}
				}
			}
			if (jtextfield[3].getText() != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getRecomptn() != jtextfield[3].getText()) {
						list.remove(i);
					}
				}
			}

			if(list!=null) {
				// 显示list
				ReferPanel sp = new ReferPanel();
				sp.showRefer(list);
			}
			else {
				JOptionPane.showMessageDialog(null, "查找失败，未查找到相关信息！", "提示", JOptionPane.ERROR_MESSAGE);
			}
			for (i = 0; i < count; i++) {
				jtextfield[i].setText(null);
			}
		}
	};

	public OperateRefer() {
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

