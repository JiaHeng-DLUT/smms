/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: Groups.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午8:23:00
 * @version 1.0.0
*/
package cn.jhl.smms.entity;

/**
 * 功能描述：
 * 
 * @author 韩晨晨
 * @Date 2018年7月16日 下午9:45:53
 * @version 1.0.0
 */
public class Groups {

	String gnum;// 团体编号
	String gname;// 名称
	String anum;// 运动员人数
	String goldnum;// 金牌数（获奖）
	String silvernum;// 银牌数（获奖）
	String coppernum;// 铜牌数（获奖）

	public void set(String gnum,String gname,String anum,String goldnum,String silvernum,String coppernum) {
		this.gnum = gnum;
		this.gname = gname;
		this.anum = anum;
		this.goldnum = goldnum;
		this.silvernum = silvernum;
		this.coppernum = coppernum;
	}
	
	public String getGnum() {
		return gnum;
	}

	public void setGnum(String gnum) {
		this.gnum = gnum;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getAnum() {
		return anum;
	}

	public void setAnum(String anum) {
		this.anum = anum;
	}

	public String getGoldnum() {
		return goldnum;
	}

	public void setGoldnum(String goldnum) {
		this.goldnum = goldnum;
	}

	public String getSilvernum() {
		return silvernum;
	}

	public void setSilvernum(String silvernum) {
		this.silvernum = silvernum;
	}

	public String getCoppernum() {
		return coppernum;
	}

	public void setCoppernum(String coppernum) {
		this.coppernum = coppernum;
	}

}
