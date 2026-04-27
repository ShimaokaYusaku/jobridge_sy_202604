package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.ClientDisabilityList;

public class ClientDisabilityListsDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
  public List<ClientDisabilityList> create_cdl() {
	  
	    List<ClientDisabilityList> cdList_List = new ArrayList<ClientDisabilityList>();
	  
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {

      // SELECT文を準備
      String sql = "SELECT CLIENT_NAME_SEI, CLIENT_NAME_MEI, DISABILITY, EXPIRATION_START, DISABILITY_TYPE, DISABILITY_GRADE FROM CLIENT ORDER BY CLIENT_NAME_SEI_KANA ASC";
//      String sql = "SELECT CLIENT_LOGIN_NAME, CLIENT_PASS FROM STAFF WHERE CLIENT_LOGIN_NAME = ? AND CLIENT_PASS = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      // SELECT文を実行
      ResultSet rs = pStmt.executeQuery();

      // SELECT文の結果をArrayListに格納
      while (rs.next()) {
              String client_name_sei = rs.getString("CLIENT_NAME_SEI");
              String client_name_mei = rs.getString("CLIENT_NAME_MEI");
              String disability = rs.getString("DISABILITY");
              LocalDate expiration_day = LocalDate.parse(rs.getString("EXPIRATION_START"));
              String disability_type = rs.getString("DISABILITY_TYPE");
              String disability_grade = rs.getString("DISABILITY_GRADE");
              System.out.println("氏名："+ client_name_sei +" "+client_name_mei);
              ClientDisabilityList cdList = new ClientDisabilityList(client_name_sei, client_name_mei, disability, expiration_day, disability_type, disability_grade);
              cdList_List.add(cdList);
      }
  } catch (SQLException e) {
      e.printStackTrace();
      return null;
  }
  // ここでエラーが出なくなります
  return cdList_List;
}
}