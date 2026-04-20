package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.StaffAccount;
import model.StaffLogin;
import model.StaffLoginLogic;

/**
 * Servlet implementation class StaffLoginServlet
 */
@WebServlet("/StaffLoginServlet")
public class StaffLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    RequestDispatcher dispatcher = request.getRequestDispatcher(
		        "WEB-INF/jsp/staffLogin.jsp");
		    dispatcher.forward(request, response);
		  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    // リクエストパラメータの取得
		    request.setCharacterEncoding("UTF-8");
		    String staff_login_name = request.getParameter("staff_login_name");
		    String staff_pass = request.getParameter("staff_pass");
		    
		    // ログイン処理の実行
		    StaffLogin staff_login = new StaffLogin(staff_login_name, staff_pass);
		    StaffLoginLogic sll = new StaffLoginLogic();
		    StaffAccount staffaccount = sll.execute_staff(staff_login);
		    
		    boolean result = staffaccount != null;

		    // ログイン処理の成否によって処理を分岐
		    if (result) { // ログイン成功時
		      // セッションスコープにログイン名だけを保存
		      HttpSession session3 = request.getSession();
		      session3.setAttribute("staff_login_name", staffaccount.getstaff_login_name());
		      System.out.println("ログインは成功");
		      
		      // フォワード
//		      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/WEB-INF/jsp/staffMenu.jsp");
//		      dispatcher.forward(request, response);
		      
		      
		      // フォワードではなくリダイレクト　へ変更
//		      理由:ログインのような「状態が変わる処理」の後は、sendRedirect（リダイレクト） を使うのが
//		      Web開発の鉄則（PRGパターン：Post-Redirect-Get）です。
//		      フォワードだと、ブラウザのURLが変わらないため、「戻る」を押した時に「もう一度ログイン処理
//		      （POST）を送信しますか？」という警告が出たり、入力値が残りやすくなります。
		      response.sendRedirect("StaffMenuServlet"); 
		    } else { // ログイン失敗時
			      // フォワード
			      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/staffLoginAgain.jsp");
			      dispatcher.forward(request, response);
		      // リダイレクト
//		      response.sendRedirect("StaffLoginServlet");
		    }
		  }
	}
