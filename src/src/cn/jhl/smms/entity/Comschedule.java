/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: Comschedule.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:31:01
 * @version 1.0.0
*/
package cn.jhl.smms.entity;

/**
 * 功能描述：
 * 
 * @author 韩晨晨
 * @Date 2018年7月16日 下午9:45:47
 * @version 1.0.0
 */
public class Comschedule {

	String comsnum;// 赛事编号
	String comsdate;// 日期
	String comstime;// 时间
	String sportname;// 项目名称
	String comsaddr;// 比赛地点
	String pathamt;// 参赛人数
	String groups;// 组别
	String comlevel;// 级别
	String refername;// 裁判

	public void set(String comsnum, String comsdate, String comstime, String sportname, String comsaddr, String pathamt,
			String groups, String comlevel, String refername) {
		this.comsnum = comsnum;
		this.comsdate = comsdate;
		this.comstime = comstime;
		this.sportname = sportname;
		this.comsaddr = comsaddr;
		this.pathamt =  pathamt;
		this.groups = groups;
		this.comlevel = comlevel;
		this.refername = refername;
	}

	public String getComsnum() {
		return comsnum;
	}

	public void setComsnum(String comsnum) {
		this.comsnum = comsnum;
	}

	public String getComsdate() {
		return comsdate;
	}

	public void setComsdate(String comsdate) {
		this.comsdate = comsdate;
	}

	public String getComstime() {
		return comstime;
	}

	public void setComstime(String comstime) {
		this.comstime = comstime;
	}

	public String getSportname() {
		return sportname;
	}

	public void setSportname(String sportname) {
		this.sportname = sportname;
	}

	public String getComsaddr() {
		return comsaddr;
	}

	public void setComsaddr(String comsaddr) {
		this.comsaddr = comsaddr;
	}

	public String getPathamt() {
		return pathamt;
	}

	public void setPathamt(String pathamt) {
		this.pathamt = pathamt;
	}

	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	public String getComlevel() {
		return comlevel;
	}

	public void setComlevel(String comlevel) {
		this.comlevel = comlevel;
	}

	public String getRefername() {
		return refername;
	}

	public void setRefername(String refername) {
		this.refername = refername;
	}

}
