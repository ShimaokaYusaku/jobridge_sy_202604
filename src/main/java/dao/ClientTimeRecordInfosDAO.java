package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.ClientTimeRecordInfo;
import model.ClientTimeRecordInfoList;

public class ClientTimeRecordInfosDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
  public List<ClientTimeRecordInfoList> create_ctri(ClientTimeRecordInfo ctri) {
	  
	    List<ClientTimeRecordInfoList> ctriList_List = new ArrayList<ClientTimeRecordInfoList>();
    
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {

      // SELECT文を準備
      String sql1 = "SELECT CLIENT_ID FROM CLIENT WHERE CLIENT_NAME_SEI=? AND CLIENT_NAME_MEI=?";
//      String sql = "SELECT CLIENT_LOGIN_NAME, CLIENT_PASS FROM STAFF WHERE CLIENT_LOGIN_NAME = ? AND CLIENT_PASS = ?";
      PreparedStatement pStmt1 = conn.prepareStatement(sql1);
      
      // SELECT文中の「?」に使用する値を設定しSQLを完成

      pStmt1.setString(1, ctri.getTimeRecordInfo_name_sei());
      pStmt1.setString(2, ctri.getTimeRecordInfo_name_mei());


      // SELECTを実行し、結果表を取得
      ResultSet rs1 = pStmt1.executeQuery();
      
      if (rs1.next()) {
    	  String client_Id = rs1.getString("CLIENT_ID");
    	  
	      String sql2 = "SELECT WORK_DAY, START_TIME, END_TIME  FROM TIME_RECORD WHERE CLIENT_ID=?";
	      PreparedStatement pStmt2 = conn.prepareStatement(sql2);
	      
		   pStmt2.setString(1, client_Id);
		   
		      // SELECTを実行し、結果表を取得
		      ResultSet rs2 = pStmt2.executeQuery();
		   
	    	  System.out.println("勤怠情報取得中・・・");
      
	  // SELECT文の結果をArrayListに格納
	  while (rs2.next()) {
          // ここでの「ClientTimeRecordInfoList」という型宣言を削除し、外で宣言した変数に代入する
		  ClientTimeRecordInfoList ctriList = new ClientTimeRecordInfoList(LocalDate.parse(rs2.getString("WORK_DAY")), rs2.getString("START_TIME"), rs2.getString("END_TIME") );
          ctriList_List.add(ctriList);
      }
	   
      }
  } catch (SQLException e) {
      e.printStackTrace();
      return null;
  }
  // ここでエラーが出なくなります
  return ctriList_List;
}
}