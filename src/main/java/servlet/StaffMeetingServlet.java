package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.LoginStaffAccount;
import model.StaffMeeting;
import model.StaffMeetingLogic;

/**
 * Servlet implementation class StaffMeetingServlet
 */
@WebServlet("/StaffMeetingServlet")
public class StaffMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "WEB-INF/jsp/StaffMeeting.jsp");
	        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String staff2_name_sei = request.getParameter("staff2_name_sei");
	    String staff2_name_mei = request.getParameter("staff2_name_mei");
	    String staff3_name_sei = request.getParameter("staff3_name_sei");
	    String staff3_name_mei = request.getParameter("staff3_name_mei");
	    String staff4_name_sei = request.getParameter("staff4_name_sei");
	    String staff4_name_mei = request.getParameter("staff4_name_mei");
	    String meeting_day = request.getParameter("meeting_day");
	    String meeting_record = request.getParameter("meeting_record");
	    
	    jakarta.servlet.http.HttpSession session = request.getSession();
	    LoginStaffAccount staffaccount3 = (LoginStaffAccount) session.getAttribute("staffaccount3"); 
	    System.out.println("Dailyに持ち越されたaccount内の値は、"+staffaccount3);

	    // 入力値チェック
	    if (staff2_name_sei != null && staff2_name_sei.length() != 0 && staff2_name_mei != null && staff2_name_mei.length() != 0 && meeting_day != null && meeting_day.length() != 0 && meeting_record != null && meeting_record.length() != 0 ) {

	    
	        // ユーザー登録を作成してリストに追加
	    	LocalDate meetingday = LocalDate.parse(meeting_day);
	        StaffMeeting staffMeeting =new StaffMeeting(staff2_name_sei, staff2_name_mei, staff3_name_sei, staff3_name_mei, staff4_name_sei, staff4_name_mei, meetingday, meeting_record);
	        System.out.println(staff2_name_sei +", "+ staff2_name_mei +", "+ meetingday +", "+ meeting_record);
	        StaffMeetingLogic smtLogic = new StaffMeetingLogic();
			boolean result = smtLogic.execute_smt(staffMeeting,staffaccount3);
	        
	      
	      // ログイン処理の成否によって処理を分岐
	      if (result) { // 登録成功時

	        // フォワード（確認画面へ）
		    	// LocalDateを文字列(String)に変換
	    	  DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
	    	  String formattedDate = staffMeeting.getMeetingday().format(fmt);
	    	  // 文字列としてリクエストにセット
	    	  request.setAttribute("formattedDate", formattedDate);
	    	  
	    	  
	    	  request.setAttribute("StaffMeeting", staffMeeting);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffMeetingConfirm.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "すでに登録された内容がありましたので、もう一度、時間を変更して、入力してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffMeetingConfirm.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    } else {
	      // エラーメッセージをリクエストスコープに保存
	  	  System.out.println("担当者会議の情報に空欄がありました・・・");
	      request.setAttribute("errorMsg", "入力されていない項目がありましたので、もう一度、最初から入力してください");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffMeetingConfirm.jsp");
	      dispatcher.forward(request, response);

	    }
	    
	  }

}
