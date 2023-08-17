package Java_Code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Create_Group")
public class Create_Group extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String groupName = request.getParameter("groupName");
		String adminName = request.getParameter("adminName");
		String password = request.getParameter("password");
		
		try{
			HttpSession session1 = request.getSession();
			session1.setAttribute("groupName", groupName);
			session1.setAttribute("adminName", adminName);
			session1.setAttribute("password", password);
			
			response.sendRedirect("Create_Group1.jsp");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
