/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: Comrelt.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:33:29
 * @version 1.0.0
*/
package cn.jhl.smms.entity;

/**
 * 功能描述：
 * 
 * @author 韩晨晨
 * @Date 2018年7月16日 下午9:45:35
 * @version 1.0.0
 */
public class Comrelt {

	String comsnum;// 赛事编号
	String comname;// 项目名称
	String athnum;// 运动员编号
	String athename;// 运动员姓名
	String comlevel;// 比赛级别
	String position;// 名次
	String achment;// 成绩

	public void set(String comsnum, String comname, String athnum, String athename, String comlevel, String position,
			String achment) {
		this.comsnum = comsnum;
		this.comname = comname;
		this.athnum =  athnum;
		this.athename = athename;
		this.comlevel = comlevel;
		this.position = position;
		this.achment = achment;
	}

	public String getComsnum() {
		return comsnum;
	}

	public void setComsnum(String comsnum) {
		this.comsnum = comsnum;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public String getAthnum() {
		return athnum;
	}

	public void setAthnum(String athnum) {
		this.athnum = athnum;
	}

	public String getAthename() {
		return athename;
	}

	public void setAthename(String athename) {
		this.athename = athename;
	}

	public String getComlevel() {
		return comlevel;
	}

	public void setComlevel(String comlevel) {
		this.comlevel = comlevel;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAchment() {
		return achment;
	}

	public void setAchment(String achment) {
		this.achment = achment;
	}

}
