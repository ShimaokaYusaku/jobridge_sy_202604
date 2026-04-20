package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import model.ClientExpirationUpdate;
import model.LoginAccount;

public class ClientExpirationUpdatesDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
	public boolean change_ceu(ClientExpirationUpdate ceu, LoginAccount account3) {
		
		Date expirationstart = account3.getExpiration_start();
		LocalDate expirationnext = ceu.getExpirationnext();
		
		
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {

	      // INSERT文の準備(idは自動連番なので指定しなくてよい）
	      String sql = "UPDATE CLIENT SET EXPIRATION_START = ? WHERE EXPIRATION_START = ?";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      
	      // INSERT文中の「?」に使用する値を設定しSQLを完成
	   // 1. LocalDate (expirationnext) の変換
	   // java.sql.Date.valueOf() を使います
	   pStmt.setDate(1, java.sql.Date.valueOf(expirationnext));
	   // 2. java.util.Date (expirationstart) の変換
	   // getTime() でミリ秒を取得して変換します
	   pStmt.setDate(2, new java.sql.Date(expirationstart.getTime()));
	      
    	  System.out.println("有効期限のUPDATE処理途中・・・");

	      // INSERT文を実行（resultには追加された行数が代入される）
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
	  System.out.println("有効期限のUPDATE完了");
	    return true;
	  }
	}


