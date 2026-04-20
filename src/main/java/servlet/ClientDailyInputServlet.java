package servlet;

import java.io.IOException;
import java.time.LocalTime;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.LoginAccount;
import model.ClientDaily;
import model.ClientDailyInputLogic;

/**
 * Servlet implementation class ClientDailyInputServlet
 */
@WebServlet("/ClientDailyInputServlet")
public class ClientDailyInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "WEB-INF/jsp/ClientDailyInput.jsp");
	        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String start_time = request.getParameter("start_time");
	    String end_time = request.getParameter("end_time");
	    String condition = request.getParameter("condition");
	    String work_record = request.getParameter("work_record");
	    String impression = request.getParameter("impression");
	    
	    jakarta.servlet.http.HttpSession session = request.getSession();
	    LoginAccount account3 = (LoginAccount) session.getAttribute("account3"); 
	    System.out.println("Dailyに持ち越されたaccount内の値は、"+account3);

	    // 入力値チェック
	    if (start_time != null && start_time.length() != 0 && end_time != null && end_time.length() != 0 && condition != null && condition.length() != 0 && work_record != null && work_record.length() != 0 && impression != null && impression.length() != 0) {

	    
	        // ユーザー登録を作成してリストに追加
	    	LocalTime starttime = LocalTime.parse(start_time);
	    	LocalTime endtime = LocalTime.parse(end_time);
	        ClientDaily clientdaily =new ClientDaily(starttime, endtime, condition, work_record, impression);
	        System.out.println(start_time+" "+ end_time+" "+ condition+" "+ work_record+" "+ impression);
	        ClientDailyInputLogic cdiLogic = new ClientDailyInputLogic();
			boolean result = cdiLogic.execute_cdi(clientdaily, account3);
	        
	      
	      // ログイン処理の成否によって処理を分岐
	      if (result) { // 登録成功時

	        // フォワード（確認画面へ）
	    	  request.setAttribute("clientdaily",clientdaily);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientDailyInputConfirm.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "すでに登録された内容がありましたので、もう一度、時間を変更して、入力してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientDailyInputConfirm.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    } else {
	      // エラーメッセージをリクエストスコープに保存
	  	  System.out.println("登録内容に空欄がありました・・・");
	      request.setAttribute("errorMsg", "入力されていない項目がありましたので、もう一度、最初から入力してください");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientDailyInputConfirm.jsp");
	      dispatcher.forward(request, response);

	    }
	    
	  }

}
