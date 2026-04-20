package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.ClientLogin;
import model.ClientMenuLogic;
import model.LoginAccount;

/**
 * Servlet implementation class ClientMenuServlet
 */
@WebServlet("/ClientMenuServlet")
public class ClientMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    jakarta.servlet.http.HttpSession session = request.getSession();
	    String client_login_name = (String) session.getAttribute("login_name"); 

	    ClientLogin login = new ClientLogin(client_login_name);
	    ClientMenuLogic bo = new ClientMenuLogic();
	    LoginAccount account3 = bo.execute(login);

	      HttpSession session2 = request.getSession();
	      session2.setAttribute("account3", account3);
	      System.out.println("account3の作成成功");
	    
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/clientMenu.jsp");
	      dispatcher.forward(request, response);


	}
}
