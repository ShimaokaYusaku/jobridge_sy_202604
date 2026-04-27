package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.StaffClientSupportUpdate;

/**
 * Servlet implementation class DownloadStaffClientSupportCheckCsvServlet
 */
@WebServlet("/DownloadStaffClientSupportCheckCsvServlet")
public class DownloadStaffClientSupportCheckCsvServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	        // セッション等から表示中のデータを取得（StaffClientSupportCheckがセッションにある前提）
	        HttpSession session = request.getSession();
	        StaffClientSupportUpdate StaffClientSupportCheck = (StaffClientSupportUpdate) session.getAttribute("StaffClientSupportCheck");

	        if (StaffClientSupportCheck == null) {
	            response.sendRedirect("StaffClientSupportCheckServlet");
	            return;
	        }

	        // ファイル名とコンテンツタイプの設定
	        String fileName = "client_support_record.csv";
	        response.setContentType("text/csv; charset=Shift_JIS"); // Excel対応のためShift_JIS
	        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

	        try (PrintWriter pw = response.getWriter()) {
	            // ヘッダー（項目名）の書き込み
	            pw.println("利用者様のサポート情報（個人別）");
	            pw.println("項目,内容");
	            
	            // データの書き込み（カンマ区切り）
	            pw.println("氏名," + StaffClientSupportCheck.getName_sei() + " " + StaffClientSupportCheck.getName_mei());
	            pw.println("入所年月日," + StaffClientSupportCheck.getAdmissionday());
	            pw.println("退所年月日," + StaffClientSupportCheck.getLeavingday());
	            pw.println("★就職先情報");
	            pw.println("企業名," + StaffClientSupportCheck.getCompany());
	            pw.println("職種," + StaffClientSupportCheck.getOccupation());
	            pw.println("雇用形態," + StaffClientSupportCheck.getEmploy_type());
	            pw.println("所定労働時間," + StaffClientSupportCheck.getWorking_hours());
	            pw.println("勤務開始年月日," + StaffClientSupportCheck.getJoinday());
	            pw.println("内定の有無," + StaffClientSupportCheck.getOffer());
	            pw.println("所定労働時間," + StaffClientSupportCheck.getEmployed());
	            pw.println("備考," + StaffClientSupportCheck.getSupport_note().replace("\"", "\"\"") + "\"");
	            
	            pw.flush();
	        }
	    }
	}