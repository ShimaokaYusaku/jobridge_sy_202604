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
<h1>登録されている利用者様の障がい関係の情報リスト</h1>
    <!-- ボタンの追加箇所 -->
	<form action="DownloadClientDisabilityListCsvServlet" method="post" style="display:inline;">
    <!-- サーブレットにデータを渡すため、必要な値を隠しフィールドで送るか、セッションから取得するようにします -->
    <input type="submit" value="CSV形式で保存する">
	</form>	

	<br>
	<p>
	●利用者様の障がい関係の情報<br>
	<c:forEach var="cdList" items="${cdList_List}">
	<p>
	利用者様の氏名:<c:out value="${cdList.client_name_sei}" />　<c:out value="${cdList.client_name_mei}" /><br>
	障がい名:<c:out value="${cdList.client_name_sei}" /><br>
	受給者証有効期限:<c:out value="${cdList.client_name_sei}" /><br>
	※障がい者手帳を所有している方<br>
	種別:<c:out value="${cdList.client_name_sei}" /><br>
	等級:<c:out value="${cdList.client_name_sei}" /><br>
	</p>
	</c:forEach>
	</p>
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