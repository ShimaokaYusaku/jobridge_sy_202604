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
import model.StaffClientSupportCheck;
import model.StaffClientSupportCheckLogic;
import model.StaffClientSupportUpdate;

/**
 * Servlet implementation class StaffClientSupportCheckServlet
 */
@WebServlet("/StaffClientSupportCheckServlet")
public class StaffClientSupportCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "WEB-INF/jsp/StaffClientSupportCheck.jsp");
	        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String staffClientSupportCheck_name_sei = request.getParameter("staffClientSupportCheck_name_sei");
	    String staffClientSupportCheck_name_mei = request.getParameter("staffClientSupportCheck_name_mei");
		StaffClientSupportCheck scscInfo2 = new StaffClientSupportCheck(staffClientSupportCheck_name_sei, staffClientSupportCheck_name_mei);
	    
	      // セッションスコープにログイン名だけを保存
	      HttpSession session12 = request.getSession();
	      session12.setAttribute("scscInfo2", scscInfo2);

	    jakarta.servlet.http.HttpSession session = request.getSession();
	    LoginStaffAccount staffaccount3 = (LoginStaffAccount) session.getAttribute("staffaccount3"); 
	    System.out.println("Dailyに持ち越されたaccount内の値は、"+staffaccount3);

	    // 入力値チェック
	    if (staffClientSupportCheck_name_sei != null && staffClientSupportCheck_name_sei.length() != 0 && staffClientSupportCheck_name_mei != null && staffClientSupportCheck_name_mei.length() != 0 ) {

	    
	        // ユーザー登録を作成してリストに追加


	        System.out.println(staffClientSupportCheck_name_sei +", "+ staffClientSupportCheck_name_mei);
	        StaffClientSupportCheckLogic scscLogic = new StaffClientSupportCheckLogic();
	        StaffClientSupportUpdate supportaccount12 = scscLogic.execute_scsc(scscInfo2);
	        System.out.println("supportaccount12は、"+supportaccount12);
	        
	      
	      // ログイン処理の成否によって処理を分岐
	      if (supportaccount12 !=null) { // 成功時


	        // フォワード（確認画面へ）
	    	// request.setAttribute("sivcList",sivcList);
	    	// 2回呼び出すので、1回だけのリクエストスコープではなく、セッションスコープへ修正
	    	  HttpSession session9 = request.getSession(); // セッションを取得
	    	  session9.setAttribute("StaffClientSupportCheck", supportaccount12);    // セッションスコープに保存
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffClientSupportCheckList.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "すでに登録された内容がありましたので、もう一度、時間を変更して、入力してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffClientSupportCheckList.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    } else {
	      // エラーメッセージをリクエストスコープに保存
	  	  System.out.println("利用者様情報の登録内容に空欄がありました・・・");
	      request.setAttribute("errorMsg", "入力されていない項目がありましたので、もう一度、最初から入力してください");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffClientSupportCheckList.jsp");
	      dispatcher.forward(request, response);

	    }
	    
	  }

}