package com.newer.memo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemoUtil {
	/* 数据连接驱动 */
	public static final String DRIVER = "oracle.jdbc.OracleDriver";
	/* 数据库连接路径 */
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	/* 数据连接用户名 */
	public static final String USER = "bookstore";
	/* 数据连接密码 */
	public static final String PWD = "bookstore";
	/* 数据库连接对象 */
	public static Connection con = null;

	/**
	 * 加载驱动
	 */
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获得连接方法
	 */
	public static Connection getConnection() {
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 释放资源的方法
	 */
	public static void closeAll(ResultSet rs, Statement stmt, Connection con) {
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
