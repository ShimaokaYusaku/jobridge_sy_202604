package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.LoginStaffAccount;
import model.StaffMeeting;

public class StaffMeetingsDAO {
	// 接続情報
	String url = "jdbc:mysql://localhost:3306/jobridge_202604"; // データベース名を指定
	String user = "root";
	String password = "root";
  
	public boolean create_smt(StaffMeeting smt, LoginStaffAccount staffaccount3) {
	    LocalDate meeting_day = smt.getMeetingday();

	    try (Connection conn = DriverManager.getConnection(url, user, password)) {
	        
	        // 1. Staff2のID取得（必須）
	        Integer staff2_Id = getStaffIdByName(conn, smt.getStaff2_name_sei(), smt.getStaff2_name_mei());
            System.out.println("Staff2のID"+staff2_Id );
	        if (staff2_Id == null) {
	            System.out.println("Staff2が見つかりません");
	            return false;
	        }

	        // 2. Staff3, 4のID取得（任意：名前があれば取得、なければnull）
	        Integer staff3_Id = null;
	        if (smt.getStaff3_name_sei() != null && smt.getStaff3_name_mei() != null) {
	            staff3_Id = getStaffIdByName(conn, smt.getStaff3_name_sei(), smt.getStaff3_name_mei());
	            System.out.println("Staff3のID"+staff3_Id );
	        }

	        Integer staff4_Id = null;
	        if (smt.getStaff4_name_sei() != null && smt.getStaff4_name_mei() != null) {
	            staff4_Id = getStaffIdByName(conn, smt.getStaff4_name_sei(), smt.getStaff4_name_mei());
	            System.out.println("Staff4のID"+staff4_Id );
	        }

	        // 3. INSERT実行
	        // カラム数と?の数が一致するように調整してください（例では提供されたSQLに合わせています）
	        String sqlInsert = "INSERT INTO MEETING_RECORD(STAFF_ID, STAFF_ID2, STAFF_ID3, STAFF_ID4, MEETING_DAY, MEETING_NOTE) VALUES(?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement pStmt = conn.prepareStatement(sqlInsert)) {
	            pStmt.setInt(1, staffaccount3.getStaff_Id());
	            pStmt.setInt(2, staff2_Id);
	            
	            // Staff3, 4はnullの可能性があるためsetObjectを使用するか、分岐させる
	            if (staff3_Id != null) pStmt.setInt(3, staff3_Id); else pStmt.setNull(3, java.sql.Types.INTEGER);
	            if (staff4_Id != null) pStmt.setInt(4, staff4_Id); else pStmt.setNull(4, java.sql.Types.INTEGER);
	            
	            pStmt.setDate(5, java.sql.Date.valueOf(meeting_day));
	            pStmt.setString(6, smt.getMeeting_record());

	            System.out.println("Staff4のID"+meeting_day +","+ smt.getMeeting_record());
	            
	            int result = pStmt.executeUpdate();
	            return result == 1;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	// 名前からIDを取得する共通メソッド（コードをスッキリさせるため）
	private Integer getStaffIdByName(Connection conn, String sei, String mei) throws SQLException {
	    String sql = "SELECT STAFF_ID FROM STAFF WHERE STAFF_NAME_SEI = ? AND STAFF_NAME_MEI = ?";
	    try (PreparedStatement pStmt = conn.prepareStatement(sql)) {
	        pStmt.setString(1, sei);
	        pStmt.setString(2, mei);
	        try (ResultSet rs = pStmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt("STAFF_ID");
	            }
	        }
	    }
	    return null;
	}
	}




