/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: GroupsDaoSQLServerImpl.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 下午4:07:15
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
import cn.jhl.smms.dao.GroupsDao;
import cn.jhl.smms.entity.Groups;

/**
 * 功能描述：
 * 
 * @author 贾恒
 * @Date 2018-7-17 下午4:07:15
 * @version 1.0.0
 */

public class GroupsDaoSQLServerImpl extends BaseDao implements GroupsDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.GroupsDao#save(cn.jhl.smms.entity.Groups)
	 */
	public int save(Groups groups) {
		// TODO Auto-generated method stub
		String sql = "insert into groups (gnum,gname,anum,goldnum,silvernum,coppernum) values(?,?,?,?,?,?)";
		Object[] param = { groups.getGnum(), groups.getGname(), groups.getAnum(), groups.getGoldnum(),
				groups.getSilvernum(), groups.getCoppernum() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.GroupsDao#del(cn.jhl.smms.entity.Groups)
	 */
	public int del(Groups group) {
		// TODO Auto-generated method stub
		String sql = "delete from group where gnum = ?";
		Object[] param = { group.getGnum() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.GroupsDao#update(cn.jhl.smms.entity.Groups)
	 */
	public int update(Groups groups) {
		// TODO Auto-generated method stub
		String sql = "update groups set gname= ?,anum= ?,goldnum= ?,silvernum= ?,coppernum= ? where gnum= ?";
		Object[] param = { groups.getGname(), groups.getAnum(), groups.getGoldnum(),
				groups.getSilvernum(), groups.getCoppernum(),groups.getGnum() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.GroupsDao#getByGnum(java.lang.String)
	 */
	public List<Groups> getByGnum(String gnum) {
		// TODO Auto-generated method stub
		List<Groups> list = new ArrayList<Groups>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from groups where gnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gnum);
			rs = pstmt.executeQuery();
			Groups groups = new Groups();
			while (rs.next()) {
				groups.setGnum(rs.getString("gnum"));
				groups.setGname(rs.getString("gname"));
				groups.setAnum(rs.getString("anum"));
				groups.setGoldnum(rs.getString("goldnum"));
				groups.setSilvernum(rs.getString("silvernum"));
				groups.setCoppernum(rs.getString("coppernum"));
				list.add(groups);
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
	 * @see cn.jhl.smms.dao.GroupsDao#getByGname(java.lang.String)
	 */
	public List<Groups> getByGname(String gname) {
		// TODO Auto-generated method stub
		List<Groups> list = new ArrayList<Groups>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from groups where gname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gname);
			rs = pstmt.executeQuery();
			Groups groups = new Groups();
			while (rs.next()) {
				groups.setGnum(rs.getString("gnum"));
				groups.setGname(rs.getString("gname"));
				groups.setAnum(rs.getString("anum"));
				groups.setGoldnum(rs.getString("goldnum"));
				groups.setSilvernum(rs.getString("silvernum"));
				groups.setCoppernum(rs.getString("coppernum"));
				list.add(groups);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Groups> getAll() {
		// TODO 自动生成的方法存根
		List<Groups> list = new ArrayList<Groups>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from groups";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, gname);
			rs = pstmt.executeQuery();
			Groups groups = new Groups();
			while (rs.next()) {
				groups.setGnum(rs.getString("gnum"));
				groups.setGname(rs.getString("gname"));
				groups.setAnum(rs.getString("anum"));
				groups.setGoldnum(rs.getString("goldnum"));
				groups.setSilvernum(rs.getString("silvernum"));
				groups.setCoppernum(rs.getString("coppernum"));
				list.add(groups);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

}
