<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %> <%-- 追加 --%>
<%
    // セッションからデータ（account3）を取得
    if (session.getAttribute("supportaccount12") == null) {
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
	利用者様氏名：${supportaccount12.name_sei} ${supportaccount12.name_mei}<br>
	利用を開始した年月日：${supportaccount12.admissionday}<br>
	（※上記項目は変更できません）
	</p>
	<form action="StaffClientSupportDataUpdateServlet" method="post">
	利用を終了した年月日（全て半角でoooo/oo/oo）：<input type="text" name="leaving_day" value="${supportaccount12.leavingday}"><br>
	（※利用終了していない方は空欄まま）<br>
	<p>
	企業名:<input type="text" name="company" value="${supportaccount12.company}"><br>
	職種:<input type="text" name="occupation" value="${supportaccount12.occupation}"><br>
	雇用形態:<input type="text" name="employ_type" value="${supportaccount12.employ_type}"><br>
	所定労働時間:<input type="text" name="working_hours" value="${supportaccount12.working_hours}"><br>
	勤務開始年月日:<input type="text" name="join_day" value="${supportaccount12.joinday}"><br>
	内定の有無:<input type="text" name="offer" value="${supportaccount12.offer}"><br>
	在職中／退職:<input type="text" name="employed" value="${supportaccount12.employed}"><br>
	備考 [最大300文字程度]:<input type="text" name="support_note" value="${supportaccount12.support_note}"><br>
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