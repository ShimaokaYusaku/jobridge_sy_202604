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

import model.StaffNameList;

/**
 * Servlet implementation class DownloadStaffNameListCsvServlet
 */
@WebServlet("/DownloadStaffNameListCsvServlet")
public class DownloadStaffNameListCsvServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // セッション等から表示中のデータを取得（csiListがセッションにある前提）
        HttpSession session = request.getSession();
        List<StaffNameList> snList_List = (List<StaffNameList>) session.getAttribute("snList_List");
        
        if (snList_List == null) {
            response.sendRedirect("StaffMenuServlet");
            return;
        }

        // ファイル名とコンテンツタイプの設定
        String fileName = "staff_name_list.csv";
        response.setContentType("text/csv; charset=Shift_JIS"); // Excel対応のためShift_JIS
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try (PrintWriter pw = response.getWriter()) {
            // ヘッダー（項目名）の書き込み
            pw.println("登録されている職員の氏名リスト");
            int i=0;
            // データの書き込み（拡張for文で1件ずつ処理）
            for (StaffNameList snList : snList_List) {
                // ゲッターを使用して中身を取得し、カンマで区切って書き込む
            	i++;
            	pw.println(String.format("%04d", i) + "," + snList.getStaff_name_sei() + " " + snList.getStaff_name_mei());
            }
            
            pw.flush();
        }
    }
}