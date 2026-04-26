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
import model.StaffClientSupport;
import model.StaffClientSupportUpdateLogic;

/**
 * Servlet implementation class StaffClientSupportUpdateServlet
 */
@WebServlet("/StaffClientSupportUpdateServlet")
public class StaffClientSupportUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "WEB-INF/jsp/StaffClientSupport_second.jsp");
	        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String staffClientSupport_second_name_sei = request.getParameter("staffClientSupport_second_name_sei");
	    String staffClientSupport_second_name_mei = request.getParameter("staffClientSupport_second_name_mei");

	    jakarta.servlet.http.HttpSession session = request.getSession();
	    LoginStaffAccount staffaccount3 = (LoginStaffAccount) session.getAttribute("staffaccount3"); 
	    System.out.println("Dailyに持ち越されたaccount内の値は、"+staffaccount3);

	    // 入力値チェック
	    if (staffClientSupport_second_name_sei != null && staffClientSupport_second_name_sei.length() != 0 && staffClientSupport_second_name_mei != null && staffClientSupport_second_name_mei.length() != 0 ) {

	        StaffClientSupport staffClientSupport =new StaffClientSupport(staffClientSupport_second_name_sei, staffClientSupport_second_name_mei);
	        System.out.println(staffClientSupport_second_name_sei +", "+ staffClientSupport_second_name_mei);
	        
	    	StaffClientSupportUpdateLogic scsuLogic = new StaffClientSupportUpdateLogic();
			boolean result = scsuLogic.execute_scsu(scsu);
	      
	      // ログイン処理の成否によって処理を分岐
	      if (result!=null) { // 登録成功時

	        // フォワード（確認画面へ）
	    	// request.setAttribute("scsList",scsList);
	    	// 2回呼び出すので、1回だけのリクエストスコープではなく、セッションスコープへ修正
	    	  HttpSession session9 = request.getSession(); // セッションを取得
	    	  session9.setAttribute("StaffClientSupportUpdate", scsu);    // セッションスコープに保存
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffClientSupportUodate.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "登録できませんでした。もう一度、時間を変更して、入力してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffClientSupportUodate.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    } else {
	      // エラーメッセージをリクエストスコープに保存
	  	  System.out.println("利用者様情報の登録内容に空欄がありました・・・");
	      request.setAttribute("errorMsg", "入力されていない項目がありましたので、もう一度、最初から入力してください");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffClientSupportUodate.jsp");
	      dispatcher.forward(request, response);

	    }
	    
	  }

}
