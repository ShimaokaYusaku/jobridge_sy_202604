<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
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
<h1>受給者証有効期限の更新登録</h1>
	<p>
	 利用者様氏名：${account3.name_sei} ${account3.name_mei}
	</p>
	<p>
	 前回登録した有効期限：${account3.expiration_start}
	</p>
<form action="ClientCertificationUpdateServlet" method="post">
新しい有効期限（全て半角でoooo/oo/oo）:<input type="date" name="expiration_next"><br>
<input type="submit" value="登録する">
</form>
<script>
window.onpageshow = function(event) {
    if (event.persisted) {
        window.location.reload(); // キャッシュから復元された場合に強制リロード
    }
};
</script>
</body>
</html>