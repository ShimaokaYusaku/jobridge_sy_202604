package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import model.StaffClientSupportInput;
import model.SupportAccount;

public class StaffClientSupportsDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
  public boolean create_scs(SupportAccount supportaccount4, StaffClientSupportInput scsi) {
	  
	  	Date admissionday = supportaccount4.getAdmissionday();
	     
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {

      // SELECT文を準備
      String sql = "INSERT INTO SUPPORT_RECORD(CLIENT_ID, ADMISSION_DAY, LEAVING_DAY, COMPANY, OCCUPATION, EMPLOY_TYPE, WORKING_HOURS, JOIN_DAY, OFFER, EMPLOYED, SUPPORT_NOTE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//      String sql = "SELECT CLIENT_LOGIN_NAME, CLIENT_PASS FROM STAFF WHERE CLIENT_LOGIN_NAME = ? AND CLIENT_PASS = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      pStmt.setInt(1, supportaccount4.getClient_Id());
      pStmt.setDate(2, new java.sql.Date(admissionday.getTime()));
      // 修正後：nullチェックを入れる
      if (scsi.getLeavingday() != null) {
          pStmt.setDate(3, java.sql.Date.valueOf(scsi.getLeavingday()));
          System.out.println(scsi.getLeavingday());
      }else {
    	  pStmt.setNull(3, java.sql.Types.DATE); 
          System.out.println("scsi.getLeavingday()はなし");
      }
      pStmt.setString(4, scsi.getCompany());
      pStmt.setString(5, scsi.getOccupation());
      pStmt.setString(6, scsi.getEmploy_type());
      // 修正後：nullチェックを入れる
      if (scsi.getWorking_hours() != null) {
          pStmt.setFloat(7, scsi.getWorking_hours());
      }else {
    	  pStmt.setNull(7, java.sql.Types.FLOAT);
      }

      // 修正後：nullチェックを入れる
      if (scsi.getJoinday() != null) {
          pStmt.setDate(8, java.sql.Date.valueOf(scsi.getJoinday()));
      }else {
    	  pStmt.setNull(8, java.sql.Types.DATE); 
      }
      pStmt.setString(9, scsi.getOffer());
      pStmt.setString(10, scsi.getEmployed());
      pStmt.setString(11, scsi.getSupport_note());

      System.out.println("CLIENTのサポート情報のINSERT処理途中・・・");


      // INSERT文を実行（resultには追加された行数が代入される）
      int result = pStmt.executeUpdate();
      if (result != 1) {
    	  System.out.println("CLIENTのサポート情報のINSERTが出来ない");
        return false;
      }
    } catch (SQLException e) {
    	  System.out.println("サーバーへの接続が出来ていない");

  e.printStackTrace();
  return false;
    }
  System.out.println("CLIENTのサポート情報のINSERT完了");
    return true;
  }
}




