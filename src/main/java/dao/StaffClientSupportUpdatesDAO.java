package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.StaffClientSupportUpdate;

public class StaffClientSupportUpdatesDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
  public boolean update_scsu(StaffClientSupportUpdate scsu) {

	     
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {

      // SELECT文を準備
      String sql = "UPDATE SUPPORT_RECORD S JOIN CLIENT C ON S.CLIENT_ID = C.CLIENT_ID SET S.LEAVING_DAY = ?, S.COMPANY = ?, S.OCCUPATION = ?, S.EMPLOY_TYPE = ?, S.WORKING_HOURS = ?, S.JOIN_DAY = ?, S.OFFER = ?, S.EMPLOYED = ?, S.SUPPORT_NOTE = ? "
                   + "WHERE C.CLIENT_NAME_SEI = ? AND C.CLIENT_NAME_MEI = ?";
      
      
//      String sql = "SELECT CLIENT_LOGIN_NAME, CLIENT_PASS FROM STAFF WHERE CLIENT_LOGIN_NAME = ? AND CLIENT_PASS = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      // 修正後：nullチェックを入れる
      if (scsu.getLeavingday() != null) {
    	    pStmt.setDate(1, new java.sql.Date(scsu.getLeavingday().getTime()));
    	    System.out.println(scsu.getLeavingday());
      }else {
    	  pStmt.setNull(2, java.sql.Types.DATE); 
          System.out.println("scsi.getLeavingday()はなし");
      }
      
      pStmt.setString(2, scsu.getCompany());
      pStmt.setString(3, scsu.getOccupation());
      pStmt.setString(4, scsu.getEmploy_type());
      pStmt.setFloat(5, scsu.getWorking_hours());
      
      // 修正後：nullチェックを入れる
      if (scsu.getLeavingday() != null) {
    	    pStmt.setDate(6, new java.sql.Date(scsu.getJoinday().getTime()));
    	    System.out.println(scsu.getJoinday());
      }else {
    	  pStmt.setNull(6, java.sql.Types.DATE); 
          System.out.println("scsu.getJoinday()はなし");
      }
            
      pStmt.setString(7, scsu.getOffer());
      pStmt.setString(8, scsu.getEmployed());
      pStmt.setString(9, scsu.getSupport_note());
      pStmt.setString(10, scsu.getName_sei());
      pStmt.setString(11, scsu.getName_mei());
      
      
      int result = pStmt.executeUpdate();
      if (result != 1) {
    	  System.out.println("UPDATEが出来きませんでした");
        return false;
      }
    } catch (SQLException e) {
    	  System.out.println("サーバーへの接続が出来ていない");

  e.printStackTrace();
  return false;
    }
  System.out.println("サポート情報のUPDATE完了");
    return true;
  }
}

