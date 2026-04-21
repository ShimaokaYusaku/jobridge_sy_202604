package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import model.ClientResister;

public class ClientResistersDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
	public boolean create_cr(ClientResister cr) {
		
		LocalDate birthday = cr.getBirthday();
		LocalDate expirationstart = cr.getExpiration_start();
		
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {

	      // INSERT文の準備(idは自動連番なので指定しなくてよい） CLIENT_PASSは書かなければデフォルト値が入ります。
  	  String sql = "INSERT INTO CLIENT(CLIENT_LOGIN_NAME, CLIENT_NAME_SEI, CLIENT_NAME_MEI, CLIENT_NAME_SEI_KANA, CLIENT_NAME_MEI_KANA, BIRTHDAY, GENDER, ADDRESS, PHONE, EMERGENCY_NAME, EMERGENCY_REL, EMERGENCY_PHONE, DISABILITY, EXPIRATION_START, HOSPITAL, DOCTOR, DISABILITY_TYPE, DISABILITY_GRADE, STATION, EXPENSES, ROUTE) VALUES(?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?, ?, ?)";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      
	      // INSERT文中の「?」に使用する値を設定しSQLを完成

	      pStmt.setString(1, cr.getClient_login_name());
	      pStmt.setString(2, cr.getClient_name_sei());
	      pStmt.setString(3, cr.getClient_name_mei());
	      pStmt.setString(4, cr.getClient_name_sei_kana());
	      pStmt.setString(5, cr.getClient_name_mei_kana());
	      pStmt.setDate(6, java.sql.Date.valueOf(birthday));
	      pStmt.setString(7, cr.getGender());
	      pStmt.setString(8, cr.getAddress());
	      pStmt.setString(9, cr.getPhone());
	      pStmt.setString(10, cr.getEmergency_name());
	      pStmt.setString(11, cr.getEmergency_rel());
	      pStmt.setString(12, cr.getEmergency_phone());
	      pStmt.setString(13, cr.getDisability());
	      pStmt.setDate(14, java.sql.Date.valueOf(expirationstart));
	      pStmt.setString(15, cr.getHospital());
	      pStmt.setString(16, cr.getDoctor());
	      pStmt.setString(17, cr.getDisability_type());
	      pStmt.setString(18, cr.getDisability_grade());
	      pStmt.setString(19, cr.getStation());
	      pStmt.setString(20, cr.getExpenses());
	      pStmt.setString(21, cr.getRoute());
	      
    	  System.out.println("CLIENT情報のINSERT処理途中・・・");


	      // INSERT文を実行（resultには追加された行数が代入される）
	      int result = pStmt.executeUpdate();
	      if (result != 1) {
	    	  System.out.println("CLIENT情報のINSERTが出来ない");
	        return false;
	      }
	    } catch (SQLException e) {
	    	  System.out.println("サーバーへの接続が出来ていない");

      e.printStackTrace();
      return false;
	    }
	  System.out.println("CLIENT情報のINSERT完了");
	    return true;
	  }
	}




