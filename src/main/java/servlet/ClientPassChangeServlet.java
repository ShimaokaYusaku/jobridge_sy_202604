package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.ClientPassChange;
import model.ClientPassChangeLogic;
import model.LoginAccount;

/**
 * Servlet implementation class ClientPassChangeServlet
 */
@WebServlet("/ClientPassChangeServlet")
public class ClientPassChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "WEB-INF/jsp/ClientPassChange.jsp");
	        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String client_pass_next = request.getParameter("client_pass_next");
	    String client_pass_next_again = request.getParameter("client_pass_next_again");

	    
	    jakarta.servlet.http.HttpSession session = request.getSession();
	    LoginAccount account3 = (LoginAccount) session.getAttribute("account3"); 

	    // 半角英数字（大文字・小文字・数字）の8文字以上20文字以内
	    String pattern = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z0-9]{8,20}$";
	    
	    // 入力値チェック
	    if (client_pass_next != client_pass_next_again && client_pass_next != null && client_pass_next.length() != 0 && client_pass_next.matches(pattern)) {

	    
	        // ユーザー登録を作成してリストに追加

		    ClientPassChange cpc = new ClientPassChange(client_pass_next);
	        ClientPassChangeLogic cpcLogic = new ClientPassChangeLogic();
			boolean result = cpcLogic.execute_cpc(cpc, account3);
	        
	      
	      // ログイン処理の成否によって処理を分岐
	      if (result) { // 登録成功時

	        // フォワード（確認画面へ）
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientPassChangeConfirm.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "データベースにて置き換えが出来なかったため、もう一度、やり直してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientPassChangeConfirm.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    } else {
	      // エラーメッセージをリクエストスコープに保存
	  	  System.out.println("入力した新しいパスワードがＮＧ");
	      request.setAttribute("errorMsg", "入力した新しいパスワードが、半角英数字（英文字と数字両方を少なくとも１字以上使用）で8文字以上20文字以内となっていないか、再入力と一致しない、または空欄となっていました・・・");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientPassChangeConfirm.jsp");
	      dispatcher.forward(request, response);

	    }
	    
	  }

}
