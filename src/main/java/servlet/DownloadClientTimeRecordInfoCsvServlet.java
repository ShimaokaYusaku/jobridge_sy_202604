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

import model.ClientTimeRecordInfo;
import model.ClientTimeRecordInfoList;

/**
 * Servlet implementation class DownloadClientTimeRecordInfoCsvServlet
 */
@WebServlet("/DownloadClientTimeRecordInfoCsvServlet")
public class DownloadClientTimeRecordInfoCsvServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // セッション等から表示中のデータを取得（csiListがセッションにある前提）
        HttpSession session = request.getSession();
        List<ClientTimeRecordInfoList> ctriList_List = (List<ClientTimeRecordInfoList>) session.getAttribute("ctriList_List");
        // セッション等から表示中のデータを取得（csiListがセッションにある前提）
        HttpSession session2 = request.getSession();
        ClientTimeRecordInfo ctrInfo2 = (ClientTimeRecordInfo) session2.getAttribute("ctrInfo2");
        
        if (ctriList_List == null) {
            response.sendRedirect("StaffMenuServlet");
            return;
        }

        // ファイル名とコンテンツタイプの設定
        String fileName = "client_time_record_list.csv";
        response.setContentType("text/csv; charset=Shift_JIS"); // Excel対応のためShift_JIS
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try (PrintWriter pw = response.getWriter()) {
            // ヘッダー（項目名）の書き込み
            pw.println("利用者様の勤怠リスト（直近の最大100日分まで）");
            pw.println("氏名," + ctrInfo2.getTimeRecordInfo_name_sei() + " " + ctrInfo2.getTimeRecordInfo_name_mei());
            pw.println("勤務日　　　,開始時間　,終了時間　");
            int i=0;
            // データの書き込み（拡張for文で1件ずつ処理）
            for (ClientTimeRecordInfoList ctriList : ctriList_List) {
                // iが100を超えたらループを抜ける
                if (i > 100) {
                    break;
                }
                // ゲッターを使用して中身を取得し、カンマで区切って書き込む
            	i++;
            	pw.println(ctriList.getWork_day()  + "," + ctriList.getStart_time() + "," + ctriList.getEnd_time());
            }
            
            pw.flush();
        }
    }
}