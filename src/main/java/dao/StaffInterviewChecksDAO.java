package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.StaffInterviewCheck;
import model.StaffInterviewCheckList;

public class StaffInterviewChecksDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
  public List<StaffInterviewCheckList> create_sivc(StaffInterviewCheck sivc) {
	  
	    List<StaffInterviewCheckList> sivcList_List = new ArrayList<StaffInterviewCheckList>();
    
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

      pStmt1.setString(1, sivc.getStaffInterviewCheck_name_sei());
      pStmt1.setString(2, sivc.getStaffInterviewCheck_name_mei());


      // SELECTを実行し、結果表を取得
      ResultSet rs1 = pStmt1.executeQuery();
      
   // 1. CLIENT_IDを取得（ここは現状通り）
      if (rs1.next()) {
          String clientId = rs1.getString("CLIENT_ID");

          // 2. JOINを使ったSQLで一気に取得
          String sql2 = "SELECT S.STAFF_NAME_SEI, S.STAFF_NAME_MEI, I.INTERVIEW_DAY, I.INTERVIEW_RECORD " +
                        "FROM INTERVIEW I " +
                        "JOIN STAFF S ON I.STAFF_ID = S.STAFF_ID " +
                        "WHERE I.CLIENT_ID = ?";
          
          PreparedStatement pStmt2 = conn.prepareStatement(sql2);
          pStmt2.setString(1, clientId);
          ResultSet rs2 = pStmt2.executeQuery();

          while (rs2.next()) {
              // StaffInterviewCheckListのコンストラクタやセッターに合わせて値をセット
              StaffInterviewCheckList sivcList = new StaffInterviewCheckList();
              sivcList.setStaff_name_sei(rs2.getString("STAFF_NAME_SEI")); // ここで氏名が取れる
              sivcList.setStaff_name_mei(rs2.getString("STAFF_NAME_MEI"));
              sivcList.setInterview_day(rs2.getDate("INTERVIEW_DAY").toLocalDate());
              sivcList.setInterview_record(rs2.getString("INTERVIEW_RECORD"));
              
              sivcList_List.add(sivcList);
          }
      }
  } catch (SQLException e) {
      e.printStackTrace();
      return null;
  }
  // ここでエラーが出なくなります
  return sivcList_List;
}
}
