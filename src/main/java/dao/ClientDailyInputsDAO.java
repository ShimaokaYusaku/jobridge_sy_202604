package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import model.LoginAccount;
import model.ClientDaily;

public class ClientDailyInputsDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
	public boolean create_cdi(ClientDaily cd, LoginAccount account3) {
		
		LocalDate workingday = LocalDate.now();

		int client_id = account3.getClient_Id();
		
		
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {

	      // INSERT文の準備(idは自動連番なので指定しなくてよい）
	      String sql = "INSERT INTO TIME_RECORD(CLIENT_ID, WORK_DAY, START_TIME, END_TIME, BODYCONDITION, WORK_RECORD, IMPRESSION) VALUES(?, ?, ?, ?, ?, ?, ?)";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      
	      // INSERT文中の「?」に使用する値を設定しSQLを完成
	      pStmt.setInt(1, client_id);
	      pStmt.setObject(2, workingday);
	      pStmt.setTime(3, java.sql.Time.valueOf(cd.getStart_time()));
	      pStmt.setTime(4, java.sql.Time.valueOf(cd.getEnd_time()));
	      pStmt.setString(5, cd.getCondition());
	      pStmt.setString(6, cd.getWork_record());
	      pStmt.setString(7, cd.getImpression());
	      
    	  System.out.println("INSERTの処理途中・・・");

	      // INSERT文を実行（resultには追加された行数が代入される）
	      int result = pStmt.executeUpdate();
	      if (result != 1) {
	    	  System.out.println("INSERTが出来ない");
	        return false;
	      }
	    } catch (SQLException e) {
	    	  System.out.println("サーバーへの接続が出来ていない");

      e.printStackTrace();
      return false;
	    }
	  System.out.println("SQL完了");
	    return true;
	  }
	}




