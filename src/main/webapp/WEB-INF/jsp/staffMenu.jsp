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
        response.sendRedirect("loginmenu.html");
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
	★登録情報の閲覧、およびデータ取得、印刷など<br>
	　・利用者様情報<br>
	　・利用者様一覧（氏名のみ）<br>
	　・利用者様の勤怠管理情報<br>
	　・日ごとの出席者一覧<br>
	　・利用者様の利用開始／終了および就職先情報<br>
	　・就職先情報一覧<br>
	　・就職までにかかった期間（通所期間）一覧<br>
	　・障がい者受給者票の更新状況<br>
	　・障がい者手帳、種別、等級一覧<br>
	　・最寄駅、経路（一部）、交通費一覧<br>
	　・面談記録<br>
	　・担当者会議記録<br>
	<br>
	★新規追加、および登録情報の修正、更新など<br>
	　・利用者様情報<br>
	　・利用者様の勤怠管理情報<br>
	　・利用者様の利用開始／終了および就職先情報<br>
	　・障がい者受給者票の更新状況<br>
	　・面談記録<br>
	　・担当者会議記録<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
		パスワードの変更<br>
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