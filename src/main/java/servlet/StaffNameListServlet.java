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

import dao.StaffNameListsDAO;
import model.StaffNameList;

/**
 * Servlet implementation class StaffNameListServlet
 */
@WebServlet("/StaffNameListServlet")
public class StaffNameListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
	    StaffNameListsDAO snldao = new StaffNameListsDAO();
	    List<StaffNameList> snList_List = snldao.create_snl();
    	// 2回呼び出すので、1回だけのリクエストスコープではなく、セッションスコープへ修正
    	  HttpSession session11 = request.getSession(); // セッションを取得
    	  session11.setAttribute("snList_List", snList_List);
    	  
    	  
          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffNameList.jsp");
          dispatcher.forward(request, response);
}



}
