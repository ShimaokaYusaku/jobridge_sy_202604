package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ClientPassChange;
import model.LoginAccount;

public class ClientPassChangesDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
	public boolean change_cpc(ClientPassChange cpc, LoginAccount account3) {
			
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {
		
	      // SELECT文を準備
	      String sql1 = "SELECT CLIENT_ID, CLIENT_PASS FROM CLIENT WHERE CLIENT_ID = ?";
	      PreparedStatement pStmt1 = conn.prepareStatement(sql1);
	            
	      pStmt1.setInt(1, account3.getClient_Id());
	      // SELECTを実行し、結果表を取得
	      ResultSet rs1 = pStmt1.executeQuery();
	      
	      if (rs1.next()) {
		      // 登録されているパスワードの準備
	        String client_pass_old = rs1.getString("CLIENT_PASS");

	      // INSERT文の準備(idは自動連番なので指定しなくてよい）
	      String sql2 = "UPDATE CLIENT SET CLIENT_PASS = ? WHERE CLIENT_PASS = ?";
	      PreparedStatement pStmt2 = conn.prepareStatement(sql2);
	      
	      // INSERT文中の「?」に使用する値を設定しSQLを完成
		   pStmt2.setString(1, cpc.getClient_pass_next());
		   pStmt2.setString(2, client_pass_old);
	      
    	  System.out.println("パスワードのUPDATE処理途中・・・");

	      // INSERT文を実行（resultには追加された行数が代入される）
	      int result = pStmt2.executeUpdate();
	      if (result != 1) {
	    	  System.out.println("パスワードのUPDATEが出来きませんでした");
	        return false;
	      }
	      }
	    } catch (SQLException e) {
	    	  System.out.println("サーバーへの接続が出来ていない");

      e.printStackTrace();
      return false;
	    }
	  System.out.println("パスワードのUPDATE完了");
	    return true;
	  }
    
	}


