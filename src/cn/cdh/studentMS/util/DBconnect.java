package cn.cdh.studentMS.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.w3c.dom.NodeList;

public class DBconnect {

	private static String DRIVE;
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;

	private Connection conn;

	public DBconnect() {
		NodeList nl = Config.dbCongig();
		DRIVE = nl.item(1).getTextContent();
		URL = nl.item(3).getTextContent();
		USERNAME = nl.item(5).getTextContent();
		PASSWORD = nl.item(7).getTextContent();
	}

	public Connection getConnect() {

		try {
			Class.forName(DRIVE);
			conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

}
