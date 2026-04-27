package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.StaffClientSupportCheck;
import model.StaffClientSupportUpdate;

public class StaffClientSupportChecksDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
  public StaffClientSupportUpdate create_scsc(StaffClientSupportCheck scsc) {
	  
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
      String sql1 = "SELECT CLIENT_ID, CLIENT_NAME_SEI, CLIENT_NAME_MEI, ADMISSION_DAY FROM CLIENT WHERE CLIENT_NAME_SEI=? AND CLIENT_NAME_MEI=?";

      PreparedStatement pStmt1 = conn.prepareStatement(sql1);
      
      // SELECT文中の「?」に使用する値を設定しSQLを完成

      pStmt1.setString(1, scsc.getStaffClientSupportCheck_name_sei());
      pStmt1.setString(2, scsc.getStaffClientSupportCheck_name_mei());
      System.out.println("check名は、"+scsc.getStaffClientSupportCheck_name_sei());


      // SELECTを実行し、結果表を取得
      ResultSet rs1 = pStmt1.executeQuery();
      
   // 1. CLIENT_IDを取得（ここは現状通り）
      if (rs1.next()) {
	        int client_Id = rs1.getInt("CLIENT_ID");
	        String name_sei = rs1.getString("CLIENT_NAME_SEI");
	        String name_mei = rs1.getString("CLIENT_NAME_MEI");
	        Date admissionday = rs1.getDate("ADMISSION_DAY");
	        System.out.println("IDは、"+client_Id);

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
			        System.out.println("SQL内でのデータは、"+supportaccount12.getName_sei()+supportaccount12.getCompany());
          }
      }
  } catch (SQLException e) {
      e.printStackTrace();
      return null;
  }
  // ここでエラーが出なくなります
  return supportaccount12;
}
}