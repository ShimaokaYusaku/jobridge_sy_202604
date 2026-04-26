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

<a href="ClientResisterServlet">利用者様の登録画面へ</a>
</c:if>
<%-- エラーがない場合のみ表示 --%>
<c:if test="${empty errorMsg}">
<h1>追加登録する利用者様の確認</h1>
	<p> 利用者様のログイン名：<c:out value="${ClientResister.client_login_name}" /> </p>
    <p> 利用者様の氏名：<c:out value="${ClientResister.client_name_sei}" /> 　<c:out value="${ClientResister.client_name_mei}" /></p>
    <p> 利用者様の氏名（ふりがな）：<c:out value="${ClientResister.client_name_sei_kana}" /> 　<c:out value="${ClientResister.client_name_mei_kana}" /></p>
	<p></p>
	<p>誕生年月日:<c:out value="${birthday}" /></p>
	<p>性別:<c:out value="${ClientResister.gender}" /></p>
	<p>住所:<c:out value="${ClientResister.address}" /></p>
	<p>電話番号:<c:out value="${ClientResister.phone}" /></p>
	<p></p>
	<p>利用を開始した年月日:<c:out value="${admissionday}" /></p>
	<p></p>
	<p>●緊急連絡先関係</p>
	<p>氏名:<c:out value="${ClientResister.emergency_name}" /></p>
	<p>続柄:<c:out value="${ClientResister.emergency_rel}" /></p>
	<p>電話番号(ハイフォン付きで (例) 090-oooo-oooo):<c:out value="${ClientResister.emergency_phone}" /></p>
	<p></p>
	<p>●障がい関係</p>
	<p>障がい名:<c:out value="${ClientResister.disability}" /></p>
	<p>受給者証有効期限:<c:out value="${expiration_start}" /></p>
	<p>通院先病院名:<c:out value="${ClientResister.hospital}" /></p>
	<p>主治医名:<c:out value="${ClientResister.doctor}" /></p>
	<p></p>
	<p>※障がい手帳が有る場合は下記も記載（ない場合は空欄のままでＯＫ）</p>
	<p>種別:<c:out value="${ClientResister.disability_type}" /></p>
	<p>等級:<c:out value="${ClientResister.disability_grade}" /></p>
	<p></p>
	<p>●通所関係</p>
	<p>最寄駅:<c:out value="${ClientResister.station}" /></p>
	<p>交通費:<c:out value="${ClientResister.expenses}" /> 円 </p>
	<p>事業所までの経路 [最大300文字程度]:</p>
	<p><c:out value="${ClientResister.route}" /></p>
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