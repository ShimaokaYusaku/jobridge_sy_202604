package servlet;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.StaffClientSupportInput;
import model.StaffClientSupportLogic;
import model.SupportAccount;

/**
 * Servlet implementation class StaffClientSupportInputServlet
 */
@WebServlet("/StaffClientSupportInputServlet")
public class StaffClientSupportInputServlet extends HttpServlet {
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
	    SupportAccount supportaccount4 = (SupportAccount) session.getAttribute("supportaccount4"); 

	    // --- leavingdayとjoindayが空欄でもよいためのif文の追加修正後 ---
	    LocalDate leavingday = null;
	    if (leaving_day != null && !leaving_day.isEmpty()) {
	        leavingday = LocalDate.parse(leaving_day);
	          System.out.println("Servletでのleavingdayは"+leavingday);
	    }

	    LocalDate joinday = null;
	    if (join_day != null && !join_day.isEmpty()) {
	        joinday = LocalDate.parse(join_day);
	    }

	    	StaffClientSupportInput scsi =new StaffClientSupportInput(leavingday, company, occupation, employ_type, working_hours, joinday, offer, employed, support_note);
	    	StaffClientSupportLogic scsLogic = new StaffClientSupportLogic();
			boolean result = scsLogic.execute_scs(supportaccount4, scsi);
	        
	      // ログイン処理の成否によって処理を分岐
	      if (result) { // 登録成功時

	        // フォワード（確認画面へ）
	    	  request.setAttribute("StaffClientSupportInput",scsi);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffClientSupportInputConfirm.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "すでに登録された内容がありましたので、もう一度、時間を変更して、入力してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/StaffClientSupportInputConfirm.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    
	  }

}
