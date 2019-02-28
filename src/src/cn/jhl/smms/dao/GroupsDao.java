/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: GroupsDao.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:54:05
 * @version 1.0.0
*/
package cn.jhl.smms.dao;

import java.util.List;

import cn.jhl.smms.entity.Comrelt;
import cn.jhl.smms.entity.Groups;

/**
 * 功能描述：参赛团体Dao接口
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:54:05
 * @version 1.0.0
 */

public interface GroupsDao {
	/**
	 * 
	 * 功能描述：保存参赛团体
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:41:34
	 * @version 1.0.0
	 * 
	 * @param groups 参赛团体
	 * @return
	 */
	int save(Groups groups);

	/**
	 * 
	 * 功能描述：删除参赛团体
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:57:25
	 * @version 1.0.0
	 * 
	 * @param groups 参赛团体
	 * @return
	 */
	int del(Groups group);

	/**
	 * 
	 * 功能描述：更新参赛团体
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:58:34
	 * @version 1.0.0
	 * 
	 * @param groups 参赛团体
	 * @return
	 */
	int update(Groups group);

	/**
	 * 
	 * 功能描述：根据团体编号获取参赛团体列表
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午10:59:01
	 * @version 1.0.0
	 * 
	 * @param gnum 团体编号
	 * @return List<Groups> 参赛团体列表
	 */
	List<Groups> getAll();
	List<Groups> getByGnum(String gnum);

	/**
	 * 
	 * 功能描述：根据团体名称获取参赛团体列表
	 * 
	 * @author 韩晨晨
	 * @Date 2018年7月17日 上午11:00:31
	 * @version 1.0.0
	 * 
	 * @param gname 名称
	 * @return List<Groups> 参赛团体列表
	 */
	List<Groups> getByGname(String gname);// 名称
}
