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

<a href="ClientTimeRecordInfoServlet">勤怠を確認したい利用者様の氏名入力画面へ</a>
</c:if>
<%-- エラーがない場合のみ表示 --%>
<c:if test="${empty errorMsg}">
<h1>利用者様の勤怠情報</h1>
    <!-- ボタンの追加箇所 -->
	<form action="DownloadClientTimeRecordInfoCsvServlet" method="post" style="display:inline;">
    <!-- サーブレットにデータを渡すため、必要な値を隠しフィールドで送るか、セッションから取得するようにします -->
    <input type="submit" value="直近100日分の勤務日・開始時間・終了時間をCSV形式で保存する">
	</form>	

	<p>
	●利用者様の勤怠情報<br>
	利用者様の氏名：　<c:out value="${ctrInfo2.timeRecordInfo_name_sei}" /> 　<c:out value="${ctrInfo2.timeRecordInfo_name_mei}" /><br>
	</p>
	
    <%-- 追加：集計情報の表示 --%>
<%-- 当月（4月）の集計 --%>
<section>
    <h2><c:out value="${currentMonth}"/>月の集計</h2>
    <p>
        出席日数：<c:out value="${fn:length(monthlyMap[currentMonth])}"/> 日 / 
        合計時間：
	<fmt:formatNumber value="${monthlyTotalMinutes[currentMonth] / 60}" maxFractionDigits="0" groupingUsed="false" />時間<c:out value="${monthlyTotalMinutes[currentMonth] % 60}"/>分
    </p>
    ●当月の詳細データ
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

<%-- 前月（3月）の集計 --%>
<section>
    <h2><c:out value="${lastMonth}"/>月の集計</h2>
    <c:choose>
        <c:when test="${empty monthlyMap[lastMonth]}">
            <p>前月のデータはありません。</p>
        </c:when>
        <c:otherwise>
            <p>
                出席日数：<c:out value="${fn:length(monthlyMap[lastMonth])}"/> 日 / 
                <fmt:formatNumber value="${monthlyTotalMinutes[lastMonth] / 60}" maxFractionDigits="0" groupingUsed="false" />時間<c:out value="${monthlyTotalMinutes[lastMonth] % 60}"/>分
            </p>
                ●当月の詳細データ
   		<table>
        <c:forEach var="item" items="${monthlyMap[lastMonth]}">
            <tr>
                <td><c:out value="${item.work_day}"/> / </td>
                <td><c:out value="${item.start_time}"/> 〜 <c:out value="${item.end_time}"/></td>
            </tr>
        </c:forEach>
        </table>
        </c:otherwise>
    </c:choose>
</section>


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