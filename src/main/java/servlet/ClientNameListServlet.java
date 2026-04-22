package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.ClientNameListsDAO;
import model.ClientNameList;

/**
 * Servlet implementation class ClientNameListServlet
 */
@WebServlet("/ClientNameListServlet")
public class ClientNameListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		    ClientNameListsDAO cnldao = new ClientNameListsDAO();
		    List<ClientNameList> cnList_List = cnldao.create_cnl();
	    	// 2回呼び出すので、1回だけのリクエストスコープではなく、セッションスコープへ修正
	    	  HttpSession session10 = request.getSession(); // セッションを取得
	    	  session10.setAttribute("cnList_List", cnList_List);
	    	  
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientNameList.jsp");
	          dispatcher.forward(request, response);
	}



}
