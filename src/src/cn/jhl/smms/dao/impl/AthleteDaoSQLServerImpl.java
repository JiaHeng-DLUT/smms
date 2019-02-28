/**
 * Copyright (C), 2017-2018, DaLian
 * FileName: AthleteDaoSQLServerImpl.java
 * 
 * @author 韩晨晨
 * @Date 2018年7月17日 上午11:12:47
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
import cn.jhl.smms.dao.AthleteDao;
import cn.jhl.smms.entity.Athlete;

/**
 * 功能描述：
 * 
 * @author 韩晨晨
 * @Date 2018年7月17日 上午11:12:47
 * @version 1.0.0
 */
public class AthleteDaoSQLServerImpl extends BaseDao implements AthleteDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.AthleteDao#save(cn.jhl.smms.entity.Athlete)
	 */
	public int save(Athlete athlete) {
		// TODO Auto-generated method stub
		String sql = "insert into athlete (aid, aname, gnum, asex, aage, snum) values(?,?,?,?,?,?)";
		Object[] param = { athlete.getAid(), athlete.getAname(), athlete.getGnum(), athlete.getAsex(),
				athlete.getAage(), athlete.getSnum() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.AthleteDao#del(cn.jhl.smms.entity.Athlete)
	 */
	public int del(Athlete athlete) {
		// TODO Auto-generated method stub
		String sql = "delete from athlete where aid = ?";
		Object[] param = { athlete.getAid() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.AthleteDao#update(cn.jhl.smms.entity.Athlete)
	 */
	public int update(Athlete athlete) {
		// TODO Auto-generated method stub
		String sql = "update athlete set aname = ?, gnum = ?, asex = ?, aage = ?, snum = ? where aid = ?";
		Object[] param = { athlete.getAname(), athlete.getGnum(), athlete.getAsex(), athlete.getAage(),
				athlete.getSnum(), athlete.getAid() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.AthleteDao#getByAid(java.lang.String)
	 */
	public List<Athlete> getByAid(String aid) {
		// TODO Auto-generated method stub
		List<Athlete> list = new ArrayList<Athlete>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from athlete where aid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aid);
			rs = pstmt.executeQuery();
			Athlete athlete = new Athlete();
			while (rs.next()) {
				athlete.setAid(rs.getString("aid"));
				athlete.setAname(rs.getString("aname"));
				athlete.setGnum(rs.getString("gnum"));
				athlete.setAsex(rs.getString("asex"));
				athlete.setAage(rs.getString("aage"));
				athlete.setSnum(rs.getString("snum"));
				list.add(athlete);
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
	 * @see cn.jhl.smms.dao.AthleteDao#getByAname(java.lang.String)
	 */
	public List<Athlete> getByAname(String aname) {
		// TODO Auto-generated method stub
		List<Athlete> list = new ArrayList<Athlete>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from athlete where aname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aname);
			rs = pstmt.executeQuery();
			Athlete athlete = new Athlete();
			while (rs.next()) {
				athlete.setAid(rs.getString("aid"));
				athlete.setAname(rs.getString("aname"));
				athlete.setGnum(rs.getString("gnum"));
				athlete.setAsex(rs.getString("asex"));
				athlete.setAage(rs.getString("aage"));
				athlete.setSnum(rs.getString("snum"));
				list.add(athlete);
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
	 * @see cn.jhl.smms.dao.AthleteDao#findByGnum(java.lang.String)
	 */
	public List<Athlete> getByGnum(String gnum) {
		// TODO Auto-generated method stub
		List<Athlete> list = new ArrayList<Athlete>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from athlete where gnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gnum);
			rs = pstmt.executeQuery();
			Athlete athlete = new Athlete();
			while (rs.next()) {
				athlete.setAid(rs.getString("aid"));
				athlete.setAname(rs.getString("aname"));
				athlete.setGnum(rs.getString("gnum"));
				athlete.setAsex(rs.getString("asex"));
				athlete.setAage(rs.getString("aage"));
				athlete.setSnum(rs.getString("snum"));
				list.add(athlete);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Athlete> getAll() {
		// TODO 自动生成的方法存根
		List<Athlete> list = new ArrayList<Athlete>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from athlete ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Athlete athlete = new Athlete();
			while (rs.next()) {
				athlete.setAid(rs.getString("aid"));
				athlete.setAname(rs.getString("aname"));
				athlete.setGnum(rs.getString("gnum"));
				athlete.setAsex(rs.getString("asex"));
				athlete.setAage(rs.getString("aage"));
				athlete.setSnum(rs.getString("snum"));
				list.add(athlete);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

}
