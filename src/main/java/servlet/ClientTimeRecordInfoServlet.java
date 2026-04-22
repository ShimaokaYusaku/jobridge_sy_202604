package servlet;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.ClientTimeRecordInfo;
import model.ClientTimeRecordInfoList;
import model.ClientTimeRecordInfoLogic;
import model.LoginStaffAccount;

/**
 * Servlet implementation class ClientTimeRecordInfoServlet
 */
@WebServlet("/ClientTimeRecordInfoServlet")
public class ClientTimeRecordInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	            "WEB-INF/jsp/ClientTimeRecordInfo.jsp");
	        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String timeRecordInfo_name_sei = request.getParameter("timeRecordInfo_name_sei");
	    String timeRecordInfo_name_mei = request.getParameter("timeRecordInfo_name_mei");
		ClientTimeRecordInfo ctrInfo2 = new ClientTimeRecordInfo(timeRecordInfo_name_sei, timeRecordInfo_name_mei);
	    
	      // セッションスコープにログイン名だけを保存
	      HttpSession session12 = request.getSession();
	      session12.setAttribute("ctrInfo2", ctrInfo2);

	    jakarta.servlet.http.HttpSession session = request.getSession();
	    LoginStaffAccount staffaccount3 = (LoginStaffAccount) session.getAttribute("staffaccount3"); 
	    System.out.println("Dailyに持ち越されたaccount内の値は、"+staffaccount3);

	    // 入力値チェック
	    if (timeRecordInfo_name_sei != null && timeRecordInfo_name_sei.length() != 0 && timeRecordInfo_name_mei != null && timeRecordInfo_name_mei.length() != 0 ) {

	    
	        // ユーザー登録を作成してリストに追加


	        System.out.println(timeRecordInfo_name_sei +", "+ timeRecordInfo_name_mei);
	        ClientTimeRecordInfoLogic ctriLogic = new ClientTimeRecordInfoLogic();
	        List<ClientTimeRecordInfoList> ctriList_List = ctriLogic.execute_ctri(ctrInfo2);
	        System.out.println(ctriList_List);
	        
	      
	      // ログイン処理の成否によって処理を分岐
	      if (ctriList_List!=null) { // 成功時
	    	  
	    	// 月ごとのリストを格納するMap (Key: "4", Value: その月のデータリスト)
	    	  Map<Integer, List<ClientTimeRecordInfoList>> monthlyMap = new HashMap<>();
	    	  // 月ごとの合計時間（分）を格納するMap
	    	  Map<Integer, Long> monthlyTotalMinutes = new HashMap<>();

	    	  for (ClientTimeRecordInfoList item : ctriList_List) {
	    	      // work_day (yyyy-MM-dd) から「月」を取り出す
	    	      LocalDate date = item.getWork_day();
	    	      int month = date.getMonthValue();

	    	      // 月ごとのリストに追加
	    	      monthlyMap.computeIfAbsent(month, k -> new ArrayList<>()).add(item);

	    	      // 時間計算
	    	      LocalTime start = LocalTime.parse(item.getStart_time());
	    	      LocalTime end = LocalTime.parse(item.getEnd_time());
	    	      long minutes = Duration.between(start, end).toMinutes();
	    	      monthlyTotalMinutes.put(month, monthlyTotalMinutes.getOrDefault(month, 0L) + minutes);
	    	  }

	    	  // 現在の月を取得
	    	  // 本日の日付を取得
	    	  LocalDate today = LocalDate.now();
	    	  // 今月の「月」を取得 (例: 4)
	    	  int currentMonth = today.getMonthValue();
	    	  // 前月の「月」を取得 (例: 3)
	    	  // 1月の場合でも、minusMonths(1) を使えば正しく前年12月を考慮した月が取れます
	    	  int lastMonth = today.minusMonths(1).getMonthValue();

	    	  // JSPへ渡す
	    	  request.setAttribute("currentMonth", currentMonth);
	    	  request.setAttribute("lastMonth", lastMonth);
	    	  request.setAttribute("monthlyMap", monthlyMap);
	    	  request.setAttribute("monthlyTotalMinutes", monthlyTotalMinutes);
	    	  
	    	  

	        // フォワード（確認画面へ）
	    	// request.setAttribute("ctriList",ctriList);
	    	// 2回呼び出すので、1回だけのリクエストスコープではなく、セッションスコープへ修正
	    	  HttpSession session9 = request.getSession(); // セッションを取得
	    	  session9.setAttribute("ctriList_List", ctriList_List);    // セッションスコープに保存
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientTimeRecordInfoList.jsp");
	        dispatcher.forward(request, response);
	      } else { // 登録失敗時

	    	  System.out.println("登録できませんでした・・・");
	          request.setAttribute("errorMsg", "すでに登録された内容がありましたので、もう一度、時間を変更して、入力してください");
	          RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientTimeRecordInfoList.jsp");
	          dispatcher.forward(request, response); // ★この一行を追加！
	      }
	      
	    } else {
	      // エラーメッセージをリクエストスコープに保存
	  	  System.out.println("利用者様情報の登録内容に空欄がありました・・・");
	      request.setAttribute("errorMsg", "入力されていない項目がありましたので、もう一度、最初から入力してください");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ClientTimeRecordInfoList.jsp");
	      dispatcher.forward(request, response);

	    }
	    
	  }

}
