package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.LoginStaffAccount;
import model.StaffLogin;
import model.StaffMenuLogic;


/**
 * Servlet implementation class StaffMenuServlet
 */
@WebServlet("/StaffMenuServlet")
public class StaffMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    jakarta.servlet.http.HttpSession session = request.getSession();
	    String staff_login_name = (String) session.getAttribute("staff_login_name"); 
	      System.out.println("staff_login_nameの値は、"+staff_login_name);

	    StaffLogin login = new StaffLogin(staff_login_name);
	    StaffMenuLogic bo = new StaffMenuLogic();
	    LoginStaffAccount staffaccount3 = bo.execute_staff(login);

	      HttpSession session4 = request.getSession();
	      session4.setAttribute("staffaccount3", staffaccount3);
	      System.out.println("staffaccount3のAuthorityの中身は、"+staffaccount3.getAuthority());
	      
	      if("Admin".equals(staffaccount3.getAuthority())) {
	    	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/AdminMenu.jsp");
		      dispatcher.forward(request, response);
	      } else {
		      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/staffMenu.jsp");
		      dispatcher.forward(request, response);
	      }


	}
}
