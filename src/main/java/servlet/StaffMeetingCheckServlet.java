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
import model.StaffMeetingCheck;
import model.StaffMeetingCheckList;
import model.StaffMeetingCheckLogic;

/**
 * Servlet implementation class StaffMeetingCheckServlet
 */
@WebServlet("/StaffMeetingCheckServlet")
public class StaffMeetingCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "WEB-INF/jsp/StaffMeetingCheck.jsp");
	        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		jakarta.servlet.http.HttpSession session = request.getSession();
		LoginStaffAccount staffaccount3 = (LoginStaffAccount) session.getAttribute("staffaccount3"); 
		System.out.println("Dailyに持ち越されたaccount内の値は、"+staffaccount3);
		
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String staffMeetingCheck_name_sei = staffaccount3.getstaff_name_sei();
	    String staffMeetingCheck_name_mei = staffaccount3.getstaff_name_mei();
		StaffMeetingCheck smtcInfo2 = new StaffMeetingCheck(staffMeetingCheck_name_sei, staffMeetingCheck_name_mei);
	    
	      // セッションスコープにログイン名だけを保存
	      HttpSession session12 = request.getSession();
	      session12.setAttribute("smtcInfo2", smtcInfo2);


	        System.out.println(staffMeetingCheck_name_sei +", "+ staffMeetingCheck_name_mei);
	        StaffMeetingCheckLogic smtcLogic = new StaffMeetingCheckLogic();
	        List<StaffMeetingCheckList> smtcList_List = smtcLogic.execute_smtc(smtcInfo2);
	        System.out.println(smtcList_List);
	        
	      
	      // ログイン処理の成否によって処理を分岐
	      if (smtcList_List!=null) { // 成功時


	        // フォワード（確認画面へ）
	    	// request.setAttribute("smtcList",smtcList);
	    	// 2回呼び出すので、1回だけのリクエストスコープではなく、セッションスコープへ修正
	    	  HttpSession session9 = request.getSession(); // セッションを取得
	    	  session9.setAttribute("smtcList_List", smtcList_List);    // セッションスコープに保存
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffMeetingCheckList.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "すでに登録された内容がありましたので、もう一度、時間を変更して、入力してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffMeetingCheckList.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    
	  }

}
