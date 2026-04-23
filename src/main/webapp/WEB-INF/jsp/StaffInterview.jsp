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
<h1>追加登録する面談記録の入力</h1>
<form action="StaffInterviewServlet" method="post">
面接した利用者様の氏名（漢字）　(姓):<input type="text" name="client_name_sei">　　(名):<input type="text" name="client_name_mei"><br>
面接した年月日（全て半角でoooo/oo/oo）:<input type="date" name="interview_day"><br>
面接した内容 [最大300文字程度]:<br>
<textarea name="interview_record" style="width: 70%; height: 100px; vertical-align: top;"></textarea><br>
<br>
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

