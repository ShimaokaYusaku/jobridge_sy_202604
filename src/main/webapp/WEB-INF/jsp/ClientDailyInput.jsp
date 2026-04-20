<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // セッションからデータ（account3）を取得
    if (session.getAttribute("account3") == null) {
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
<h1>利用者様の勤怠記録</h1>
<form action="ClientDailyInputServlet" method="post">
入室時間:<input type="time" name="start_time"><br>
退室時間:<input type="time" name="end_time"><br>
本日の体調:<input type="text" name="condition"><br>
カリキュラム記録:<input type="text" name="work_record"><br>
所感[300文字程度]:<input type="text" name="impression"><br>
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



