package cn.cdh.studentMS.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cdh.studentMS.dao.StudentDao;
import cn.cdh.studentMS.model.Student;


@WebServlet(name = "add", urlPatterns = { "/add" })
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin")==null)
			return;
		String type = request.getParameter("type");
		if (type.equals("student")) {
			try {
				Student student = new Student();
				student.setStu_id(Integer.parseInt(request.getParameter("stu_id").trim()));
				student.setStu_name(new String(request.getParameter("stu_name").trim().getBytes("ISO-8859-1"),"utf-8"));
				student.setStu_password(request.getParameter("stu_password").trim());
				student.setSub_id(Integer.parseInt(request.getParameter("sub_name").trim()));
				student.setMaj_id(Integer.parseInt(request.getParameter("maj_name").trim()));
				new StudentDao().insert(student);
				response.sendRedirect("studentmanage");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				request.getRequestDispatcher("403.html").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
