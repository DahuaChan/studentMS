package cn.cdh.studentMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.cdh.studentMS.model.Teacher;
import cn.cdh.studentMS.util.DBfactory;

public class TeacherDao implements Idao {

	private static final String INSERT_SQL = "INSERT INTO teacher ( tech_id , tech_name , tech_password , sub_id ) VALUES  ( ?,?,?,? )";
	private static final String DELETE_SQL = "DELETE dbo.teacher WHERE tech_id = ?";
	private static final String UPDATE_SQL = "UPDATE dbo.teacher SET tech_name = ? , tech_password ? , sub_id = ? WHERE tech_id = ?";
	private static final String QUERYALL_SQL = "SELECT * FROM teacher";
	private static final String QUERYONEBYID_SQL = "SELECT * FROM teacher WHERE tech_id = ?";

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public TeacherDao() {

	}

	@Override
	public void insert(Object o) {
		try {
			Teacher teacher = (Teacher) o;
			conn = DBfactory.getConn();
			ps = conn.prepareStatement(INSERT_SQL);
			ps.setInt(1, teacher.getTech_id());
			ps.setString(2, teacher.getTech_name().trim());
			ps.setString(3, teacher.getTech_password().trim());
			ps.setInt(4, teacher.getSub_id());
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Idao.close(conn, ps, rs);
		}

	}

	@Override
	public void delete(String id) {
		try {
			conn = DBfactory.getConn();
			ps = conn.prepareStatement(DELETE_SQL);
			ps.setInt(1, Integer.parseInt(id));
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
			Teacher teacher = (Teacher) o;
			conn = DBfactory.getConn();
			ps = conn.prepareStatement(UPDATE_SQL);
			ps.setString(1, teacher.getTech_name().trim());
			ps.setString(2, teacher.getTech_password().trim());
			ps.setInt(3, teacher.getSub_id());
			ps.setInt(4, teacher.getTech_id());
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Idao.close(conn, ps, rs);
		}

	}

	@Override
	public List<?> queryAll() {
		List<Teacher> lists = new ArrayList<>();
		try {
			conn = DBfactory.getConn();
			ps = conn.prepareStatement(QUERYALL_SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setTech_id(rs.getInt("tech_id"));
				teacher.setTech_name(rs.getString("tech_name"));
				teacher.setTech_password(rs.getString("tech_password"));
				teacher.setSub_id(rs.getInt("sub_id"));
				lists.add(teacher);
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
		Teacher teacher = new Teacher();
		try {
			conn = DBfactory.getConn();
			ps = conn.prepareStatement(QUERYONEBYID_SQL);
			ps.setInt(1, Integer.parseInt(id));
			rs = ps.executeQuery();
			rs.next();
			teacher.setTech_id(rs.getInt("tech_id"));
			teacher.setTech_name(rs.getString("tech_name"));
			teacher.setTech_password(rs.getString("tech_password"));
			teacher.setSub_id(rs.getInt("sub_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Idao.close(conn, ps, rs);
		}
		return teacher;
	}

	public boolean check(Teacher unCheckTeacher) {
		Teacher teacher = (Teacher) queryOneById(unCheckTeacher.getTech_id() + "");
		if (teacher.getTech_password() == null)
			return false;
		else {
			return teacher.getTech_password().equals(unCheckTeacher.getTech_password());
		}
	}

}
