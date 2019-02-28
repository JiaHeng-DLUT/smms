/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: Sport.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:28:42
 * @version 1.0.0
*/
package cn.jhl.smms.entity;

/**
 * 功能描述：
 * 
 * @author 韩晨晨
 * @Date 2018年7月17日 上午8:23:24
 * @version 1.0.0
 */
public class Sport {

	String snum;// 比赛项目编号
	String sname;// 比赛项目名称
	String wrecord;// 世界纪录
	String lhrecord;// 本赛事纪录

	public void set(String snum,String sname,String wrecord,String lhrecord) {
		this.snum = snum;
		this.sname = sname;
		this.wrecord = wrecord;
		this.lhrecord = lhrecord;
	}
	
	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getWrecord() {
		return wrecord;
	}

	public void setWrecord(String wrecord) {
		this.wrecord = wrecord;
	}

	public String getLhrecord() {
		return lhrecord;
	}

	public void setLhrecord(String lhrecord) {
		this.lhrecord = lhrecord;
	}

}
