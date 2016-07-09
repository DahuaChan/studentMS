package cn.cdh.studentMS.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.cdh.studentMS.dao.StudentDao;


@WebServlet(name = "studentmanage", urlPatterns = { "/studentmanage" })
public class Studentmanage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Studentmanage() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDao studentDao = new StudentDao();
		List<?> lists = studentDao.queryAll();
		HttpSession session = request.getSession();
		session.setAttribute("stu_pagecount", lists.size());
		if(request.getParameter("stu_page")==null)
			request.setAttribute("stu_page", 1);
		else
			request.setAttribute("stu_page", request.getParameter("stu_page"));
		
		int page = Integer.parseInt(request.getAttribute("stu_page").toString());
		session.setAttribute("stu_list", studentDao.queryAny10Item(page*10-10, page*10));
		
		request.getRequestDispatcher("WEB-INF/public/studentmanage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
