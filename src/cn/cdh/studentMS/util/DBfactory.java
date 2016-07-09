package cn.cdh.studentMS.util;

import java.sql.Connection;

public class DBfactory {
	public static Connection getConn(){
		return new DBconnect().getConnect();
	}
}
