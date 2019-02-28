/**
 * Copyright (C), 2017-2018, DaLian
 * FileName: Manage.java
 * 
 * @author 韩晨晨
 * @Date 2018年7月18日 上午1:16:57
 * @version 1.0.0
*/
package cn.jhl.smms.ui;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

//import static net.mindview.until.SwingConsole.*;

import cn.jhl.smms.dao.impl.AthleteDaoSQLServerImpl;
import cn.jhl.smms.entity.*;

/**
 * 功能描述：
 * 
 * @author 韩晨晨
 * @Date 2018年7月18日 上午1:16:57
 * @version 1.0.0
 */
public class Manage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static AthletePanel ap = new AthletePanel(); // 运动员面板
	public static OperateAthlete oa = new OperateAthlete();
	public static GroupsPanel gp = new GroupsPanel();
	public static OperateGroups og = new OperateGroups();
	public static SportPanel sp = new SportPanel();
	public static OperateSport os = new OperateSport();
	public static ComschedulePanel csp = new ComschedulePanel();
	public static OperateComschedule ocs = new OperateComschedule();
	public static ComreltPanel crp = new ComreltPanel();
	public static OperateComrelt ocr = new OperateComrelt();
	public static ReferPanel rp = new ReferPanel();
	public static OperateRefer or = new OperateRefer();

	
	public static JPanel athlete = new JPanel();
	public static JPanel groups = new JPanel();
	public static JPanel sport = new JPanel();
	public static JPanel comschedule = new JPanel();
	public static JPanel comrelt = new JPanel();
	public static JPanel refer = new JPanel();
	
	private JTabbedPane tabp = new JTabbedPane();

	public Manage() {
		setTitle("运动会管理系统");
		this.setSize(1000, 500);
	
		athlete.add(ap);
		athlete.add(oa);
		tabp.addTab("运动员", null, athlete);

		groups.add(gp);
		groups.add(og);
		tabp.addTab("参赛团体", null, groups);
		
		//sport.setLayout(new GridLayout(1,2));
		sport.add(sp);
		sport.add(os);
		tabp.addTab("赛事信息", null, sport);

		comschedule.add(csp);
		comschedule.add(ocs);
		tabp.addTab("比赛日程", null, comschedule);

		comrelt.add(crp);
		comrelt.add(ocr);
		tabp.addTab("比赛成绩", null, comrelt);

		refer.add(rp);
		refer.add(or);
		tabp.addTab("裁判信息", null, refer);

		add(tabp);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}