package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.StaffMeetingCheck;
import model.StaffMeetingCheckList;

public class StaffMeetingChecksDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
  public List<StaffMeetingCheckList> create_smtc(StaffMeetingCheck smtc) {
	  
	    List<StaffMeetingCheckList> smtcList_List = new ArrayList<StaffMeetingCheckList>();
    
    // JDBCドライバを読み込む(記載がなくてもよい)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
    }	  
    
    // データベースへ接続
	try (Connection conn = DriverManager.getConnection(url, user, password)) {

      // SELECT文を準備
      String sql1 = "SELECT STAFF_ID FROM STAFF WHERE STAFF_NAME_SEI=? AND STAFF_NAME_MEI=?";
//      String sql = "SELECT CLIENT_LOGIN_NAME, CLIENT_PASS FROM STAFF WHERE CLIENT_LOGIN_NAME = ? AND CLIENT_PASS = ?";
      PreparedStatement pStmt1 = conn.prepareStatement(sql1);
      
      // SELECT文中の「?」に使用する値を設定しSQLを完成

      pStmt1.setString(1, smtc.getStaffMeetingCheck_name_sei());
      pStmt1.setString(2, smtc.getStaffMeetingCheck_name_mei());


      // SELECTを実行し、結果表を取得
      ResultSet rs1 = pStmt1.executeQuery();
      
   // 1. CLIENT_IDを取得（ここは現状通り）
      if (rs1.next()) {
          String staffId = rs1.getString("STAFF_ID");

       // 2. JOINを複数回使って、各IDに対応する名前を一気に取得
          String sql2 = "SELECT " +
                        "  S1.STAFF_NAME_SEI, S1.STAFF_NAME_MEI, " +
                        "  M.STAFF_ID2, S2.STAFF_NAME_SEI AS SEI2, S2.STAFF_NAME_MEI AS MEI2, " +
                        "  M.STAFF_ID3, S3.STAFF_NAME_SEI AS SEI3, S3.STAFF_NAME_MEI AS MEI3, " +
                        "  M.STAFF_ID4, S4.STAFF_NAME_SEI AS SEI4, S4.STAFF_NAME_MEI AS MEI4, " +
                        "  M.MEETING_DAY, M.MEETING_NOTE " +
                        "FROM MEETING_RECORD M " +
                        "JOIN STAFF S1 ON M.STAFF_ID = S1.STAFF_ID " + // 元々の担当者
                        "LEFT JOIN STAFF S2 ON M.STAFF_ID2 = S2.STAFF_ID " + // 2人目（必須ならJOINでも可）
                        "LEFT JOIN STAFF S3 ON M.STAFF_ID3 = S3.STAFF_ID " + // 3人目（NULL考慮）
                        "LEFT JOIN STAFF S4 ON M.STAFF_ID4 = S4.STAFF_ID " + // 4人目（NULL考慮）
                        "WHERE M.STAFF_ID = ?";

          PreparedStatement pStmt2 = conn.prepareStatement(sql2);
          pStmt2.setString(1, staffId);
          ResultSet rs2 = pStmt2.executeQuery();

          while (rs2.next()) {
              StaffMeetingCheckList smtcList = new StaffMeetingCheckList();
              
              // 1人目
              smtcList.setStaff_name_sei(rs2.getString("STAFF_NAME_SEI"));
              smtcList.setStaff_name_mei(rs2.getString("STAFF_NAME_MEI"));
              
              // 2人目 (ASで付けた別名で取得)
              smtcList.setStaff2_name_sei(rs2.getString("SEI2"));// NULLの場合はnullが返る
              smtcList.setStaff2_name_mei(rs2.getString("MEI2"));
              
              // 3人目
              smtcList.setStaff3_name_sei(rs2.getString("SEI3"));// NULLの場合はnullが返る
              smtcList.setStaff3_name_mei(rs2.getString("MEI3"));
              
              // 4人目
              smtcList.setStaff4_name_sei(rs2.getString("SEI4"));// NULLの場合はnullが返る
              smtcList.setStaff4_name_mei(rs2.getString("MEI4"));
              
              smtcList.setMeeting_day(rs2.getDate("MEETING_DAY").toLocalDate());
              smtcList.setMeeting_record(rs2.getString("MEETING_NOTE"));
              
              smtcList_List.add(smtcList);
          }
      }
  } catch (SQLException e) {
      e.printStackTrace();
      return null;
  }
  // ここでエラーが出なくなります
  return smtcList_List;
}
}
