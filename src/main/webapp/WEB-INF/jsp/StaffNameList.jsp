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

    <a href="StaffMenuServlet">職員用メニューへ</a><br>
</c:if>
<%-- エラーがない場合のみ表示 --%>
<c:if test="${empty errorMsg}">
<h1>登録されている職員の氏名リスト</h1>
    <!-- ボタンの追加箇所 -->
	<form action="DownloadStaffNameListCsvServlet" method="post" style="display:inline;">
    <!-- サーブレットにデータを渡すため、必要な値を隠しフィールドで送るか、セッションから取得するようにします -->
    <input type="submit" value="CSV形式で保存する">
	</form>	

	<br>
	<p>
	●職員の氏名<br>
	<c:forEach var="snList" items="${snList_List}">
	<c:out value="${snList.staff_name_sei}" />　<c:out value="${snList.staff_name_mei}" /><br>
	</c:forEach>
	</p>
    <br>
    
    <a href="StaffMenuServlet">職員用メニューへ</a><br>
    <a href="LogoutServlet">ログアウト</a>
</c:if>

</body>
</html>