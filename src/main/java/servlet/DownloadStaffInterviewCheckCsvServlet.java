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

import model.StaffInterviewCheck;
import model.StaffInterviewCheckList;

/**
 * Servlet implementation class DownloadStaffInterviewCheckCsvServlet
 */
@WebServlet("/DownloadStaffInterviewCheckCsvServlet")
public class DownloadStaffInterviewCheckCsvServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // セッション等から表示中のデータを取得（csiListがセッションにある前提）
        HttpSession session = request.getSession();
        List<StaffInterviewCheckList> sivcList_List = (List<StaffInterviewCheckList>) session.getAttribute("sivcList_List");
        // セッション等から表示中のデータを取得（csiListがセッションにある前提）
        HttpSession session2 = request.getSession();
        StaffInterviewCheck sivcInfo2 = (StaffInterviewCheck) session2.getAttribute("sivcInfo2");
        
        if (sivcList_List == null) {
            response.sendRedirect("StaffMenuServlet");
            return;
        }

        // ファイル名とコンテンツタイプの設定
        String fileName = "staff_interview_check_list.csv";
        response.setContentType("text/csv; charset=Shift_JIS"); // Excel対応のためShift_JIS
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try (PrintWriter pw = response.getWriter()) {
            // ヘッダー（項目名）の書き込み
            pw.println("利用者様の面談記録リスト");
            pw.println("氏名," + sivcInfo2.getStaffInterviewCheck_name_sei() + " " + sivcInfo2.getStaffInterviewCheck_name_mei());
            pw.println("面談年月日　,面談職員　,面談の記録　");

            // データの書き込み（拡張for文で1件ずつ処理）
            for (StaffInterviewCheckList sivcList : sivcList_List) {
                // 面談記録を取得
                String record = sivcList.getInterview_record();
                
                if (record != null) {
                    // \r\n（Windows）、\n（Unix）、\r（旧Mac）のすべての改行コードを空文字またはスペースに置換
                    record = record.replace("\r\n", " ").replace("\n", " ").replace("\r", " ");
                } else {
                    record = "";
                }

                // カンマ区切りで出力
                pw.println(sivcList.getInterview_day() + "," 
                         + sivcList.getStaff_name_sei() + " " + sivcList.getStaff_name_mei() + "," 
                         + record);
            }
            
            pw.flush();
        }
    }
}