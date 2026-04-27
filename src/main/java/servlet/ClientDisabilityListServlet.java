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

import dao.ClientDisabilityListsDAO;
import model.ClientDisabilityList;

/**
 * Servlet implementation class ClientDisabilityListServlet
 */
@WebServlet("/ClientDisabilityListServlet")
public class ClientDisabilityListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
	    ClientDisabilityListsDAO cdldao = new ClientDisabilityListsDAO();
	    List<ClientDisabilityList> cdList_List = cdldao.create_cdl();
    	// 2回呼び出すので、1回だけのリクエストスコープではなく、セッションスコープへ修正
    	  HttpSession session10 = request.getSession(); // セッションを取得
    	  session10.setAttribute("cdList_List", cdList_List);
    	  
    	  
          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientDisabilityList.jsp");
          dispatcher.forward(request, response);
}



}
