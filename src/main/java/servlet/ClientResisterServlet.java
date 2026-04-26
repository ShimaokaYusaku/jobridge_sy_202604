package servlet;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.ClientResister;
import model.ClientResisterLogic;
import model.LoginStaffAccount;

/**
 * Servlet implementation class ClientResisterServlet
 */
@WebServlet("/ClientResisterServlet")
public class ClientResisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "WEB-INF/jsp/ClientResister.jsp");
	        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String client_login_name = request.getParameter("client_login_name");
	    String client_name_sei = request.getParameter("client_name_sei");
	    String client_name_mei = request.getParameter("client_name_mei");
	    String client_name_sei_kana = request.getParameter("client_name_sei_kana");
	    String client_name_mei_kana = request.getParameter("client_name_mei_kana");
	    String birth_day = request.getParameter("birthday");
	    String gender = request.getParameter("gender");
	    String address = request.getParameter("address");
	    String phone = request.getParameter("phone");
	    String admission_day = request.getParameter("admission_day");
	    String emergency_name = request.getParameter("emergency_name");
	    String emergency_rel = request.getParameter("emergency_rel");
	    String emergency_phone = request.getParameter("emergency_phone");
	    String disability = request.getParameter("disability");
	    String expiration_start = request.getParameter("expiration_start");
	    String hospital = request.getParameter("hospital");
	    String doctor = request.getParameter("doctor");
	    String disability_type = request.getParameter("disability_type");
	    String disability_grade = request.getParameter("disability_grade");
	    String station = request.getParameter("station");
	    String expenses = request.getParameter("expenses");
	    String route = request.getParameter("route");
	    
	    jakarta.servlet.http.HttpSession session = request.getSession();
	    LoginStaffAccount staffaccount3 = (LoginStaffAccount) session.getAttribute("staffaccount3"); 
	    System.out.println("Dailyに持ち越されたaccount内の値は、"+staffaccount3);

	    // 入力値チェック
	    if (client_login_name != null && client_login_name.length() != 0 && client_name_sei != null && client_name_sei.length() != 0 && client_name_mei != null && client_name_mei.length() != 0 && client_name_sei_kana != null && client_name_sei_kana.length() != 0 && client_name_mei_kana != null && client_name_mei_kana.length() != 0 && birth_day != null && birth_day.length() != 0  && gender != null && gender.length() != 0 && address != null && address.length() != 0 && phone != null && phone.length() != 0 && admission_day != null && admission_day.length() != 0  && emergency_name != null && emergency_name.length() != 0 && emergency_rel != null && emergency_rel.length() != 0 && emergency_phone != null && emergency_phone.length() != 0 && disability != null && disability.length() != 0 && expiration_start != null && expiration_start.length() != 0 && hospital != null && hospital.length() != 0 && doctor != null && doctor.length() != 0 && disability_type != null && disability_type.length() != 0 && disability_grade != null && disability_grade.length() != 0 && station != null && station.length() != 0 && expenses != null && expenses.length() != 0 && route != null && route.length() != 0 ) {

	    
	        // ユーザー登録を作成してリストに追加
	    	LocalDate birthday = LocalDate.parse(birth_day);
	    	LocalDate admissionday = LocalDate.parse(admission_day);
	    	LocalDate expirationstart = LocalDate.parse(expiration_start);


	        ClientResister clientResister =new ClientResister(client_login_name, client_name_sei, client_name_mei, client_name_sei_kana, client_name_mei_kana, birthday, gender, address, phone, admissionday, emergency_name, emergency_rel, emergency_phone, disability, expirationstart, hospital, doctor, disability_type, disability_grade, station, expenses, route);
	        System.out.println(client_login_name +", "+ client_name_sei +", "+ client_name_mei +", "+ client_name_sei_kana +", "+ client_name_mei_kana);
	        ClientResisterLogic crLogic = new ClientResisterLogic();
			boolean result = crLogic.execute_cr(clientResister);
	        
	      
	      // ログイン処理の成否によって処理を分岐
	      if (result) { // 登録成功時

	        // フォワード（確認画面へ）
	    	  request.setAttribute("ClientResister",clientResister);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientResisterConfirm.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "すでに登録された内容がありましたので、もう一度、時間を変更して、入力してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientResisterConfirm.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    } else {
	      // エラーメッセージをリクエストスコープに保存
	  	  System.out.println("Staff情報の登録内容に空欄がありました・・・");
	      request.setAttribute("errorMsg", "入力されていない項目がありましたので、もう一度、最初から入力してください");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientResisterConfirm.jsp");
	      dispatcher.forward(request, response);

	    }
	    
	  }

}
