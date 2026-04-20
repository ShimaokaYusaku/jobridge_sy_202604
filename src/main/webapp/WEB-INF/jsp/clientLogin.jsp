<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ジョブリッジ</title>
</head>
<body>
<h1>利用者様用ログイン</h1>
<form action="ClientLoginServlet" method="post">
ユーザー名:<input type="text" name="client_login_name" value="" autocomplete="off"><br>
パスワード:<input type="password" name="client_pass"><br>
<input type="submit" value="ログイン">
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