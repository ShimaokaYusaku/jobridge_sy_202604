package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.StaffNameList;

public class StaffNameListsDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
  public List<StaffNameList> create_snl() {
	  
	    List<StaffNameList> snList_List = new ArrayList<StaffNameList>();
	  
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {

      // SELECT文を準備
      String sql = "SELECT STAFF_NAME_SEI, STAFF_NAME_MEI FROM STAFF ORDER BY STAFF_NAME_SEI_KANA ASC";
//      String sql = "SELECT CLIENT_LOGIN_NAME, CLIENT_PASS FROM STAFF WHERE CLIENT_LOGIN_NAME = ? AND CLIENT_PASS = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      // SELECT文を実行
      ResultSet rs = pStmt.executeQuery();

      // SELECT文の結果をArrayListに格納
      while (rs.next()) {
              String staff_name_sei = rs.getString("STAFF_NAME_SEI");
              String staff_name_mei = rs.getString("STAFF_NAME_MEI");
              System.out.println("氏名："+ staff_name_sei +" "+staff_name_mei);
              StaffNameList snList = new StaffNameList(staff_name_sei, staff_name_mei);
              snList_List.add(snList);
      }
  } catch (SQLException e) {
      e.printStackTrace();
      return null;
  }
  // ここでエラーが出なくなります
  return snList_List;
}
}