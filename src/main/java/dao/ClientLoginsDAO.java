package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.ClientLogin;

public class ClientLoginsDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
  public Account findByLogin(ClientLogin login) {
//    Account account = null;
    Account account = null;
    
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {

      // SELECT文を準備
      String sql = "SELECT CLIENT_ID, CLIENT_LOGIN_NAME, CLIENT_PASS FROM CLIENT WHERE CLIENT_LOGIN_NAME = ? AND CLIENT_PASS = ?";
//      String sql = "SELECT CLIENT_LOGIN_NAME, CLIENT_PASS FROM CLIENT WHERE CLIENT_LOGIN_NAME = ? AND CLIENT_PASS = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
//      pStmt.setInt(1, login.getClient_Id());
//      pStmt.setString(2, login.getClient_login_name());
//      pStmt.setString(3, login.getClient_pass());
      
      
      pStmt.setString(1, login.getClient_login_name());
      pStmt.setString(2, login.getClient_pass());  //ログインパスワードはハッシュ化前の状態。　出来れば、BCrypt.hashpw() でハッシュ化してSQLに入れ、出してきた値をBCrypt.checkpw() で照合を行います。

      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();
      
      if (rs.next()) {
        // ユーザーが存在したらデータを取得
        // そのユーザーを表すAccountインスタンスを生成
//        int client_Id = rs.getInt("CLIENT_ID");
        String client_login_name = rs.getString("CLIENT_LOGIN_NAME");
        String client_pass = rs.getString("CLIENT_PASS");
	    
//        account = new Account(client_login_name, client_pass);
        account = new Account(client_login_name, client_pass);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }

    return account;
  }
}