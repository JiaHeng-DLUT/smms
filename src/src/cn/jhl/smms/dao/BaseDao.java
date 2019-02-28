/**
 * Copyright (C), 2017-2018, 大连理工大学软件学院
 * FileName: BaseDao.java
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午7:59:18
 * @version 1.0.0
*/
package cn.jhl.smms.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 功能描述：
 * 
 * @author 贾恒
 * @Date 2018-7-17 上午7:59:18
 * @version 1.0.0
 */
public class BaseDao {
	private static String driver; // 数据库驱动
	private static String url; // 连接URL字符串
	private static String user; // 数据库用户名
	private static String password; // 用户密码
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		BaseDao.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		BaseDao.url = url;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		BaseDao.user = user;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		BaseDao.password = password;
	}
	Connection conn = null;// 数据连接对象

	// 静态代码块,在类加载的时候执行
	public BaseDao() {
		init();
	}

	/**
	 * 
	 * 功能描述：初始化连接参数,从配置文件里获得
	 * 
	 * @author 贾恒
	 * @Date 2018年7月19日 上午12:25:53
	 * @version 1.0.0
	 */
	public static void init() {
		System.out.println(driver+url+user+password);
		Properties params = new Properties();
		String configFile = "database.properties";// 配置文件路径
		// 加载配置文件到输入流中
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
		try {
			System.out.println(driver+url+user+password);// 从输入流中读取属性列表
			params.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 根据指定的获取对应的值
		driver = params.getProperty("DRIVER");
		url = params.getProperty("URL");
		user = params.getProperty("USER");
		password = params.getProperty("PASSWORD");
		System.out.println(driver+url+user+password);
	}

	/**
	 * 
	 * 功能描述：获取数据库连接对象
	 * 
	 * @param
	 * @return
	 */
	public Connection getConnection() {
		if (conn == null) {
			// 获取连接并捕获异常
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, getUser(), password);
			} catch (Exception e) {
				e.printStackTrace(); // 异常处理
			}
		}
		return conn; // 返回连接对象
	}

	/**
	 * 
	 * 功能描述：关闭数据库连接
	 * 
	 * @author 贾恒
	 * @Date 2018-7-17 上午8:03:44
	 * @version 1.0.0
	 * 
	 * @param conn 数据库连接
	 * @param stmt Statement对象
	 * @param rs   结果集
	 * @return
	 */
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		// 若结果集对象不为空,则关闭
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若Statement对象不为空,则关闭
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若数据库连接对象不为空,则关闭
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * 功能描述：增、删、改的操作
	 * 
	 * @author 贾恒
	 * @Date 2018-7-17 上午8:06:08
	 * @version 1.0.0
	 * 
	 * @param sql   预编译的 SQL 语句
	 * @param param 参数的字符串数组
	 * @return 影响的行数
	 */
	public int exceuteUpdate(String preparedSql, Object[] param) {
		PreparedStatement pstmt = null;
		int num = 0;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					// 为预编译sql设置参数
					pstmt.setObject(i + 1, param[i]);
				}
			}
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return num;
	}
}