/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: ComscheduleDao.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:53:12
 * @version 1.0.0
*/
package cn.jhl.smms.dao;

import java.util.List;

import cn.jhl.smms.entity.Comrelt;
import cn.jhl.smms.entity.Comschedule;

/**
 * 功能描述：比赛日程Dao接口
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:53:12
 * @version 1.0.0
 */

public interface ComscheduleDao {
	/**
	 * 
	 * 功能描述：保存比赛日程
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:32:03
	 * @version 1.0.0
	 * 
	 * @param comschedule 比赛日程
	 * @return
	 */
	int save(Comschedule comschedule);

	/**
	 * 
	 * 功能描述：删除比赛日程
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:32:29
	 * @version 1.0.0
	 * 
	 * @param comschedule 比赛日程
	 * @return
	 */
	int del(Comschedule comschedule);

	/**
	 * 
	 * 功能描述：更新比赛日程
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:32:37
	 * @version 1.0.0
	 * 
	 * @param comschedule 比赛日程
	 * @return
	 */
	int update(Comschedule comschedule);

	/**
	 * 
	 * 功能描述：根据比赛日期获取比赛日程列表
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:32:50
	 * @version 1.0.0
	 * 
	 * @param comsdate 比赛日期
	 * @return List<Comschedule> 比赛列表
	 */
	List<Comschedule> getAll();
	List<Comschedule> getByComsdate(String comsdate);

	/**
	 * 
	 * 功能描述：根据项目名称获取比赛日程列表
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:33:32
	 * @version 1.0.0
	 * 
	 * @param sportname 项目名称
	 * @return List<Comschedule> 比赛列表
	 */
	List<Comschedule> getBySportname(String sportname);

	/**
	 * 
	 * 功能描述：根据比赛地点获取比赛日程列表
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:33:45
	 * @version 1.0.0
	 * 
	 * @param comsaddr 比赛地点
	 * @return List<Comschedule> 比赛列表
	 */
	List<Comschedule> getByComsaddr(String comsaddr);
}
