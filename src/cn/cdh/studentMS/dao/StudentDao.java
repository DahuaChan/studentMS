package cn.cdh.studentMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.cdh.studentMS.model.Student;
import cn.cdh.studentMS.util.DBfactory;

public class StudentDao implements Idao {

	private static final String INSERT_SQL = "INSERT INTO student ( stu_id , stu_name , stu_password , sub_id , maj_id ) VALUES  ( ?,?,?,?,? )";
	private static final String DELETE_SQL = "DELETE dbo.student WHERE stu_id = ?";
	private static final String UPDATE_SQL = "UPDATE dbo.student SET stu_name = ? , stu_password ? , sub_id = ? , maj_id = ? WHERE stu_id = ?";
	private static final String QUERYALL_SQL = "SELECT * FROM student";
	private static final String QUERYONEBYID_SQL = "SELECT * FROM student WHERE stu_id = ?";

	String name;

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public StudentDao() {

	}

	@Override
	public void insert(Object o) {
		try {
			Student student = (Student) o;
			conn = DBfactory.getConn();
			ps = conn.prepareStatement(INSERT_SQL);
			ps.setInt(1, student.getStu_id());
			ps.setString(2, student.getStu_name().trim());
			ps.setString(3, student.getStu_password().trim());
			ps.setInt(4, student.getSub_id());
			ps.setInt(5, student.getMaj_id());
			ps.execute();
		} catch (SQLException e) {
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
			Student student = (Student) o;
			conn = DBfactory.getConn();
			ps = conn.prepareStatement(UPDATE_SQL);
			ps.setString(1, student.getStu_name().trim());
			ps.setString(2, student.getStu_password().trim());
			ps.setInt(3, student.getSub_id());
			ps.setInt(4, student.getMaj_id());
			ps.setInt(5, student.getStu_id());
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
		List<Student> lists = new ArrayList<>();
		try {
			conn = DBfactory.getConn();
			ps = conn.prepareStatement(QUERYALL_SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStu_id(rs.getInt("stu_id"));
				student.setStu_name(rs.getString("stu_name"));
				student.setStu_password(rs.getString("stu_password"));
				student.setSub_id(rs.getInt("sub_id"));
				student.setMaj_id(rs.getInt("maj_id"));
				lists.add(student);
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
		Student student = new Student();
		try {
			conn = DBfactory.getConn();
			ps = conn.prepareStatement(QUERYONEBYID_SQL);
			ps.setInt(1, Integer.parseInt(id));
			rs = ps.executeQuery();
			while (rs.next()) {
				student.setStu_id(rs.getInt("stu_id"));
				student.setStu_name(rs.getString("stu_name"));
				student.setStu_password(rs.getString("stu_password"));
				student.setSub_id(rs.getInt("sub_id"));
				student.setMaj_id(rs.getInt("maj_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Idao.close(conn, ps, rs);
		}
		return student;
	}
	
	public List<?> queryAny10Item(int startIndex,int endIndex){
		List<Student> lists = new ArrayList<>();
		try {
			int items = endIndex-startIndex;
			String SQL = "select top "+items+" * from (select top "+endIndex+" * from student order by stu_id asc) student order by stu_id desc ";
			conn = DBfactory.getConn();
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while(rs.next()){
				Student student = new Student();
				student.setStu_id(rs.getInt("stu_id"));
				student.setStu_name(rs.getString("stu_name"));
				student.setStu_password(rs.getString("stu_password"));
				student.setSub_id(rs.getInt("sub_id"));
				student.setMaj_id(rs.getInt("maj_id"));
				lists.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Idao.close(conn, ps, rs);
		}
		return lists;
		
	}

	public boolean check(Student unCheckStudent) {
		Student student = (Student) queryOneById(unCheckStudent.getStu_id() + "");
		if (student.getStu_password() == null)
			return false;
		else {
			return student.getStu_password().equals(unCheckStudent.getStu_password());
		}
	}

}
