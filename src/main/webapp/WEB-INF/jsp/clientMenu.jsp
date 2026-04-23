<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<%
// --- 【追加】キャッシュを無効化する設定 ---
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
// ---------------------------------------
    // セッションからデータ（account3）を取得
    if (session.getAttribute("account3") == null) {
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
<h1>利用者様メニュー</h1>
	<p>
	 利用者様氏名：${account3.name_sei} ${account3.name_mei}
	</p>
	<p>
		<a href="ClientDailyInputServlet">日々の記録<br></a>
	</p>
	<p>
		<a href="ClientCertificationUpdateServlet">受給者証有効期限の更新<br></a>
	</p>
	<p>
		<a href="ClientPassChangeServlet">パスワードの変更<br></a>
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