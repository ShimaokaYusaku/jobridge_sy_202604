package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.StaffClientSupport;
import model.StaffClientSupportUpdate;

public class SCSU_AdmissionDaysDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
  public StaffClientSupportUpdate create_scsu(StaffClientSupport scs) {
//	    Account account = null;
		  StaffClientSupportUpdate supportaccount12 = null;
	    
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

	        
	        String sql2 = "SELECT LEAVING_DAY, COMPANY, OCCUPATION, EMPLOY_TYPE, WORKING_HOURS, JOIN_DAY, OFFER, EMPLOYED, SUPPORT_NOTE FROM SUPPORT_RECORD WHERE CLIENT_ID=?";
//		      String sql = "SELECT CLIENT_LOGIN_NAME, CLIENT_PASS FROM CLIENT WHERE CLIENT_LOGIN_NAME = ? AND CLIENT_PASS = ?";
		      PreparedStatement pStmt2 = conn.prepareStatement(sql2);
		      
		      pStmt2.setInt(1, client_Id);

		      // SELECTを実行し、結果表を取得
		      ResultSet rs2 = pStmt2.executeQuery();
		      
		      if (rs2.next()) {

			        Date leavingday = rs2.getDate("LEAVING_DAY");
			        String company = rs2.getString("COMPANY");
			        String occupation = rs2.getString("OCCUPATION");
			        String employ_type = rs2.getString("EMPLOY_TYPE");
			        float working_hours = rs2.getFloat("WORKING_HOURS");
			        Date joinday = rs2.getDate("JOIN_DAY");
			        String offer = rs2.getString("OFFER");
			        String employed = rs2.getString("EMPLOYED");
			        String support_note = rs2.getString("SUPPORT_NOTE");
			        
				    
			        supportaccount12 = new StaffClientSupportUpdate(name_sei, name_mei, admissionday, leavingday, company, occupation, employ_type, working_hours, joinday, offer, employed, support_note);
			        
		      }
	        
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }

	    return supportaccount12;
	  }
	}
