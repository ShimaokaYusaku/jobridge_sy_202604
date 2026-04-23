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

<a href="StaffinterviewServlet">面談記録の登録画面へ</a>
</c:if>
<%-- エラーがない場合のみ表示 --%>
<c:if test="${empty errorMsg}">
<h1>追加登録する面談記録の確認</h1>
    <p> 面接した職員の氏名：<c:out value="${staffaccount3.staff_name_sei}" /> 　<c:out value="${staffaccount3.staff_name_mei}" /></p>
    <p> 面接した利用者様の氏名：<c:out value="${StaffInterview.client_name_sei}" /> 　<c:out value="${StaffInterview.client_name_mei}" /></p>
    <p> 面接した年月日： <c:out value="${formattedDate}" /> </p>
    <p> 面接内容：<c:out value="${StaffInterview.interview_record}" /> </p>
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
