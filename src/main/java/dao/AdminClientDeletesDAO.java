package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.AdminClientDelete;

public class AdminClientDeletesDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
	public boolean create_acd(AdminClientDelete acd) {
		
		
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {

	      // INSERT文の準備(idは自動連番なので指定しなくてよい） CLIENT_PASSは書かなければデフォルト値が入ります。
  	  String sql = "DELETE FROM CLIENT WHERE CLIENT_NAME_SEI=? AND CLIENT_NAME_MEI=?";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      
	      // DELETE文中の「?」に使用する値を設定しSQLを完成

	      pStmt.setString(1, acd.getDelete_admin_client_name_sei());
	      pStmt.setString(2, acd.getDelete_admin_client_name_mei());

	      
    	  System.out.println("利用者様情報のDELETE処理途中・・・");

	      // INSERT文を実行（resultには追加された行数が代入される）
	      int result = pStmt.executeUpdate();
	      if (result != 1) {
	    	  System.out.println("利用者様情報のDELETEが出来ない");
	        return false;
	      }
	    } catch (SQLException e) {
	    	  System.out.println("サーバーへの接続が出来ていない");

      e.printStackTrace();
      return false;
	    }
	  System.out.println("利用者様情報のDELETE完了");
	    return true;
	  }
	}

