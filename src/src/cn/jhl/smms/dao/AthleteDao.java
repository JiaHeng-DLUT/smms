/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: AthleteDao.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:46:02
 * @version 1.0.0
 */
package cn.jhl.smms.dao;

import java.util.List;

import cn.jhl.smms.entity.Athlete;
import cn.jhl.smms.entity.Comrelt;

/**
 * 功能描述：运动员Dao接口
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:46:02
 * @version 1.0.0
 */

public interface AthleteDao {
	/**
	 * 
	 * 功能描述：保存运动员
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:35:34
	 * @version 1.0.0
	 * 
	 * @param athlete 运动员
	 * @return
	 */
	int save(Athlete athlete);

	/**
	 * 
	 * 功能描述：删除运动员
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:35:50
	 * @version 1.0.0
	 * 
	 * @param athlete 运动员
	 * @return
	 */
	int del(Athlete athlete);

	/**
	 * 
	 * 功能描述：更新运动员
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:36:00
	 * @version 1.0.0
	 * 
	 * @param athlete 运动员
	 * @return
	 */
	int update(Athlete athlete);

	/**
	 * 
	 * 功能描述：根据运动员编号获取运动员列表
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:36:08
	 * @version 1.0.0
	 * 
	 * @param aid 运动员编号
	 * @return List<Athlete> 运动员列表
	 */
	
	List<Athlete> getAll();
	
	List<Athlete> getByAid(String aid);

	/**
	 * 
	 * 功能描述：根据运动员姓名获取运动员列表
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:37:08
	 * @version 1.0.0
	 * 
	 * @param aname 运动员姓名
	 * @return List<Athlete> 运动员列表
	 */
	List<Athlete> getByAname(String aname);

	/**
	 * 
	 * 功能描述：根据所属团体获取运动员列表
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:37:15
	 * @version 1.0.0
	 * 
	 * @param gnum 所属团体
	 * @return List<Athlete> 运动员列表
	 */
	List<Athlete> getByGnum(String gnum);
}
