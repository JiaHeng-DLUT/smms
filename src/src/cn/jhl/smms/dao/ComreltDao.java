/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: ComreltDao.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:49:11
 * @version 1.0.0
*/
package cn.jhl.smms.dao;

import java.util.List;

import cn.jhl.smms.entity.Comrelt;

/**
 * 功能描述：比赛成绩Dao接口
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:49:11
 * @version 1.0.0
 */

public interface ComreltDao {
	/**
	 * 
	 * 功能描述：保存比赛成绩
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午9:54:50
	 * @version 1.0.0
	 * 
	 * @param comrelt 比赛成绩
	 * @return
	 */
	int save(Comrelt comrelt);

	/**
	 * 
	 * 功能描述：删除比赛成绩
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午9:55:35
	 * @version 1.0.0
	 * 
	 * @param comrelt 比赛成绩
	 * @return
	 */
	int del(Comrelt comrelt);

	/**
	 * 
	 * 功能描述：更新比赛成绩
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:01:07
	 * @version 1.0.0
	 * 
	 * @param comrelt 比赛成绩
	 * @return
	 */
	int update(Comrelt comrelt);

	/**
	 * 
	 * 功能描述：根据赛事编号获取比赛成绩列表
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:02:12
	 * @version 1.0.0
	 * 
	 * @param comsnum 赛事编号
	 * @return List<Comrelt> 比赛成绩列表
	 */
	
	//List<Comrelt> getBy(String s);
	
	List<Comrelt> getAll();
	
	List<Comrelt> getByComsnum(String comsnum);

	/**
	 * 
	 * 功能描述：根据项目名称获取比赛成绩列表
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午9:57:04
	 * @version 1.0.0
	 * 
	 * @param comname 项目名称
	 * @return List<Comrelt> 比赛成绩列表
	 */
	List<Comrelt> getByComname(String comname);

	/**
	 * 
	 * 功能描述：根据运动员编号获取比赛成绩列表
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午9:57:04
	 * @version 1.0.0
	 * 
	 * @param athnum 运动员编号
	 * @return List<Comrelt> 比赛成绩列表
	 */
	List<Comrelt> getByAthnum(String athnum);

	/**
	 * 
	 * 功能描述：根据运动员姓名获取比赛成绩列表
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:23:11
	 * @version 1.0.0
	 * 
	 * @param athename 运动员姓名
	 * @return List<Comrelt> 比赛成绩列表
	 */
	List<Comrelt> getByAthename(String athename);

	/**
	 * 
	 * 功能描述：根据比赛级别获取比赛成绩列表
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:24:04
	 * @version 1.0.0
	 * 
	 * @param comlevel 比赛级别
	 * @return List<Comrelt> 比赛成绩列表
	 */
	List<Comrelt> getByComlevel(String comlevel);
}
