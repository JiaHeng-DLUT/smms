/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: ReferDao.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:54:53
 * @version 1.0.0
*/
package cn.jhl.smms.dao;

import java.util.List;

import cn.jhl.smms.entity.Comrelt;
import cn.jhl.smms.entity.Refer;

/**
 * 功能描述：裁判Dao接口
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:54:53
 * @version 1.0.0
 */

public interface ReferDao {
	/**
	 * 
	 * 功能描述：保存裁判
	 * 
	 * @author 贾恒
	 * @Date 2018-7-17 上午10:14:12
	 * @version 1.0.0
	 * 
	 * @param refer 裁判
	 * @return
	 */
	int save(Refer refer);

	/**
	 * 
	 * 功能描述：删除裁判
	 * 
	 * @author 贾恒
	 * @Date 2018-7-17 上午10:14:59
	 * @version 1.0.0
	 * 
	 * @param refer 裁判
	 * @return
	 */
	int del(Refer refer);

	/**
	 * 
	 * 功能描述：更新裁判
	 * 
	 * @author 贾恒
	 * @Date 2018-7-17 上午10:15:27
	 * @version 1.0.0
	 * 
	 * @param refer 裁判
	 * @return
	 */
	int update(Refer refer);

	/**
	 * 
	 * 功能描述：根据裁判编号获取裁判列表
	 * 
	 * @author 贾恒
	 * @Date 2018-7-17 上午10:18:23
	 * @version 1.0.0
	 * 
	 * @param referid 裁判编号
	 * @return List<Refer> 裁判列表
	 */
	List<Refer> getAll();
	List<Refer> getByReferid(String referid);

	/**
	 * 
	 * 功能描述：根据裁判姓名获取裁判列表
	 * 
	 * @author 贾恒
	 * @Date 2018-7-17 上午10:20:48
	 * @version 1.0.0
	 * 
	 * @param refername 裁判姓名
	 * @return List<Refer> 裁判列表
	 */
	List<Refer> getByRefername(String refername);

	/**
	 * 
	 * 功能描述：根据裁判级别获取裁判列表
	 * 
	 * @author 贾恒
	 * @Date 2018-7-17 上午10:23:55
	 * @version 1.0.0
	 * 
	 * @param level 裁判级别
	 * @return List<Refer> 裁判列表
	 */
	List<Refer> getByLevel(String level);

	/**
	 * 
	 * 功能描述：根据裁判负责赛事获取裁判列表
	 * 
	 * @author 贾恒
	 * @Date 2018-7-17 上午10:25:25
	 * @version 1.0.0
	 * 
	 * @param recomptn 裁判负责赛事
	 * @return List<Refer> 裁判列表
	 */
	List<Refer> getByRecomptn(String recomptn);
}
