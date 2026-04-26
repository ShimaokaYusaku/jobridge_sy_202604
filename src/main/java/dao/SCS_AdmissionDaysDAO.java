package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.StaffClientSupport;
import model.SupportAccount;

public class SCS_AdmissionDaysDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
  public SupportAccount findSupportInfo(StaffClientSupport scs) {
//	    Account account = null;
		  SupportAccount supportaccount4 = null;
	    
	    // JDBCドライバを読み込む(記載がなくてもよい)
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }	  
	    
	    // データベースへ接続
		try (Connection conn = DriverManager.getConnection(url, user, password)) {

	      // SELECT文を準備
	      String sql = "SELECT CLIENT_ID, CLIENT_LOGIN_NAME, CLIENT_NAME_SEI, CLIENT_NAME_MEI, ADMISSION_DAY FROM CLIENT WHERE CLIENT_NAME_SEI=? AND CLIENT_NAME_MEI=?";
//	      String sql = "SELECT CLIENT_LOGIN_NAME, CLIENT_PASS FROM CLIENT WHERE CLIENT_LOGIN_NAME = ? AND CLIENT_PASS = ?";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      
	      pStmt.setString(1, scs.getStaffClientSupport_name_sei());
	      pStmt.setString(2, scs.getStaffClientSupport_name_mei());

	      // SELECTを実行し、結果表を取得
	      ResultSet rs = pStmt.executeQuery();
	      
	      if (rs.next()) {
	        // ユーザーが存在したらデータを取得
	        // そのユーザーを表すAccountインスタンスを生成
	        int client_Id = rs.getInt("CLIENT_ID");
	        String name_sei = rs.getString("CLIENT_NAME_SEI");
	        String name_mei = rs.getString("CLIENT_NAME_MEI");
	        Date admissionday = rs.getDate("ADMISSION_DAY");
		    
	        supportaccount4 = new SupportAccount(client_Id, name_sei,name_mei, admissionday);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }

	    return supportaccount4;
	  }
	}
