/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: SportDaoSQLServerImpl.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 下午4:19:23
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
import cn.jhl.smms.dao.SportDao;
import cn.jhl.smms.entity.Sport;

/**
 * 功能描述：
 * 
 * @author 贾恒
 * @Date 2018-7-17 下午4:19:23
 * @version 1.0.0
 */

public class SportDaoSQLServerImpl extends BaseDao implements SportDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.SportDao#save(cn.jhl.smms.entity.Sport)
	 */
	public int save(Sport sport) {
		// TODO Auto-generated method stub
		String sql = "insert into sport (snum,sname,wrecord,lhrecord) values(?,?,?,?)";
		Object[] param = { sport.getSnum(), sport.getSname(), sport.getWrecord(), sport.getLhrecord() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.SportDao#del(cn.jhl.smms.entity.Sport)
	 */
	public int del(Sport sport) {
		// TODO Auto-generated method stub
		String sql = "delete from sport where snum = ?";
		Object[] param = { sport.getSnum() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.SportDao#update(cn.jhl.smms.entity.Sport)
	 */
	public int update(Sport sport) {
		// TODO Auto-generated method stub
		String sql = "update sport set sname= ?,wrecord= ?,lhrecord = ? where snum = ?";
		Object[] param = { sport.getSname(), sport.getWrecord(), sport.getLhrecord(),sport.getSnum() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.SportDao#getBySnum(java.lang.String)
	 */
	public List<Sport> getBySnum(String snum) {
		// TODO Auto-generated method stub
		List<Sport> list = new ArrayList<Sport>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from sport where snum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, snum);
			rs = pstmt.executeQuery();
			Sport sport = new Sport();
			while (rs.next()) {
				sport.setSnum(rs.getString("snum"));
				sport.setSname(rs.getString("sname"));
				sport.setWrecord(rs.getString("wrecord"));
				sport.setLhrecord(rs.getString("lhrecord"));
				list.add(sport);
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
	 * @see cn.jhl.smms.dao.SportDao#getBySname(java.lang.String)
	 */
	public List<Sport> getBySname(String sname) {
		// TODO Auto-generated method stub
		List<Sport> list = new ArrayList<Sport>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from sport where sname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);
			rs = pstmt.executeQuery();
			Sport sport = new Sport();
			while (rs.next()) {
				sport.setSnum(rs.getString("snum"));
				sport.setSname(rs.getString("sname"));
				sport.setWrecord(rs.getString("wrecord"));
				sport.setLhrecord(rs.getString("lhrecord"));
				list.add(sport);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Sport> getAll() {
		// TODO 自动生成的方法存根
		List<Sport> list = new ArrayList<Sport>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from sport";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, sname);
			rs = pstmt.executeQuery();
			Sport sport = new Sport();
			while (rs.next()) {
				sport.setSnum(rs.getString("snum"));
				sport.setSname(rs.getString("sname"));
				sport.setWrecord(rs.getString("wrecord"));
				sport.setLhrecord(rs.getString("lhrecord"));
				list.add(sport);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

}
