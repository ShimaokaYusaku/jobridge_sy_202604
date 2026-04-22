package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.ClientSingleInfo;
import model.ClientSingleInfoList;
import model.ClientSingleInfoLogic;
import model.LoginStaffAccount;

/**
 * Servlet implementation class ClientSingleInfoServlet
 */
@WebServlet("/ClientSingleInfoServlet")
public class ClientSingleInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "WEB-INF/jsp/ClientSingleInfo.jsp");
	        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String singleInfo_name_sei = request.getParameter("singleInfo_name_sei");
	    String singleInfo_name_mei = request.getParameter("singleInfo_name_mei");

	    jakarta.servlet.http.HttpSession session = request.getSession();
	    LoginStaffAccount staffaccount3 = (LoginStaffAccount) session.getAttribute("staffaccount3"); 
	    System.out.println("Dailyに持ち越されたaccount内の値は、"+staffaccount3);

	    // 入力値チェック
	    if (singleInfo_name_sei != null && singleInfo_name_sei.length() != 0 && singleInfo_name_mei != null && singleInfo_name_mei.length() != 0 ) {

	    
	        // ユーザー登録を作成してリストに追加

	        ClientSingleInfo clientSingleInfo =new ClientSingleInfo(singleInfo_name_sei, singleInfo_name_mei);
	        System.out.println(singleInfo_name_sei +", "+ singleInfo_name_mei);
	        ClientSingleInfoLogic asdLogic = new ClientSingleInfoLogic();
	        ClientSingleInfoList csiList = asdLogic.execute_csi(clientSingleInfo);
	        
	      
	      // ログイン処理の成否によって処理を分岐
	      if (csiList!=null) { // 登録成功時

	        // フォワード（確認画面へ）
	    	// request.setAttribute("csiList",csiList);
	    	// 2回呼び出すので、1回だけのリクエストスコープではなく、セッションスコープへ修正
	    	  HttpSession session9 = request.getSession(); // セッションを取得
	    	  session9.setAttribute("csiList", csiList);    // セッションスコープに保存
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientSingleInfoList.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "すでに登録された内容がありましたので、もう一度、時間を変更して、入力してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientSingleInfoList.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    } else {
	      // エラーメッセージをリクエストスコープに保存
	  	  System.out.println("Staff情報の登録内容に空欄がありました・・・");
	      request.setAttribute("errorMsg", "入力されていない項目がありましたので、もう一度、最初から入力してください");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientSingleInfoList.jsp");
	      dispatcher.forward(request, response);

	    }
	    
	  }

}
