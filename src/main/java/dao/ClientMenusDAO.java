package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.ClientLogin;
import model.LoginAccount;

public class ClientMenusDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
  public LoginAccount findLoginInfo(ClientLogin login) {
//    Account account = null;
	  LoginAccount account3 = null;
    
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {

      // SELECT文を準備
      String sql = "SELECT CLIENT_ID, CLIENT_LOGIN_NAME, NAME_SEI, NAME_MEI, EXPIRATION_START FROM CLIENT WHERE CLIENT_LOGIN_NAME = ? ";
//      String sql = "SELECT CLIENT_LOGIN_NAME, CLIENT_PASS FROM CLIENT WHERE CLIENT_LOGIN_NAME = ? AND CLIENT_PASS = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
//      pStmt.setInt(1, login.getClient_Id());
//      pStmt.setString(2, login.getClient_login_name());
//      pStmt.setString(3, login.getClient_pass());
      
      pStmt.setString(1, login.getClient_login_name());


      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();
      
      if (rs.next()) {
        // ユーザーが存在したらデータを取得
        // そのユーザーを表すAccountインスタンスを生成
        int client_Id = rs.getInt("CLIENT_ID");
        String name_sei = rs.getString("NAME_SEI");
        String name_mei = rs.getString("NAME_MEI");
        Date expiration_start = rs.getDate("EXPIRATION_START");
	    
//        account = new Account(client_login_name, client_pass);
        account3 = new LoginAccount(client_Id, name_sei,name_mei, expiration_start);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }

    return account3;
  }
}
