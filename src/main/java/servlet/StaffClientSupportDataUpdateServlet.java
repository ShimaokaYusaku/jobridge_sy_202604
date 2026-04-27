package servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.StaffClientSupportUpdate;
import model.StaffClientSupportUpdateLogic;

/**
 * Servlet implementation class StaffClientSupportDataUpdate
 */
@WebServlet("/StaffClientSupportDataUpdateServlet")
public class StaffClientSupportDataUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String leaving_day = request.getParameter("leaving_day");
	    String company = request.getParameter("company");
	    String occupation = request.getParameter("occupation");
	    String employ_type = request.getParameter("employ_type");
	    
	    Float working_hours = null;  // デフォルト値
	    // 入力があった場合のみ値を代入するロジック（例）
	    String workinghours = request.getParameter("working_hours");
	    if (workinghours != null && !workinghours.isEmpty()) {
	        working_hours = Float.parseFloat(workinghours);
	    }
	    
	    String join_day = request.getParameter("join_day");
	    String offer = request.getParameter("offer");
	    String employed = request.getParameter("employed");
	    String support_note = request.getParameter("support_note");

	    jakarta.servlet.http.HttpSession session = request.getSession();
	    StaffClientSupportUpdate supportaccount12 = (StaffClientSupportUpdate) session.getAttribute("supportaccount12"); 

	    // --- leavingdayとjoindayが空欄でもよいためのif文の追加修正後 ---
	    Date leavingday = null;
	    if (leaving_day != null && !leaving_day.isEmpty()) {
	        // 1. 文字列を一旦 LocalDate として解析
	        LocalDate ld = LocalDate.parse(leaving_day);
	        // 2. LocalDate から java.sql.Date へ直接変換して代入
	        leavingday = java.sql.Date.valueOf(ld);
	          System.out.println("Servletでのleavingdayは"+leavingday);
	    }

	    Date joinday = null;
	    if (join_day != null && !join_day.isEmpty()) {
	        LocalDate ld2 = LocalDate.parse(join_day);
	        joinday = java.sql.Date.valueOf(ld2);
	          System.out.println("Servletでのjoindayは"+joinday);
	    }

//	    StaffClientSupport scs = new StaffClientSupport(supportaccount12.getName_sei(), supportaccount12.getName_mei());
	    StaffClientSupportUpdate scsu =new StaffClientSupportUpdate(supportaccount12.getName_sei(), supportaccount12.getName_mei(), supportaccount12.getAdmissionday(), leavingday, company, occupation, employ_type, working_hours, joinday, offer, employed, support_note);
	    StaffClientSupportUpdateLogic scsuLogic = new StaffClientSupportUpdateLogic();
	    boolean scs_update = scsuLogic.execute_scsu(scsu);
	        
	      // ログイン処理の成否によって処理を分岐
	      if (scs_update) { // 登録成功時

	        // フォワード（確認画面へ）
	    	  request.setAttribute("StaffClientSupportDataUpdate",scsu);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffClientSupportUpdateConfirm.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "すでに登録された内容がありましたので、もう一度、時間を変更して、入力してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffClientSupportUpdateConfirm.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    
	  }

}
