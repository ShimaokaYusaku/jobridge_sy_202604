<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %> <%-- 追加 --%>
    <%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

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

<a href="StaffInterviewCheckServlet">面談記録を確認したい利用者様の氏名入力画面へ</a>
</c:if>
<%-- エラーがない場合のみ表示 --%>
<c:if test="${empty errorMsg}">
<h1>利用者様の面談記録情報</h1>
    <!-- ボタンの追加箇所 -->
	<form action="DownloadStaffInterviewCheckCsvServlet" method="post" style="display:inline;">
    <!-- サーブレットにデータを渡すため、必要な値を隠しフィールドで送るか、セッションから取得するようにします -->
    <input type="submit" value="全ての面談記録をCSV形式で保存する">
	</form>	

	<p>
	●利用者様の面談記録<br>
	利用者様の氏名：　<c:out value="${sivCheck2.staffInterview_name_sei}" /> 　<c:out value="${sivCheck2.staffInterview_name_mei}" /><br>
	</p>
	
<section>
    <table>
        <c:forEach var="item" items="${monthlyMap[currentMonth]}">
            <tr>
                <td><c:out value="${item.work_day}"/> / </td>
                <td><c:out value="${item.start_time}"/> 〜 <c:out value="${item.end_time}"/></td>
            </tr>
        </c:forEach>
    </table>
</section>

<hr>
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
