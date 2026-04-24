<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
<h1>担当者会議記録の確認</h1>
<form action="StaffMeetingCheckServlet" method="post">
	担当者会議記入者の氏名：　<c:out value="${staffaccount3.staff_name_sei}" /> 　<c:out value="${staffaccount3.staff_name_mei}" /><br>

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