package cn.cdh.studentMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Idao {
	public void insert(Object o);
	public void delete(String id);
	public void update(Object o);
	public List<?> queryAll();
	public Object queryOneById(String id);
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs){
		if(rs!=null)
			try {
				rs.close();
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
