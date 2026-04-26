package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.StaffClientSupport;
import model.StaffClientSupportInput;
import model.SupportAccount;

public class StaffClientSupportUpdatesDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
  public boolean create_scs(StaffClientSupport scs) {

	     
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {

      // SELECT文を準備
      String sql = "SELECT S.LEAVING_DAY, S.COMPANY, S.OCCUPATION, S.EMPLOY_TYPE, S.WORKING_HOURS, S.JOIN_DAY, S.OFFER, S.EMPLOYED, S.SUPPORT_NOTE" +
                   "FROM SUPPORT_RECORD S" + 
                   "JOIN CLIENT C ON S.CLIENT_ID = S.CLIENT_ID " +
    		       "WHERE CLIENT_NAME_SEI=? AND CLIENT_NAME_MEI=?";
      
      
//      String sql = "SELECT CLIENT_LOGIN_NAME, CLIENT_PASS FROM STAFF WHERE CLIENT_LOGIN_NAME = ? AND CLIENT_PASS = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      pStmt.setInt(1, scs.getStaffClientSupport_name_sei());
      pStmt.setInt(2, scs.getStaffClientSupport_name_mei());
      
      
      ResultSet rs = pStmt.executeQuery();

      if (rs.next()) {
      
      
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
