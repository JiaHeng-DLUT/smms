/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: ComreltDaoSQLServerImpl.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 下午3:27:39
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
import cn.jhl.smms.dao.ComreltDao;
import cn.jhl.smms.entity.Comrelt;

/**
 * 功能描述：
 * 
 * @author 贾恒
 * @Date 2018-7-17 下午3:27:39
 * @version 1.0.0
 */

public class ComreltDaoSQLServerImpl extends BaseDao implements ComreltDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.ComreltDao#save(cn.jhl.smms.entity.Comrelt)
	 */
	public int save(Comrelt comrelt) {
		// TODO Auto-generated method stub
		// String
		String sql = "insert into comrelt (comsnum, comname, athnum, athename, comlevel, position, achment) values(?,?,?,?,?,?,?)";
		Object[] param = { comrelt.getComsnum(), comrelt.getComname(), comrelt.getAthnum(), comrelt.getComlevel(),
				comrelt.getPosition(), comrelt.getAchment() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.ComreltDao#del(cn.jhl.smms.entity.Comrelt)
	 */
	public int del(Comrelt comrelt) {
		// TODO Auto-generated method stub
		String sql = "delete from comrelt where comsnum = ?";
		Object[] param = { comrelt.getComsnum() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.ComreltDao#update(cn.jhl.smms.entity.Comrelt)
	 */
	public int update(Comrelt comrelt) {
		// TODO Auto-generated method stub
		String sql = "update comrelt set comname = ?, athnum = ?, athename = ?, comlevel = ?, position = ?, achment = ? where comsnum = ?";
		Object[] param = { comrelt.getComname(), comrelt.getAthnum(), comrelt.getComlevel(), comrelt.getPosition(),
				comrelt.getAchment(), comrelt.getComsnum() };
		return exceuteUpdate(sql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.jhl.smms.dao.ComreltDao#getByComsnum(java.lang.String)
	 */
	public List<Comrelt> getByComsnum(String comsnum) {
		// TODO Auto-generated method stub
		List<Comrelt> list = new ArrayList<Comrelt>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from comrelt where comsnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comsnum);
			rs = pstmt.executeQuery();
			Comrelt comrelt = new Comrelt();
			while (rs.next()) {
				comrelt.setComsnum(rs.getString("comsnum"));
				comrelt.setComname(rs.getString("comname"));
				comrelt.setAthnum(rs.getString("athnum"));
				comrelt.setAthename(rs.getString("thename"));
				comrelt.setComlevel(rs.getString("comlevel"));
				comrelt.setPosition(rs.getString("Position"));
				comrelt.setAchment(rs.getString("achment"));
				list.add(comrelt);
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
	 * @see cn.jhl.smms.dao.ComreltDao#getByComname(java.lang.String)
	 */
	public List<Comrelt> getByComname(String comname) {
		// TODO Auto-generated method stub
		List<Comrelt> list = new ArrayList<Comrelt>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from comrelt where comname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comname);
			rs = pstmt.executeQuery();
			Comrelt comrelt = new Comrelt();
			while (rs.next()) {
				comrelt.setComsnum(rs.getString("comsnum"));
				comrelt.setComname(rs.getString("comname"));
				comrelt.setAthnum(rs.getString("athnum"));
				comrelt.setAthename(rs.getString("thename"));
				comrelt.setComlevel(rs.getString("comlevel"));
				comrelt.setPosition(rs.getString("Position"));
				comrelt.setAchment(rs.getString("achment"));
				list.add(comrelt);
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
	 * @see cn.jhl.smms.dao.ComreltDao#findByAthnum(java.lang.String)
	 */
	public List<Comrelt> getByAthnum(String athnum) {
		// TODO Auto-generated method stub
		List<Comrelt> list = new ArrayList<Comrelt>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from comrelt where athnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, athnum);
			rs = pstmt.executeQuery();
			Comrelt comrelt = new Comrelt();
			while (rs.next()) {
				comrelt.setComsnum(rs.getString("comsnum"));
				comrelt.setComname(rs.getString("comname"));
				comrelt.setAthnum(rs.getString("athnum"));
				comrelt.setAthename(rs.getString("thename"));
				comrelt.setComlevel(rs.getString("comlevel"));
				comrelt.setPosition(rs.getString("Position"));
				comrelt.setAchment(rs.getString("achment"));
				list.add(comrelt);
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
	 * @see cn.jhl.smms.dao.ComreltDao#findByAthename(java.lang.String)
	 */
	public List<Comrelt> getByAthename(String athename) {
		// TODO Auto-generated method stub
		List<Comrelt> list = new ArrayList<Comrelt>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from comrelt where athename = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, athename);
			rs = pstmt.executeQuery();
			Comrelt comrelt = new Comrelt();
			while (rs.next()) {
				comrelt.setComsnum(rs.getString("comsnum"));
				comrelt.setComname(rs.getString("comname"));
				comrelt.setAthnum(rs.getString("athnum"));
				comrelt.setAthename(rs.getString("thename"));
				comrelt.setComlevel(rs.getString("comlevel"));
				comrelt.setPosition(rs.getString("Position"));
				comrelt.setAchment(rs.getString("achment"));
				list.add(comrelt);
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
	 * @see cn.jhl.smms.dao.ComreltDao#findByComlevel(java.lang.String)
	 */
	public List<Comrelt> getByComlevel(String comlevel) {
		// TODO Auto-generated method stub
		List<Comrelt> list = new ArrayList<Comrelt>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from comrelt where comlevel = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comlevel);
			rs = pstmt.executeQuery();
			Comrelt comrelt = new Comrelt();
			while (rs.next()) {
				comrelt.setComsnum(rs.getString("comsnum"));
				comrelt.setComname(rs.getString("comname"));
				comrelt.setAthnum(rs.getString("athnum"));
				comrelt.setAthename(rs.getString("thename"));
				comrelt.setComlevel(rs.getString("comlevel"));
				comrelt.setPosition(rs.getString("Position"));
				comrelt.setAchment(rs.getString("achment"));
				list.add(comrelt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	/*
	@Override
	public List<Comrelt> getBy(String s) {
		// TODO 自动生成的方法存根
		List<Comrelt> list = new ArrayList<Comrelt>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from comrelt where '"+s+"' = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s);
			rs = pstmt.executeQuery();
			Comrelt comrelt = new Comrelt();
			while (rs.next()) {
				comrelt.setComsnum(rs.getString("comsnum"));
				comrelt.setComname(rs.getString("comname"));
				comrelt.setAthnum(rs.getString("athnum"));
				comrelt.setAthename(rs.getString("thename"));
				comrelt.setComlevel(rs.getString("comlevel"));
				comrelt.setPosition(rs.getString("Position"));
				comrelt.setAchment(rs.getString("achment"));
				list.add(comrelt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}
*/

	@Override
	public List<Comrelt> getAll() {
		// TODO 自动生成的方法存根
		List<Comrelt> list = new ArrayList<Comrelt>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from comrelt";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, s);
			rs = pstmt.executeQuery();
			Comrelt comrelt = new Comrelt();
			while (rs.next()) {
				comrelt.setComsnum(rs.getString("comsnum"));
				comrelt.setComname(rs.getString("comname"));
				comrelt.setAthnum(rs.getString("athnum"));
				comrelt.setAthename(rs.getString("thename"));
				comrelt.setComlevel(rs.getString("comlevel"));
				comrelt.setPosition(rs.getString("Position"));
				comrelt.setAchment(rs.getString("achment"));
				list.add(comrelt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}
}
