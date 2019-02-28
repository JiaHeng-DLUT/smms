/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: Athlete.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:17:46
 * @version 1.0.0
*/
package cn.jhl.smms.entity;

/**
 * 功能描述：
 * 
 * @author 韩晨晨
 * @Date 2018年7月16日 下午9:44:07
 * @version 1.0.0
 */
public class Athlete {

	String aid;// 运动员编号
	String aname;// 运动员姓名
	String gnum;// 所属团体
	String asex;// 性别
	String aage;// 年龄
	String snum;// 参赛项目

	public void set(String aid, String aname,String gnum,String asex,String aage,String snum) {
		this.aid = aid;
		this.aname = aname;
		this.gnum = gnum;
		this.asex = asex;
		this.aage = aage;
		this.snum = snum;
	}
	
	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getGnum() {
		return gnum;
	}

	public void setGnum(String gnum) {
		this.gnum = gnum;
	}

	public String getAsex() {
		return asex;
	}

	public void setAsex(String asex) {
		this.asex = asex;
	}

	public String getAage() {
		return aage;
	}

	public void setAage(String aage) {
		this.aage = aage;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

}