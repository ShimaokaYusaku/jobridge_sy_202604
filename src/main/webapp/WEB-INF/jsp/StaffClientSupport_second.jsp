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
<h1>利用者様の利用終了の年月日および就職先情報の更新</h1>
<form action="StaffClientSupportUpdateServlet" method="post">
情報を更新する利用者様の氏名（漢字）　(姓):<input type="text" name="staffClientSupport_second_name_sei">　　(名):<input type="text" name="staffClientSupport_second_name_mei"><br>

<input type="submit" value="表示する">
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