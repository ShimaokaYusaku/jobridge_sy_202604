package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.AdminStaffDelete;
import model.AdminStaffDeleteLogic;
import model.LoginStaffAccount;


/**
 * Servlet implementation class AdminStaffDeleteServle
 */
@WebServlet("/AdminStaffDeleteServlet")
public class AdminStaffDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "WEB-INF/jsp/AdminStaffDelete.jsp");
	        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String delete_admin_staff_name_sei = request.getParameter("delete_admin_staff_name_sei");
	    String delete_admin_staff_name_mei = request.getParameter("delete_admin_staff_name_mei");

	    jakarta.servlet.http.HttpSession session = request.getSession();
	    LoginStaffAccount staffaccount3 = (LoginStaffAccount) session.getAttribute("staffaccount3"); 
	    System.out.println("Dailyに持ち越されたaccount内の値は、"+staffaccount3);

	    // 入力値チェック
	    if (delete_admin_staff_name_sei != null && delete_admin_staff_name_sei.length() != 0 && delete_admin_staff_name_mei != null && delete_admin_staff_name_mei.length() != 0 ) {

	    
	        // ユーザー登録を作成してリストに追加

	        AdminStaffDelete adminStaffDelete =new AdminStaffDelete(delete_admin_staff_name_sei, delete_admin_staff_name_mei);
	        System.out.println(delete_admin_staff_name_sei +", "+ delete_admin_staff_name_mei);
	        AdminStaffDeleteLogic asdLogic = new AdminStaffDeleteLogic();
			boolean result = asdLogic.execute_asd(adminStaffDelete);
	        
	      
	      // ログイン処理の成否によって処理を分岐
	      if (result) { // 登録成功時

	        // フォワード（確認画面へ）
	    	  request.setAttribute("AdminStaffDelete",adminStaffDelete);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/AdminStaffDeleteConfirm.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "すでに登録された内容がありましたので、もう一度、時間を変更して、入力してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/AdminStaffDeleteConfirm.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    } else {
	      // エラーメッセージをリクエストスコープに保存
	  	  System.out.println("Staff情報の登録内容に空欄がありました・・・");
	      request.setAttribute("errorMsg", "入力されていない項目がありましたので、もう一度、最初から入力してください");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/AdminStaffDeleteConfirm.jsp");
	      dispatcher.forward(request, response);

	    }
	    
	  }

}
