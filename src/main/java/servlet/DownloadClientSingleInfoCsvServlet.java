package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.ClientSingleInfoList;

/**
 * Servlet implementation class DownloadCsvServlet
 */
@WebServlet("/DownloadClientSingleInfoCsvServlet")
public class DownloadClientSingleInfoCsvServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // セッション等から表示中のデータを取得（csiListがセッションにある前提）
        HttpSession session = request.getSession();
        ClientSingleInfoList csiList = (ClientSingleInfoList) session.getAttribute("csiList");

        if (csiList == null) {
            response.sendRedirect("ClientSingleInfoServlet");
            return;
        }

        // ファイル名とコンテンツタイプの設定
        String fileName = "client_info.csv";
        response.setContentType("text/csv; charset=Shift_JIS"); // Excel対応のためShift_JIS
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try (PrintWriter pw = response.getWriter()) {
            // ヘッダー（項目名）の書き込み
            pw.println("利用者様情報（個人別）");
            pw.println("項目,内容");
            
            // データの書き込み（カンマ区切り）
            pw.println("氏名," + csiList.getClient_name_sei() + " " + csiList.getClient_name_mei());
            pw.println("氏名（かな）," + csiList.getClient_name_sei_kana() + " " + csiList.getClient_name_mei_kana());
            pw.println("誕生日," + csiList.getBirthday());
            pw.println("性別," + csiList.getGender());
            pw.println("住所," + csiList.getAddress());
            pw.println("電話番号," + csiList.getPhone());
            pw.println("利用を開始した年月日," + csiList.getAdmissionday());
            pw.println("緊急連絡先 氏名," + csiList.getEmergency_name());
            pw.println("緊急連絡先 続柄," + csiList.getEmergency_rel());
            pw.println("緊急連絡先 電話番号," + csiList.getEmergency_phone());
            pw.println("障がい名," + csiList.getDisability());
            pw.println("受給者証有効期限," + csiList.getExpiration_start());
            pw.println("病院名," + csiList.getHospital());
            pw.println("主治医," + csiList.getDoctor());
            pw.println("手帳種別," + csiList.getDisability_type());
            pw.println("等級," + csiList.getDisability_grade());
            pw.println("最寄駅," + csiList.getStation());
            pw.println("交通費," + csiList.getExpenses());
            // 改行が含まれる可能性がある項目は引用符で囲む
            pw.println("経路,\"" + csiList.getRoute().replace("\"", "\"\"") + "\"");
            
            pw.flush();
        }
    }
}