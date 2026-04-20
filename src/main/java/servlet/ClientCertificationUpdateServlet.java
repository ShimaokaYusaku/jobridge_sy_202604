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

import model.ClientExpirationUpdate;
import model.ClientExpirationUpdateLogic;
import model.LoginAccount;

/**
 * Servlet implementation class ClientDailyInputServlet
 */
@WebServlet("/ClientCertificationUpdateServlet")
public class ClientCertificationUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "WEB-INF/jsp/ClientCertificationUpdate.jsp");
	        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String expiration_next = request.getParameter("expiration_next");
	    System.out.println("expiration_nextの値は、"+expiration_next);
	    
	    jakarta.servlet.http.HttpSession session = request.getSession();
	    LoginAccount account3 = (LoginAccount) session.getAttribute("account3"); 

	    // 入力値チェック
	    if (expiration_next != null && expiration_next.length() != 0 ) {

	    
	        // ユーザー登録を作成してリストに追加
	    	LocalDate expirationnext = LocalDate.parse(expiration_next);
	    	ClientExpirationUpdate clientexpirationnext =new ClientExpirationUpdate(expirationnext);
	        System.out.println(expiration_next);
	        ClientExpirationUpdateLogic ceuLogic = new ClientExpirationUpdateLogic();
			boolean result = ceuLogic.execute_ceu(clientexpirationnext, account3);
	        
	      
	      // ログイン処理の成否によって処理を分岐
	      if (result) { // 登録成功時

	        // フォワード（確認画面へ）
	    	// LocalDateを文字列(String)に変換
	    	  DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
	    	  String formattedDate = clientexpirationnext.getExpirationnext().format(fmt);

	    	  // 文字列としてリクエストにセット
	    	  request.setAttribute("formattedNextDate", formattedDate);
	    	  
//	    	  request.setAttribute("clientexpirationnext",clientexpirationnext);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientCertificationUpdateConfirm.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "すでに登録された内容がありましたので、もう一度、時間を変更して、入力してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientCertificationUpdateConfirm.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    } else {
	      // エラーメッセージをリクエストスコープに保存
	  	  System.out.println("登録内容に空欄がありました・・・");
	      request.setAttribute("errorMsg", "入力されていない項目がありましたので、もう一度、最初から入力してください");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientCertificationUpdateConfirm.jsp");
	      dispatcher.forward(request, response);

	    }
	    
	  }

}
