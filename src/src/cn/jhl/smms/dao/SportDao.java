/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: Sport.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:55:18
 * @version 1.0.0
*/
package cn.jhl.smms.dao;

import java.util.List;

import cn.jhl.smms.entity.Comrelt;
import cn.jhl.smms.entity.Sport;

/**
 * 功能描述：比赛项目Dao接口
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:55:18
 * @version 1.0.0
 */

public interface SportDao {
	/**
	 * 
	 * 功能描述：保存运动员
	 * 
	 * @author 贾恒
	 * @Date 2018-7-17 上午9:49:36
	 * @version 1.0.0
	 * 
	 * @param sport 运动员
	 * @return
	 */
	int save(Sport sport);

	/**
	 * 
	 * 功能描述：删除运动员
	 * 
	 * @author 贾恒
	 * @Date 2018-7-17 上午9:51:14
	 * @version 1.0.0
	 * 
	 * @param sport 运动员
	 * @return
	 */
	int del(Sport sport);

	/**
	 * 
	 * 功能描述：更新运动员
	 * 
	 * @author 贾恒
	 * @Date 2018-7-17 上午9:51:34
	 * @version 1.0.0
	 * 
	 * @param sport 运动员
	 * @return
	 */
	int update(Sport sport);

	/**
	 * 
	 * 功能描述：根据比赛项目编号获取比赛项目列表
	 * 
	 * @author 贾恒
	 * @Date 2018-7-17 上午10:00:57
	 * @version 1.0.0
	 * 
	 * @param snum 比赛项目编号
	 * @return List<Sport> 比赛项目列表
	 */
	List<Sport> getAll();
	List<Sport> getBySnum(String snum);

	/**
	 * 
	 * 功能描述：根据比赛项目名称获取比赛项目列表
	 * 
	 * @author 贾恒
	 * @Date 2018-7-17 上午10:01:55
	 * @version 1.0.0
	 * 
	 * @param sname 比赛项目名称
	 * @return List<Sport> 比赛项目列表
	 */
	List<Sport> getBySname(String sname);
}
