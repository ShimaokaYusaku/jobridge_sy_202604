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

import model.ClientDisabilityList;

/**
 * Servlet implementation class DownloadClientDisabilityListCsvServlet
 */
@WebServlet("/DownloadClientDisabilityListCsvServlet")
public class DownloadClientDisabilityListCsvServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // セッション等から表示中のデータを取得（csiListがセッションにある前提）
        HttpSession session = request.getSession();
        List<ClientDisabilityList> cdList_List = (List<ClientDisabilityList>) session.getAttribute("cdList_List");
        
        if (cdList_List == null) {
            response.sendRedirect("ClientDisabilityListServlet");
            return;
        }

        // ファイル名とコンテンツタイプの設定
        String fileName = "client_disability_list.csv";
        response.setContentType("text/csv; charset=Shift_JIS"); // Excel対応のためShift_JIS
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try (PrintWriter pw = response.getWriter()) {
            // ヘッダー（項目名）の書き込み
            pw.println("登録された利用者様の障がい関係のリスト");
            pw.println("利用者様氏名,障がい名,受給者証有効期限,手帳の種別,手帳の等級");

            // データの書き込み（拡張for文で1件ずつ処理）
            for (ClientDisabilityList cdList : cdList_List) {
                // ゲッターを使用して中身を取得し、カンマで区切って書き込む
            	pw.println(cdList.getClient_name_sei() + " " + cdList.getClient_name_mei() + "," + cdList.getDisability() + "," + cdList.getExpiration_day() + "," + cdList.getDisability_type() + "," + cdList.getDisability_grade());
            }
            
            pw.flush();
        }
    }
}