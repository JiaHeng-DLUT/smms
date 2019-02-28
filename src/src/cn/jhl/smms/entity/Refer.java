/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: Refer.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:27:11
 * @version 1.0.0
*/
package cn.jhl.smms.entity;

/**
 * 功能描述：
 * 
 * @author 韩晨晨
 * @Date 2018年7月16日 下午9:46:00
 * @version 1.0.0
 */
public class Refer {

	String referid;// 裁判编号
	String refername;// 姓名
	String level;// 级别
	String recomptn;// 负责赛事

	public void set(String referid,String refername,String level,String recomptn) {
		this.referid = referid;
		this.refername = refername;
		this.level = level;
		this.recomptn = recomptn;
	}
	
	public String getReferid() {
		return referid;
	}

	public void setReferid(String referid) {
		this.referid = referid;
	}

	public String getRefername() {
		return refername;
	}

	public void setRefername(String refername) {
		this.refername = refername;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRecomptn() {
		return recomptn;
	}

	public void setRecomptn(String recomptn) {
		this.recomptn = recomptn;
	}

}
