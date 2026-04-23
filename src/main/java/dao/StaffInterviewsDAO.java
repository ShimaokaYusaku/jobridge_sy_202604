package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.LoginStaffAccount;
import model.StaffInterview;

public class StaffInterviewsDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
	public boolean create_siv(StaffInterview siv, LoginStaffAccount staffaccount3) {
		
		LocalDate interview_day = siv.getInterviewday();
		
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {
		
	      // SELECT文を準備
	      String sql = "SELECT CLIENT_ID FROM CLIENT WHERE CLIENT_NAME_SEI = ? AND CLIENT_NAME_MEI = ?  ";
//	      String sql = "SELECT CLIENT_LOGIN_NAME, CLIENT_PASS FROM CLIENT WHERE CLIENT_LOGIN_NAME = ? AND CLIENT_PASS = ?";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      
	      pStmt.setString(1, siv.getClient_name_sei());
	      pStmt.setString(2, siv.getClient_name_mei());

	      // SELECTを実行し、結果表を取得
	      ResultSet rs = pStmt.executeQuery();
    	  System.out.println("clientデータ情報："+siv.getClient_name_sei()+","+siv.getClient_name_mei());
	      
	      if (rs.next()) {

	        int client_Id = rs.getInt("CLIENT_ID");
		    
	      // INSERT文の準備(idは自動連番なので指定しなくてよい）
	      String sql2 = "INSERT INTO INTERVIEW(STAFF_ID, CLIENT_ID, INTERVIEW_DAY, INTERVIEW_RECORD) VALUES(?, ?, ?, ?)";
	      PreparedStatement pStmt2 = conn.prepareStatement(sql2);
	      
	      // INSERT文中の「?」に使用する値を設定しSQLを完成
	      pStmt2.setInt(1, staffaccount3.getStaff_Id());
	      pStmt2.setInt(2, client_Id);
		  pStmt2.setDate(3, java.sql.Date.valueOf(interview_day));
	      pStmt2.setString(4, siv.getInterview_record());
	      
    	  System.out.println("挿入するデータ："+staffaccount3.getStaff_Id()+","+client_Id+","+java.sql.Date.valueOf(interview_day)+","+siv.getInterview_record());

	      // INSERT文を実行（resultには追加された行数が代入される）
	      int result = pStmt2.executeUpdate();
	      if (result != 1) {
	    	  System.out.println("面談情報のINSERTが出来ない");
	        return false;
	      }
	      }
	    } catch (SQLException e) {
	    	  System.out.println("サーバーへの接続が出来ていない");

      e.printStackTrace();
      return false;
	    }
	  System.out.println("面談情報のINSERT完了");
	    return true;
	  }
	}




