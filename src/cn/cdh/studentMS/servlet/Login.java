package cn.cdh.studentMS.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.cdh.studentMS.dao.AdminDao;
import cn.cdh.studentMS.dao.StudentDao;
import cn.cdh.studentMS.model.Admin;
import cn.cdh.studentMS.model.Student;

public class Login extends HttpServlet {
	/**
	 * 
	 */
	private String usertype;
	HttpSession session;
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		//判断是不是管理员登陆
		usertype = req.getParameter("usertype");
		if(usertype.equals("admin")){
			Admin admin = new Admin();
			admin.setId(req.getParameter("username"));
			admin.setPassword(req.getParameter("password"));
			checkAdmin(admin,resp,req);
		} else if(usertype.equals("student")){
			Student student = new Student();
			student.setStu_id(Integer.parseInt(req.getParameter("username").trim()));
			student.setStu_password(req.getParameter("password"));
			checkStudent(student, resp, req);
		} else if(usertype.equals("teacher")){
			Student student = new Student();
			student.setStu_id(Integer.parseInt(req.getParameter("username").trim()));
			student.setStu_password(req.getParameter("password"));
			checkStudent(student, resp, req);
		} else{
			resp.sendRedirect("404.html");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	private void checkAdmin(Admin admin,HttpServletResponse resp,HttpServletRequest req) throws IOException{
		AdminDao adminDao = new AdminDao();
		if(adminDao.check(admin)){
			session.setAttribute("admin", (Admin)adminDao.queryOneById(admin.getId()));
			resp.sendRedirect("admin");
		} else {
			resp.sendRedirect("404.html");
		}
		
	}
	
	private void checkStudent(Student student,HttpServletResponse resp,HttpServletRequest req) throws IOException{
		StudentDao studentDao = new StudentDao();
		if(studentDao.check(student)){
			session.setAttribute("student", (Student)studentDao.queryOneById(student.getStu_id()+""));
			resp.sendRedirect("admin");
		} else {
			resp.sendRedirect("404.html");
		}
		
	}

}
