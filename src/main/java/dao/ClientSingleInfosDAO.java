package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.ClientSingleInfo;
import model.ClientSingleInfoList;


public class ClientSingleInfosDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
  public ClientSingleInfoList create_csi(ClientSingleInfo csi) {
	  
	    // 戻り値用の変数を、tryブロックの外（メソッドの先頭）で宣言・初期化する
	    ClientSingleInfoList csiList = null;
    
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {

      // SELECT文を準備
      String sql = "SELECT CLIENT_LOGIN_NAME, CLIENT_NAME_SEI, CLIENT_NAME_MEI, CLIENT_NAME_SEI_KANA, CLIENT_NAME_MEI_KANA, BIRTHDAY, GENDER, ADDRESS, PHONE, EMERGENCY_NAME, EMERGENCY_REL, EMERGENCY_PHONE, DISABILITY, EXPIRATION_START, HOSPITAL, DOCTOR, DISABILITY_TYPE, DISABILITY_GRADE, STATION, EXPENSES, ROUTE FROM CLIENT WHERE CLIENT_NAME_SEI=? AND CLIENT_NAME_MEI=?";
//      String sql = "SELECT CLIENT_LOGIN_NAME, CLIENT_PASS FROM STAFF WHERE CLIENT_LOGIN_NAME = ? AND CLIENT_PASS = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      // SELECT文中の「?」に使用する値を設定しSQLを完成

      pStmt.setString(1, csi.getSingleInfo_name_sei());
      pStmt.setString(2, csi.getSingleInfo_name_mei());


      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();
      
      if (rs.next()) {
          // ここでの「ClientSingleInfoList」という型宣言を削除し、外で宣言した変数に代入する
          csiList = new ClientSingleInfoList(
              rs.getString("CLIENT_LOGIN_NAME"),
              rs.getString("CLIENT_NAME_SEI"),
              rs.getString("CLIENT_NAME_MEI"),
              rs.getString("CLIENT_NAME_SEI_KANA"),
              rs.getString("CLIENT_NAME_MEI_KANA"),
              LocalDate.parse(rs.getString("BIRTHDAY")),
              rs.getString("GENDER"),
              rs.getString("ADDRESS"),
              rs.getString("PHONE"),
              rs.getString("EMERGENCY_NAME"),
              rs.getString("EMERGENCY_REL"),
              rs.getString("EMERGENCY_PHONE"),
              rs.getString("DISABILITY"),
              LocalDate.parse(rs.getString("EXPIRATION_START")),
              rs.getString("HOSPITAL"),
              rs.getString("DOCTOR"),
              rs.getString("DISABILITY_TYPE"),
              rs.getString("DISABILITY_GRADE"),
              rs.getString("STATION"),
              rs.getString("EXPENSES"),
              rs.getString("ROUTE")
          );
      }
  } catch (SQLException e) {
      e.printStackTrace();
      return null;
  }
  // ここでエラーが出なくなります
  return csiList;
}
}
      
//      
//      if (rs.next()) {
//
//    	  String client_login_name = rs.getString("CLIENT_LOGIN_NAME");
//    	  String client_name_sei = rs.getString("CLIENT_NAME_SEI");
//    	  String client_name_mei = rs.getString("CLIENT_NAME_MEI");
//    	  String client_name_sei_kana = rs.getString("CLIENT_NAME_SEI_KANA");
//    	  String client_name_mei_kana = rs.getString("CLIENT_NAME_MEI_KANA");
//    	  
//    	  LocalDate birthday = LocalDate.parse(rs.getString("BIRTHDAY"));
//    	  
//    	  String gender = rs.getString("GENDER");
//    	  String address = rs.getString("ADDRESS");
//    	  String phone = rs.getString("PHONE");
//    	  String emergency_name = rs.getString("EMERGENCY_NAME");
//    	  String emergency_rel = rs.getString("EMERGENCY_REL");
//    	  String emergency_phone = rs.getString("EMERGENCY_PHONE");
//    	  String disability = rs.getString("DISABILITY");
//    	  
//	      LocalDate expirationstart = LocalDate.parse(rs.getString("EXPIRATION_START"));
//    	  
//    	  String hospital = rs.getString("HOSPITAL");
//    	  String doctor = rs.getString("DOCTOR");
//    	  String disability_type = rs.getString("DISABILITY_TYPE");
//    	  String disability_grade = rs.getString("DISABILITY_GRADE");
//    	  String station = rs.getString("STATION");
//    	  String expenses = rs.getString("EXPENSES");
//    	  String route = rs.getString("ROUTE");
//	    
//    	  ClientSingleInfoList csiList = new ClientSingleInfoList(client_login_name, client_name_sei, client_name_mei, client_name_sei_kana, client_name_mei_kana, birthday, gender, address, phone, emergency_name, emergency_rel, emergency_phone, disability, expirationstart, hospital, doctor, disability_type, disability_grade, station, expenses, route);
//      }
//    } catch (SQLException e) {
//      e.printStackTrace();
//      return null;
//    }
//
//    return csiList;
//  }
//}
//
