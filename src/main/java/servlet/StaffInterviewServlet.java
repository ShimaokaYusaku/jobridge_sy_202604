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
import model.StaffInterview;
import model.StaffInterviewLogic;

/**
 * Servlet implementation class StaffInterviewServlet
 */
@WebServlet("/StaffInterviewServlet")
public class StaffInterviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "WEB-INF/jsp/StaffInterview.jsp");
	        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String client_name_sei = request.getParameter("client_name_sei");
	    String client_name_mei = request.getParameter("client_name_mei");
	    String interview_day = request.getParameter("interview_day");
	    String interview_record = request.getParameter("interview_record");
	    
	    jakarta.servlet.http.HttpSession session = request.getSession();
	    LoginStaffAccount staffaccount3 = (LoginStaffAccount) session.getAttribute("staffaccount3"); 
	    System.out.println("Dailyに持ち越されたaccount内の値は、"+staffaccount3);

	    // 入力値チェック
	    if (client_name_sei != null && client_name_sei.length() != 0 && client_name_mei != null && client_name_mei.length() != 0  && interview_day != null && interview_day.length() != 0 && interview_record != null && interview_record.length() != 0 ) {

	    
	        // ユーザー登録を作成してリストに追加
	    	LocalDate interviewday = LocalDate.parse(interview_day);
	        StaffInterview staffInterview =new StaffInterview(client_name_sei, client_name_mei, interviewday, interview_record);
	        System.out.println(client_name_sei +", "+ client_name_mei +", "+ interviewday +", "+ interview_record);
	        StaffInterviewLogic sivLogic = new StaffInterviewLogic();
			boolean result = sivLogic.execute_siv(staffInterview,staffaccount3);
	        
	      
	      // ログイン処理の成否によって処理を分岐
	      if (result) { // 登録成功時

	        // フォワード（確認画面へ）
		    	// LocalDateを文字列(String)に変換
	    	  DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
	    	  String formattedDate = staffInterview.getInterviewday().format(fmt);
	    	  // 文字列としてリクエストにセット
	    	  request.setAttribute("formattedDate", formattedDate);
	    	  
	    	  
	    	  request.setAttribute("StaffInterview", staffInterview);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffInterviewConfirm.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "すでに登録された内容がありましたので、もう一度、時間を変更して、入力してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffInterviewConfirm.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    } else {
	      // エラーメッセージをリクエストスコープに保存
	  	  System.out.println("Staff情報の登録内容に空欄がありました・・・");
	      request.setAttribute("errorMsg", "入力されていない項目がありましたので、もう一度、最初から入力してください");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffInterviewConfirm.jsp");
	      dispatcher.forward(request, response);

	    }
	    
	  }

}
