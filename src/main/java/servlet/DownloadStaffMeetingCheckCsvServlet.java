package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.StaffMeetingCheck;
import model.StaffMeetingCheckList;

/**
 * Servlet implementation class StaffMeetingCheckCsvServlet
 */
@WebServlet("/DownloadStaffMeetingCheckCsvServlet")
public class DownloadStaffMeetingCheckCsvServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // セッション等から表示中のデータを取得（csiListがセッションにある前提）
        HttpSession session = request.getSession();
        List<StaffMeetingCheckList> smtcList_List = (List<StaffMeetingCheckList>) session.getAttribute("smtcList_List");
        // セッション等から表示中のデータを取得（csiListがセッションにある前提）
        HttpSession session2 = request.getSession();
        StaffMeetingCheck smtcInfo2 = (StaffMeetingCheck) session2.getAttribute("smtcInfo2");
        
        if (smtcList_List == null) {
            response.sendRedirect("StaffMenuServlet");
            return;
        }

        // ファイル名とコンテンツタイプの設定
        String fileName = "staff_meeting_check_list.csv";
        response.setContentType("text/csv; charset=Shift_JIS"); // Excel対応のためShift_JIS
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try (PrintWriter pw = response.getWriter()) {
            // ヘッダー（項目名）の書き込み
            pw.println("担当者会議の記録リスト");
            pw.println("担当者の氏名," + smtcInfo2.getStaffMeetingCheck_name_sei() + " " + smtcInfo2.getStaffMeetingCheck_name_mei());
            pw.println("会議年月日　,参加職員１　,参加職員２　,参加職員３　,面談の記録　");

            // データの書き込み（拡張for文で1件ずつ処理）
            for (StaffMeetingCheckList smtcList : smtcList_List) {
                // 面談記録を取得
                String record = smtcList.getMeeting_record();
                
                if (record != null) {
                    // \r\n（Windows）、\n（Unix）、\r（旧Mac）のすべての改行コードを空文字またはスペースに置換
                    record = record.replace("\r\n", " ").replace("\n", " ").replace("\r", " ");
                } else {
                    record = "";
                }
                
                String staff2_sei = smtcList.getStaff2_name_sei();
                String staff2_mei = smtcList.getStaff2_name_mei();
                
                if (staff2_sei == null) { staff2_sei = " "; }
                if (staff2_mei == null) { staff2_mei = " "; }
                
                String staff3_sei = smtcList.getStaff3_name_sei();
                String staff3_mei = smtcList.getStaff3_name_mei();
                
                if (staff3_sei == null) { staff3_sei = " "; }
                if (staff3_mei == null) { staff3_mei = " "; }
                
                String staff4_sei = smtcList.getStaff4_name_sei();
                String staff4_mei = smtcList.getStaff4_name_mei();
                
                if (staff4_sei == null) { staff4_sei = " "; }
                if (staff4_mei == null) { staff4_mei = " "; }

                // カンマ区切りで出力
                pw.println(smtcList.getMeeting_day() + "," 
                         + staff2_sei + " " + staff2_mei + "," 
                         + staff3_sei + " " + staff3_mei + "," 
                         + staff4_sei + " " + staff4_mei + "," 
                         + record);
            }
            
            pw.flush();
        }

	}
}
