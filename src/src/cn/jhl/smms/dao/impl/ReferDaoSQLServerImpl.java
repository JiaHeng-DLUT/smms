/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: ReferDaoSQLServerImpl.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 下午4:08:27
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
import cn.jhl.smms.dao.ReferDao;
import cn.jhl.smms.entity.Refer;

/**
 * 功能描述：
 * 
 * @author 贾恒
 * @Date 2018-7-17 下午4:08:27
 * @version 1.0.0
 */

public class ReferDaoSQLServerImpl extends BaseDao implements ReferDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.ReferDao#save(cn.jhl.smms.entity.Refer)
	 */
	public int save(Refer refer) {
		// TODO Auto-generated method stub
		String sql = "insert into refer (	referid,refername,level,recomptn) values(?,?,?,?)";
		Object[] param = { refer.getReferid(), refer.getRefername(), refer.getLevel(), refer.getRecomptn() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.ReferDao#del(cn.jhl.smms.entity.Refer)
	 */
	public int del(Refer refer) {
		// TODO Auto-generated method stub
		String sql = "delete from refer where referid = ?";
		Object[] param = { refer.getReferid() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.ReferDao#update(cn.jhl.smms.entity.Refer)
	 */
	public int update(Refer refer) {
		// TODO Auto-generated method stub
		String sql = "update refer set refername= ?,level= ?,recomptnaname = ? where referid = ?";
		Object[] param = { refer.getRefername(), refer.getLevel(), refer.getRecomptn(),refer.getReferid() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.ReferDao#getByReferid(java.lang.String)
	 */
	public List<Refer> getByReferid(String referid) {
		// TODO Auto-generated method stub
		List<Refer> list = new ArrayList<Refer>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from refer where referid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, referid);
			rs = pstmt.executeQuery();
			Refer refer = new Refer();
			while (rs.next()) {
				refer.setReferid(rs.getString("referid"));
				refer.setRefername(rs.getString("refername"));
				refer.setLevel(rs.getString("level"));
				refer.setRecomptn(rs.getString("recomptn"));
				list.add(refer);
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
	 * @see cn.jhl.smms.dao.ReferDao#getByRefername(java.lang.String)
	 */
	public List<Refer> getByRefername(String refername) {
		// TODO Auto-generated method stub
		List<Refer> list = new ArrayList<Refer>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from refer where refername = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, refername);
			rs = pstmt.executeQuery();
			Refer refer = new Refer();
			while (rs.next()) {
				refer.setReferid(rs.getString("referid"));
				refer.setRefername(rs.getString("refername"));
				refer.setLevel(rs.getString("level"));
				refer.setRecomptn(rs.getString("recomptn"));
				list.add(refer);
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
	 * @see cn.jhl.smms.dao.ReferDao#getByLevel(java.lang.String)
	 */
	public List<Refer> getByLevel(String level) {
		// TODO Auto-generated method stub
		List<Refer> list = new ArrayList<Refer>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from refer where level = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, level);
			rs = pstmt.executeQuery();
			Refer refer = new Refer();
			while (rs.next()) {
				refer.setReferid(rs.getString("referid"));
				refer.setRefername(rs.getString("refername"));
				refer.setLevel(rs.getString("level"));
				refer.setRecomptn(rs.getString("recomptn"));
				list.add(refer);
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
	 * @see cn.jhl.smms.dao.ReferDao#getByRecomptn(java.lang.String)
	 */
	public List<Refer> getByRecomptn(String recomptn) {
		// TODO Auto-generated method stub
		List<Refer> list = new ArrayList<Refer>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from refer where recomptn = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, recomptn);
			rs = pstmt.executeQuery();
			Refer refer = new Refer();
			while (rs.next()) {
				refer.setReferid(rs.getString("referid"));
				refer.setRefername(rs.getString("refername"));
				refer.setLevel(rs.getString("level"));
				refer.setRecomptn(rs.getString("recomptn"));
				list.add(refer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Refer> getAll() {
		// TODO 自动生成的方法存根
		List<Refer> list = new ArrayList<Refer>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from refer";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, recomptn);
			rs = pstmt.executeQuery();
			Refer refer = new Refer();
			while (rs.next()) {
				refer.setReferid(rs.getString("referid"));
				refer.setRefername(rs.getString("refername"));
				refer.setLevel(rs.getString("level"));
				refer.setRecomptn(rs.getString("recomptn"));
				list.add(refer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

}
