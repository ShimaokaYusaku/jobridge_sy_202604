<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
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
<h1>職員のパスワード変更登録</h1>
	<p>
	 職員の氏名：${staffaccount3.staff_name_sei} ${staffaccount3.staff_name_mei}<br>
	</p>

<form action="StaffPassChangeServlet" method="post">
新しい パスワード[半角英数両方を用いて 8 ～ 20文字]　　　　　:<input type="password" name="staff_pass_next" pattern="^[a-zA-Z0-9]{8,20}$" minlength="8" maxlength="20" required><br>
新しい パスワード[半角英数両方を用いて 8 ～ 20文字]（再入力）:<input type="password" name="staff_pass_next_again"><br>
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