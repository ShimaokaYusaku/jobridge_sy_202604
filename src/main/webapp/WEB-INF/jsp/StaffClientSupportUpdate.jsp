<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %> <%-- 追加 --%>
<%
    // セッションからデータ（account3）を取得
    if (session.getAttribute("supportaccount4") == null) {
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

<c:if test="${empty errorMsg}">
<h1>更新したい利用終了の年月日および就職先情報の入力</h1>
	<p>
	利用者様氏名：${supportaccount4.name_sei} ${supportaccount4.name_mei}<br>
	利用を開始した年月日：${supportaccount4.admissionday}<br>
	</p>
	<form action="StaffClientSupportUpdateServlet" method="post">
	利用を終了した年月日（全て半角でoooo/oo/oo）：<input type="text" name="company" value="${StaffClientSupportInput.leavingday}"><br>
	（※利用終了していない方は空欄まま）<br>
	<p>
	企業名:<input type="text" name="company" value="${StaffClientSupportInput.company}"><br>
	職種:<input type="text" name="company" value="${StaffClientSupportInput.occupation}"><br>
	雇用形態:<input type="text" name="company" value="${StaffClientSupportInput.employ_type}"><br>
	所定労働時間:<input type="text" name="company" value="${StaffClientSupportInput.working_hours}"><br>
	勤務開始年月日:<input type="text" name="company" value="${StaffClientSupportInput.joinday}"><br>
	内定の有無:<input type="text" name="company" value="${StaffClientSupportInput.offer}"><br>
	在職中／退職:<input type="text" name="company" value="${StaffClientSupportInput.employed}"><br>
	備考 [最大300文字程度]:<input type="text" name="company" value="${StaffClientSupportInput.support_note}"><br>
    <br>
    <input type="submit" value="更新する">
	</form>
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