<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %> <%-- 追加 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ジョブリッジ</title>
</head>
<body>
<c:if test="${not empty errorMsg }">
<p> <c:out value="${errorMsg }"/> </p>
    <br>

<a href="AdminStaffResisterServlet">職員の登録画面へ</a>
</c:if>
<%-- エラーがない場合のみ表示 --%>
<c:if test="${empty errorMsg}">
<h1>追加登録する職員の確認</h1>
	<p> 職員のログイン名：<c:out value="${AdminStaffResister.admin_staff_login_name}" /> </p>
    <p> 職員の氏名：<c:out value="${AdminStaffResister.admin_staff_name_sei}" /> 　<c:out value="${AdminStaffResister.admin_staff_name_mei}" /></p>
    <p> 職員の氏名（ふりがな）：<c:out value="${AdminStaffResister.admin_staff_name_sei_kana}" /> 　<c:out value="${AdminStaffResister.admin_staff_name_mei_kana}" /></p>
    <p> 権限：<c:out value="${AdminStaffResister.staff_authority}" /> </p>
    <br>
    <a href="StaffMenuServlet">職員用メニューへ</a><br>
    <a href="LogoutServlet">ログアウト</a>
</c:if>
<script>
window.onpageshow = function(event) {
    if (event.persisted) {
        window.location.reload(); // キャッシュから復元された場合に強制リロード
    }
};
</script>
</body>
</html>

