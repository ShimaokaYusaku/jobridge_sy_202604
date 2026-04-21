package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.AdminStaffResister;
import model.AdminStaffResisterLogic;
import model.LoginStaffAccount;

/**
 * Servlet implementation class AdminStaffResisterServle
 */
@WebServlet("/AdminStaffResisterServlet")
public class AdminStaffResisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "WEB-INF/jsp/AdminStaffResister.jsp");
	        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String admin_staff_login_name = request.getParameter("admin_staff_login_name");
	    String admin_staff_name_sei = request.getParameter("admin_staff_name_sei");
	    String admin_staff_name_mei = request.getParameter("admin_staff_name_mei");
	    String admin_staff_name_sei_kana = request.getParameter("admin_staff_name_sei_kana");
	    String admin_staff_name_mei_kana = request.getParameter("admin_staff_name_mei_kana");
	    String staff_authority = request.getParameter("staff_authority");
	    
	    jakarta.servlet.http.HttpSession session = request.getSession();
	    LoginStaffAccount staffaccount3 = (LoginStaffAccount) session.getAttribute("staffaccount3"); 
	    System.out.println("Dailyに持ち越されたaccount内の値は、"+staffaccount3);

	    // 入力値チェック
	    if (admin_staff_login_name != null && admin_staff_login_name.length() != 0 && admin_staff_name_sei != null && admin_staff_name_sei.length() != 0 && admin_staff_name_mei != null && admin_staff_name_mei.length() != 0 && admin_staff_name_sei_kana != null && admin_staff_name_sei_kana.length() != 0 && admin_staff_name_mei_kana != null && admin_staff_name_mei_kana.length() != 0 && staff_authority != null && staff_authority.length() != 0 ) {

	    
	        // ユーザー登録を作成してリストに追加

	        AdminStaffResister adminStaffResister =new AdminStaffResister(admin_staff_login_name, admin_staff_name_sei, admin_staff_name_mei, admin_staff_name_sei_kana, admin_staff_name_mei_kana, staff_authority);
	        System.out.println(admin_staff_login_name +", "+ admin_staff_name_sei +", "+ admin_staff_name_mei +", "+ admin_staff_name_sei_kana +", "+ admin_staff_name_mei_kana +", "+ staff_authority);
	        AdminStaffResisterLogic cdiLogic = new AdminStaffResisterLogic();
			boolean result = cdiLogic.execute_asr(adminStaffResister);
	        
	      
	      // ログイン処理の成否によって処理を分岐
	      if (result) { // 登録成功時

	        // フォワード（確認画面へ）
	    	  request.setAttribute("AdminStaffResister",adminStaffResister);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/AdminStaffResisterConfirm.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "すでに登録された内容がありましたので、もう一度、時間を変更して、入力してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/AdminStaffResisterConfirm.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    } else {
	      // エラーメッセージをリクエストスコープに保存
	  	  System.out.println("Staff情報の登録内容に空欄がありました・・・");
	      request.setAttribute("errorMsg", "入力されていない項目がありましたので、もう一度、最初から入力してください");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/AdminStaffResisterConfirm.jsp");
	      dispatcher.forward(request, response);

	    }
	    
	  }

}
