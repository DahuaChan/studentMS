package cn.cdh.studentMS.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.cdh.studentMS.util.DBfactory;

public class Test {

	@org.junit.Test
	public void test() {
		Connection conn = DBfactory.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from admin");
			ResultSet rs = ps.executeQuery();
			rs.next();
			System.out.println(rs.getString("admin_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block   integratedSecurity=true;
			e.printStackTrace();
		}
	}

}
