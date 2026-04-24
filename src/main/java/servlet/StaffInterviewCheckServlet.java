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

import model.LoginStaffAccount;
import model.StaffInterviewCheck;
import model.StaffInterviewCheckList;
import model.StaffInterviewCheckLogic;

/**
 * Servlet implementation class StaffInterviewCheckServlet
 */
@WebServlet("/StaffInterviewCheckServlet")
public class StaffInterviewCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "WEB-INF/jsp/StaffInterviewCheck.jsp");
	        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String staffInterviewCheck_name_sei = request.getParameter("staffInterviewCheck_name_sei");
	    String staffInterviewCheck_name_mei = request.getParameter("staffInterviewCheck_name_mei");
		StaffInterviewCheck sivcInfo2 = new StaffInterviewCheck(staffInterviewCheck_name_sei, staffInterviewCheck_name_mei);
	    
	      // セッションスコープにログイン名だけを保存
	      HttpSession session12 = request.getSession();
	      session12.setAttribute("sivcInfo2", sivcInfo2);

	    jakarta.servlet.http.HttpSession session = request.getSession();
	    LoginStaffAccount staffaccount3 = (LoginStaffAccount) session.getAttribute("staffaccount3"); 
	    System.out.println("Dailyに持ち越されたaccount内の値は、"+staffaccount3);

	    // 入力値チェック
	    if (staffInterviewCheck_name_sei != null && staffInterviewCheck_name_sei.length() != 0 && staffInterviewCheck_name_mei != null && staffInterviewCheck_name_mei.length() != 0 ) {

	    
	        // ユーザー登録を作成してリストに追加


	        System.out.println(staffInterviewCheck_name_sei +", "+ staffInterviewCheck_name_mei);
	        StaffInterviewCheckLogic sivcLogic = new StaffInterviewCheckLogic();
	        List<StaffInterviewCheckList> sivcList_List = sivcLogic.execute_sivc(sivcInfo2);
	        System.out.println(sivcList_List);
	        
	      
	      // ログイン処理の成否によって処理を分岐
	      if (sivcList_List!=null) { // 成功時


	        // フォワード（確認画面へ）
	    	// request.setAttribute("sivcList",sivcList);
	    	// 2回呼び出すので、1回だけのリクエストスコープではなく、セッションスコープへ修正
	    	  HttpSession session9 = request.getSession(); // セッションを取得
	    	  session9.setAttribute("sivcList_List", sivcList_List);    // セッションスコープに保存
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffInterviewCheckList.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "すでに登録された内容がありましたので、もう一度、時間を変更して、入力してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffInterviewCheckList.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    } else {
	      // エラーメッセージをリクエストスコープに保存
	  	  System.out.println("利用者様情報の登録内容に空欄がありました・・・");
	      request.setAttribute("errorMsg", "入力されていない項目がありましたので、もう一度、最初から入力してください");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffInterviewCheckList.jsp");
	      dispatcher.forward(request, response);

	    }
	    
	  }

}
