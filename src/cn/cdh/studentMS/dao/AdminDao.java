package cn.cdh.studentMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.cdh.studentMS.model.Admin;
import cn.cdh.studentMS.util.DBfactory;

public class AdminDao implements Idao {
	
	private static final String INSERT_SQL = "INSERT INTO admin ( admin_id , admin_password , admin_type ) VALUES  ( ?,?,? )";
	private static final String DELETE_SQL = "DELETE dbo.admin WHERE admin_id = ?";
	private static final String UPDATE_SQL = "UPDATE dbo.admin SET admin_password = ?,admin_type = ? WHERE admin_id = ?";
	private static final String QUERYALL_SQL = "SELECT * FROM admin";
	private static final String QUERYONEBYID_SQL = "SELECT * FROM admin WHERE admin_id = ?";
	
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public AdminDao() {
		
	}

	@Override
	public void insert(Object o) {
		try {
			Admin admin = (Admin)o;
			conn = DBfactory.getConn();
			ps = conn.prepareStatement(INSERT_SQL);
			ps.setString(1, admin.getId().trim());
			ps.setString(2, admin.getPassword().trim());
			ps.setString(3, admin.getType().trim());
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			Idao.close(conn, ps, rs);
		}
		
	}

	@Override
	public void delete(String id) {
		try {
			conn = DBfactory.getConn();
			ps = conn.prepareStatement(DELETE_SQL);
			ps.setString(1, id);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Idao.close(conn, ps, rs);
		}
		
	}

	@Override
	public void update(Object o) {
		try {
			Admin admin = (Admin)o;
			conn = DBfactory.getConn();
			ps = conn.prepareStatement(UPDATE_SQL);
			ps.setString(1, admin.getPassword().trim());
			ps.setString(2, admin.getType().trim());
			ps.setString(3, admin.getId().trim());
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			Idao.close(conn, ps, rs);
		}
		
	}

	@Override
	public List<?> queryAll() {
		List<Admin> lists = new ArrayList<>();
		try {
			conn = DBfactory.getConn();
			ps = conn.prepareStatement(QUERYALL_SQL);
			rs = ps.executeQuery();
			while(rs.next()){
				Admin admin = new Admin();
				admin.setId(rs.getString("admin_id"));
				admin.setPassword(rs.getString("admin_password"));
				admin.setType(rs.getString("admin_type"));
				lists.add(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Idao.close(conn, ps, rs);
		}
		return lists;
	}

	@Override
	public Object queryOneById(String id) {
		Admin admin = new Admin();
		try {
			conn = DBfactory.getConn();
			ps = conn.prepareStatement(QUERYONEBYID_SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				admin.setId(rs.getString("admin_id"));
				admin.setPassword(rs.getString("admin_password"));
				admin.setType(rs.getString("admin_type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Idao.close(conn, ps, rs);
		}
		return admin;
	}
	
	public boolean check(Admin unCheckAdmin){
		Admin admin = (Admin)queryOneById(unCheckAdmin.getId());
		if(admin.getPassword()==null)
			return false;
		else{
			return admin.getPassword().equals(unCheckAdmin.getPassword());
		}
	}
	
}
