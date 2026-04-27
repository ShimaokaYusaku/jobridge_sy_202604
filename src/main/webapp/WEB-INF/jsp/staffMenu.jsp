<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<%
// --- 【追加】キャッシュを無効化する設定 ---
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
// ---------------------------------------
    // セッションからデータ（account3）を取得
    if (session.getAttribute("staffaccount3") == null) {
        // ログインしていない場合はログイン画面へ強制送還
        response.sendRedirect("index.html");
        return; // 以降の処理を中断
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ジョブリッジ</title>
</head>
<body>
<h1>職員用メニュー</h1>
	<p>
	 職員氏名：${staffaccount3.staff_name_sei} ${staffaccount3.staff_name_mei}
	</p>
	<p>
	★登録情報の閲覧、およびcsvデータ取得<br>
	<a href="ClientSingleInfoServlet">・利用者様情報（個別）</a><br>
	<a href="ClientNameListServlet">・利用者様氏名一覧（氏名のみ）</a><br>
	<a href="ClientTimeRecordInfoServlet">・利用者様の勤怠管理情報</a><br>
	<a href="StaffClientSupportCheckServlet">・利用者様の利用開始／終了および就職先情報</a><br>
	<a href="ClientDisabilityListServlet">・障がい者受給者票の更新状況と、障がい者手帳の種別、等級一覧</a><br>
	<a href="StaffInterviewCheckServlet">・面談記録</a><br>
	<a href="StaffMeetingCheckServlet">・担当者会議記録</a><br>
	<br>
	★新規追加<br>
	<a href="ClientResisterServlet">・利用者様の新規追加</a><br>
	<a href="StaffClientSupportServlet">・利用者様の利用開始／終了および就職先情報</a><br>
	<a href="StaffInterviewServlet">・面談記録</a><br>
	<a href="StaffMeetingServlet">・担当者会議記録</a><br>
	<br>
	★情報更新<br>
	<a href="StaffClientSupportUpdateServlet">・利用者様の利用終了および就職先情報の更新</a><br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<a href="StaffPassChangeServlet">パスワードの変更</a><br>
	</p>
	<p>
    <a href="LogoutServlet">ログアウト</a>
	</p>
<!--		<a href="StaffLoginServlet">職員の方はこちら</a>-->
<script>
window.onpageshow = function(event) {
    if (event.persisted) {
        window.location.reload(); // キャッシュから復元された場合に強制リロード
    }
};
</script>
</body>
</html>