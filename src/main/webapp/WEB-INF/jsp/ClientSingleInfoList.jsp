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

<a href="ClientSingleInfoServlet">表示させたい利用者様の氏名入力画面へ</a>
</c:if>
<%-- エラーがない場合のみ表示 --%>
<c:if test="${empty errorMsg}">
<h1>登録されている利用者様情報</h1>
    <!-- ボタンの追加箇所 -->
	<form action="DownloadCsvServlet" method="post" style="display:inline;">
    <!-- サーブレットにデータを渡すため、必要な値を隠しフィールドで送るか、セッションから取得するようにします -->
    <input type="submit" value="CSV形式で保存する">
	</form>	

	<br>
	<p>
	●利用者様情報<br>
	利用者様のログイン名：　<c:out value="${csiList.client_login_name}" /><br>
    利用者様の氏名：　<c:out value="${csiList.client_name_sei}" /> 　<c:out value="${csiList.client_name_mei}" /><br>
    利用者様の氏名（ふりがな）：　<c:out value="${csiList.client_name_sei_kana}" /> 　<c:out value="${csiList.client_name_mei_kana}" /><br>
	</p>
	<%-- 1. まず現在の形式（yyyy-MM-dd）で文字列を日付オブジェクトに変換 --%>
	<fmt:parseDate value="${csiList.birthday}" var="parsedBirthday" pattern="yyyy-MM-dd" />
	<%-- 2. 変換した日付オブジェクトを日本語形式（yyyy年M月d日）で表示 --%>
	<p>
	誕生年月日: 　<fmt:formatDate value="${parsedBirthday}" pattern="yyyy年M月d日" /><br>
	性別:　<c:out value="${csiList.gender}" /><br>
	住所:　<c:out value="${csiList.address}" /><br>
	電話番号:　<c:out value="${csiList.phone}" /><br>
	</p>
	<p>
	●緊急連絡先関係<br>
	氏名:　<c:out value="${csiList.emergency_name}" /><br>
	続柄:　<c:out value="${csiList.emergency_rel}" /><br>
	電話番号:　<c:out value="${csiList.emergency_phone}" /><br>
	<p>
	●障がい関係<br>
	障がい名:　<c:out value="${csiList.disability}" /><br>
		<%-- 1. まず現在の形式（yyyy-MM-dd）で文字列を日付オブジェクトに変換 --%>
	<fmt:parseDate value="${csiList.expiration_start}" var="parsedexpiration_start" pattern="yyyy-MM-dd" />
	<%-- 2. 変換した日付オブジェクトを日本語形式（yyyy年M月d日）で表示 --%>
	受給者証有効期限: 　<fmt:formatDate value="${parsedexpiration_start}" pattern="yyyy年M月d日" /><br>
	通院先病院名:　<c:out value="${csiList.hospital}" /><br>
	主治医名:　<c:out value="${csiList.doctor}" /><br>
	</p>
	<p>
	※障がい手帳が有る場合は下記も記載（ない場合は空欄）<br>
	種別:　<c:out value="${csiList.disability_type}" /><br>
	等級:　<c:out value="${csiList.disability_grade}" /><br>
	</p>
	<p>
	●通所関係<br>
	最寄駅:　<c:out value="${csiList.station}" /><br>
	交通費:　<c:out value="${csiList.expenses}" /> 円 <br>
	事業所までの経路 [最大300文字程度]:　<br>
	<c:out value="${csiList.route}" />
	</p>
    <br>
    
    <a href="StaffMenuServlet">職員用メニューへ</a><br>
    <a href="LogoutServlet">ログアウト</a>
</c:if>

</body>
</html>