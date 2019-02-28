/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: ComscheduleDaoSQLServerImpl.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 下午4:05:10
 * @version 1.0.0
*/
package cn.jhl.smms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jhl.smms.dao.BaseDao;
import cn.jhl.smms.dao.ComscheduleDao;
import cn.jhl.smms.entity.Comschedule;

/**
 * 功能描述：
 * 
 * @author 贾恒
 * @Date 2018-7-17 下午4:05:10
 * @version 1.0.0
 */

public class ComscheduleDaoSQLServerImpl extends BaseDao implements ComscheduleDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.ComscheduleDao#save(cn.jhl.smms.entity.Comschedule)
	 */
	public int save(Comschedule comschedule) {
		// TODO Auto-generated method stub
		String sql = "insert into comschedule (comsnum,comsdate,comstime,sportname,comsaddr,pathamt,groups,comlevel,refername) values(?,?,?,?,?,?,?,?,?)";
		Object[] param = { comschedule.getComsnum(), comschedule.getComsdate(), comschedule.getComstime(), comschedule.getSportname(),
				comschedule.getComsaddr(), comschedule.getPathamt(), comschedule.getGroups(), comschedule.getComlevel(),
				comschedule.getRefername() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.ComscheduleDao#del(cn.jhl.smms.entity.Comschedule)
	 */
	public int del(Comschedule comschedule) {
		// TODO Auto-generated method stub
		String sql = "delete from comschedule where comsnum = ?";
		Object[] param = { comschedule.getComsnum() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.ComscheduleDao#update(cn.jhl.smms.entity.Comschedule)
	 */
	public int update(Comschedule comschedule) {
		// TODO Auto-generated method stub
		String sql = "update athlete set comsdate= ?,comstime= ?,sportname= ?,comsaddr= ?,pathamt= ?,groups= ?,comlevel= ?,refername= ? where comsnum = ?";
		Object[] param = { comschedule.getComsdate(), comschedule.getComstime(), comschedule.getSportname(),
				comschedule.getComsaddr(), comschedule.getPathamt(), comschedule.getGroups(), comschedule.getComlevel(),
				comschedule.getRefername(),comschedule.getComsnum() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.ComscheduleDao#getByComsdate(java.lang.String)
	 */
	public List<Comschedule> getByComsdate(String comsdate) {
		// TODO Auto-generated method stub
		List<Comschedule> list = new ArrayList<Comschedule>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from comschedule where comsdate = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comsdate);
			rs = pstmt.executeQuery();
			Comschedule comschedule = new Comschedule();
			while (rs.next()) {
				comschedule.setComsdate(rs.getString("comsdate"));
				comschedule.setComstime(rs.getString("comstime"));
				comschedule.setSportname(rs.getString("sportname"));
				comschedule.setComsaddr(rs.getString("comsaddr"));
				comschedule.setPathamt(rs.getString("pathamt"));
				comschedule.setGroups(rs.getString("groups"));
				comschedule.setComlevel(rs.getString("comlevel"));
				comschedule.setRefername(rs.getString("refername"));
				comschedule.setGroups(rs.getString("groups"));
				list.add(comschedule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.ComscheduleDao#getBySportname(java.lang.String)
	 */
	public List<Comschedule> getBySportname(String sportname) {
		// TODO Auto-generated method stub
		List<Comschedule> list = new ArrayList<Comschedule>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from comschedule where sportname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sportname);
			rs = pstmt.executeQuery();
			Comschedule comschedule = new Comschedule();
			while (rs.next()) {
				comschedule.setComsdate(rs.getString("comsdate"));
				comschedule.setComstime(rs.getString("comstime"));
				comschedule.setSportname(rs.getString("sportname"));
				comschedule.setComsaddr(rs.getString("comsaddr"));
				comschedule.setPathamt(rs.getString("pathamt"));
				comschedule.setGroups(rs.getString("groups"));
				comschedule.setComlevel(rs.getString("comlevel"));
				comschedule.setRefername(rs.getString("refername"));
				comschedule.setGroups(rs.getString("groups"));
				list.add(comschedule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.ComscheduleDao#getByComsaddr(java.lang.String)
	 */
	public List<Comschedule> getByComsaddr(String comsaddr) {
		// TODO Auto-generated method stub
		List<Comschedule> list = new ArrayList<Comschedule>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from comschedule where comsaddr = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comsaddr);
			rs = pstmt.executeQuery();
			Comschedule comschedule = new Comschedule();
			while (rs.next()) {
				comschedule.setComsdate(rs.getString("comsdate"));
				comschedule.setComstime(rs.getString("comstime"));
				comschedule.setSportname(rs.getString("sportname"));
				comschedule.setComsaddr(rs.getString("comsaddr"));
				comschedule.setPathamt(rs.getString("pathamt"));
				comschedule.setGroups(rs.getString("groups"));
				comschedule.setComlevel(rs.getString("comlevel"));
				comschedule.setRefername(rs.getString("refername"));
				comschedule.setGroups(rs.getString("groups"));
				list.add(comschedule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Comschedule> getAll() {
		// TODO 自动生成的方法存根
		List<Comschedule> list = new ArrayList<Comschedule>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from comschedule";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Comschedule comschedule = new Comschedule();
			while (rs.next()) {
				comschedule.setComsdate(rs.getString("comsdate"));
				comschedule.setComstime(rs.getString("comstime"));
				comschedule.setSportname(rs.getString("sportname"));
				comschedule.setComsaddr(rs.getString("comsaddr"));
				comschedule.setPathamt(rs.getString("pathamt"));
				comschedule.setGroups(rs.getString("groups"));
				comschedule.setComlevel(rs.getString("comlevel"));
				comschedule.setRefername(rs.getString("refername"));
				comschedule.setGroups(rs.getString("groups"));
				list.add(comschedule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}
}
