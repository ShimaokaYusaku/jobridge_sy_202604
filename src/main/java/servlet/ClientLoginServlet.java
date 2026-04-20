package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Account;
import model.ClientLogin;
import model.ClientLoginLogic;

@WebServlet("/ClientLoginServlet")
public class ClientLoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher(
        "WEB-INF/jsp/clientLogin.jsp");
    dispatcher.forward(request, response);
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String client_login_name = request.getParameter("client_login_name");
	    String client_pass = request.getParameter("client_pass");
	    
	    // ログイン処理の実行
	    ClientLogin login = new ClientLogin(client_login_name, client_pass);
	    ClientLoginLogic bo = new ClientLoginLogic();
	    Account account = bo.execute(login);
	    
	    boolean result = account != null;

	    // ログイン処理の成否によって処理を分岐
	    if (result) { // ログイン成功時
	      // セッションスコープにログイン名だけを保存
	      HttpSession session1 = request.getSession();
	      session1.setAttribute("login_name", account.getclient_login_name());
	      System.out.println("ログインは成功");
	      
	      // フォワード
//	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/WEB-INF/jsp/clientMenu.jsp");
//	      dispatcher.forward(request, response);
	      
	      
	      // フォワードではなくリダイレクト　へ変更
//	      理由:ログインのような「状態が変わる処理」の後は、sendRedirect（リダイレクト） を使うのが
//	      Web開発の鉄則（PRGパターン：Post-Redirect-Get）です。
//	      フォワードだと、ブラウザのURLが変わらないため、「戻る」を押した時に「もう一度ログイン処理
//	      （POST）を送信しますか？」という警告が出たり、入力値が残りやすくなります。
	      response.sendRedirect("ClientMenuServlet"); 
	    } else { // ログイン失敗時
		      // フォワード
		      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/clientLoginAgain.jsp");
		      dispatcher.forward(request, response);
	      // リダイレクト
//	      response.sendRedirect("ClientLoginServlet");
	    }
	  }
}