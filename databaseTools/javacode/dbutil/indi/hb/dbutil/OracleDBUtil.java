package indi.hb.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDBUtil extends BaseDBUtil {

	public OracleDBUtil(String ip, int port, String dbname, String username, String password) {
		setIp(ip);
		setPort(port);
		setDbname(dbname);
		setUsername(username);
		setPassword(password);
	}
	@Override
	public Connection getConn() throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@" + getIp() + ":" + getPort() + ":" + getDbname();	//数据库连接URL
		Connection conn = null;
	    try {
	        Class.forName("oracle.jdbc.driver.OracleDriver");			//反射获取数据库驱动类
	        conn = DriverManager.getConnection(url, getUsername(), getPassword());	//数据库连接对象
	    } catch (ClassNotFoundException e) {
	        //System.err.println("Oracle数据库连接驱动找不到！");
	    	throw e;
	    } catch (SQLException e) {
	        //System.err.println("数据库连接异常！");
	    	throw e;
	    }
	    return conn;
	}
}
