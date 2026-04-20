package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.StaffAccount;
import model.StaffLogin;

public class StaffLoginsDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
  public StaffAccount findByLogin_staff(StaffLogin login) {
//    Account account = null;
	  StaffAccount staffaccount = null;
    
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {

      // SELECT文を準備
      String sql = "SELECT STAFF_ID, STAFF_LOGIN_NAME, STAFF_PASS FROM STAFF WHERE STAFF_LOGIN_NAME = ? AND STAFF_PASS = ?";
//      String sql = "SELECT STAFF_LOGIN_NAME, STAFF_PASS FROM STAFF WHERE STAFF_LOGIN_NAME = ? AND STAFF_PASS = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
//      pStmt.setInt(1, login.getStaff_Id());
//      pStmt.setString(2, login.getStaff_login_name());
//      pStmt.setString(3, login.getStaff_pass());
      
      
      pStmt.setString(1, login.getStaff_login_name());
      pStmt.setString(2, login.getStaff_pass());  //ログインパスワードはハッシュ化前の状態。　出来れば、BCrypt.hashpw() でハッシュ化してSQLに入れ、出してきた値をBCrypt.checkpw() で照合を行います。

      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();
      
      if (rs.next()) {
        // ユーザーが存在したらデータを取得
        // そのユーザーを表すAccountインスタンスを生成
//        int staff_Id = rs.getInt("STAFF_ID");
        String staff_login_name = rs.getString("STAFF_LOGIN_NAME");
        String staff_pass = rs.getString("STAFF_PASS");
	    
//        account = new Account(staff_login_name, staff_pass);
        staffaccount = new StaffAccount(staff_login_name, staff_pass);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }

    return staffaccount;
  }
}
