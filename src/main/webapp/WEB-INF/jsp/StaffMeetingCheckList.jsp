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

<a href="StaffMeetingCheckServlet">担当者会議の記録を確認したい職員の氏名入力画面へ</a>
</c:if>
<%-- エラーがない場合のみ表示 --%>
<c:if test="${empty errorMsg}">
<h1>職員の担当者会議の記録情報</h1>
    <!-- ボタンの追加箇所 -->
	<form action="DownloadStaffMeetingCheckCsvServlet" method="post" style="display:inline;">
    <!-- サーブレットにデータを渡すため、必要な値を隠しフィールドで送るか、セッションから取得するようにします -->
    <input type="submit" value="全ての担当者会議の記録をCSV形式で保存する">
	</form>	

	<p>
	●担当者会議の記録<br>
	担当者会議の内容を確認したい職員の氏名：　<c:out value="${smtcInfo2.staffMeetingCheck_name_sei}" /> 　<c:out value="${smtcInfo2.staffMeetingCheck_name_mei}" /><br>
	</p>
	会議年月日 / 参加職員１/ 参加職員２/ 参加職員３ / 担当者会議の記録
    <table>
        <c:forEach var="smtcList" items="${smtcList_List}">
            <tr>
                <td><c:out value="${smtcList.meeting_day}"/> / </td>
                <td><c:out value="${smtcList.staff2_name_sei}"/> <c:out value="${smtcList.staff2_name_mei}"/> / </td>
                <td><c:out value="${smtcList.staff3_name_sei}"/> <c:out value="${smtcList.staff3_name_mei}"/> / </td>               
                <td><c:out value="${smtcList.staff4_name_sei}"/> <c:out value="${smtcList.staff4_name_mei}"/> / </td>               
                <td><c:out value="${smtcList.meeting_record}"/> </td>
            </tr>
        </c:forEach>
    </table>

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