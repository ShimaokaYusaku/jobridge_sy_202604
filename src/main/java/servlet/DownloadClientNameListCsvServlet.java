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

import model.ClientNameList;

/**
 * Servlet implementation class DownloadClientNameListCsvServlet
 */
@WebServlet("/DownloadClientNameListCsvServlet")
public class DownloadClientNameListCsvServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // セッション等から表示中のデータを取得（csiListがセッションにある前提）
        HttpSession session = request.getSession();
        List<ClientNameList> cnList_List = (List<ClientNameList>) session.getAttribute("cnList_List");
        
        if (cnList_List == null) {
            response.sendRedirect("StaffMenuServlet");
            return;
        }

        // ファイル名とコンテンツタイプの設定
        String fileName = "client_name_list.csv";
        response.setContentType("text/csv; charset=Shift_JIS"); // Excel対応のためShift_JIS
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try (PrintWriter pw = response.getWriter()) {
            // ヘッダー（項目名）の書き込み
            pw.println("氏名（姓）・（名）");
            
            // データの書き込み（カンマ区切り）
            pw.println(cnList_List);
            
            pw.flush();
        }
    }
}