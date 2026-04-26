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

<a href="StaffClientSupportServlet">利用者様の利用開始／終了の年月日および就職先情報の入力へ</a>
</c:if>
<%-- エラーがない場合のみ表示 --%>
<c:if test="${empty errorMsg}">
<h1>追加登録する利用終了の年月日および就職先情報の確認</h1>
	<p>
	利用者様氏名：${supportaccount4.name_sei} ${supportaccount4.name_mei}<br>
	利用を開始した年月日：${supportaccount4.admissionday}<br>
	利用を終了した年月日：<c:out value="${StaffClientSupportInput.leavingday}" /><br>
	</p>
	<p>
	企業名:<c:out value="${StaffClientSupportInput.company}" /><br>
	職種　:<c:out value="${StaffClientSupportInput.occupation}" /><br>
	雇用形態:<c:out value="${StaffClientSupportInput.employ_type}" /><br>
	所定労働時間:<c:out value="${StaffClientSupportInput.working_hours}" /><br>
	勤務開始年月日:<c:out value="${StaffClientSupportInput.joinday}" /><br>
	内定の有無:<c:out value="${StaffClientSupportInput.offer}" /><br>
	在職中／退職:<c:out value="${StaffClientSupportInput.employed}" /><br>
	備考 [最大300文字程度]:<c:out value="${StaffClientSupportInput.support_note}" /><br>
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