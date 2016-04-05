package com.wdz.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

public class JdbcTemplate {
	private static String driver;
	private static String username;
	private static String password;
	private static String url;
	Connection conn;
	Statement st;
	PreparedStatement ps;

	static {
		InputStream is = JdbcTemplate.class.getClassLoader()
				.getResourceAsStream("jdbcTemplate.properties");
		Properties pro = new Properties();
		try {
			pro.load(is);
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			this.conn = DriverManager.getConnection(url, username, password);

			this.conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获得链接失败！");
		}
		return this.conn;
	}

	private void getStatement() {
		getConnection();
		try {
			this.st = this.conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("创建状态通道失败！");
		}
	}

	private void getPrepareStatement(String sql) {
		getConnection();
		try {
			this.ps = this.conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("创建预状态通道失败！");
		}
	}

	public ResultSet query(String sql) {
		getStatement();
		try {
			return this.st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("在状态通道下 执行 查询出错！");
		}
		return null;
	}

	public boolean executeAll(List sqls) {
		boolean isok = false;
		getStatement();
		try {
			for (int i = 0; i < sqls.size(); i++) {
				st.addBatch(sqls.get(i)+"");
			}

			st.executeBatch();
			myCommit();
			isok = true;
		} catch (SQLException e) {
			e.printStackTrace();
			myRollback();
		}
		return isok;
	}

	public boolean executeAll(String sql, String[][] params) {
		boolean isok = false;
		getPrepareStatement(sql);
		try {
			for (int i = 0; i < params.length; i++) {
				for (int j = 0; j < params[i].length; j++) {
					this.ps.setString(j + 1, params[i][j]);
				}

				this.ps.addBatch();
			}

			this.ps.executeBatch();
			myCommit();
			isok = true;
		} catch (SQLException e) {
			e.printStackTrace();
			myRollback();
		}
		return isok;
	}

	public int getPrimaryKey(String sql) {
		getStatement();
		try {
			ResultSet rs = this.st.executeQuery(sql);
			int result = 0;
			if (rs.next()) {
				result = rs.getInt(1);
			}
			return result + 1;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("聚合函数的操作失败！获得主键失败！");
		}
		return 0;
	}

	public ResultSet query(String sql, List params) {
		getPrepareStatement(sql);
		try {
			bindParams(params);

			return this.ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("在预状态通道下执行查询出错！");
		}
		return null;
	}

	private void bindParams(List<String> params) throws SQLException {
		if ((params != null) && (params.size() > 0))
			for (int i = 0; i < params.size(); i++)
				this.ps.setString(i + 1, (String) params.get(i));
	}

	public boolean updateData(String sql) {
		boolean isok = false;
		getStatement();
		try {
			this.st.executeUpdate(sql);
			isok = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("在状态通道下执行数据操作失败！");
		}
		return isok;
	}

	public boolean updateData(String sql, List params) {
		boolean isok = false;
		if (sql != null) {
			getPrepareStatement(sql);
			try {
				bindParams(params);
				this.ps.executeUpdate();
				isok = true;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("在预备状态通道下执行数据操作失败！");
				System.out.println("在这儿");
			}
		}
		return isok;
	}

	public void myCommit() {
		try {
			this.conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void myRollback() {
		try {
			this.conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeRes() {
		try {
			if (this.st != null) {
				this.st.close();
			}
			if (this.ps != null) {
				this.ps.close();
			}
			if (this.conn != null)
				this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}