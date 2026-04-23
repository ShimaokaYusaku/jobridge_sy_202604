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
<!--    <p> ユーザーID：<c:out value="${resisterUser.userId}" /> </p>-->
<!--    <p> メールアドレス：<c:out value="${resisterUser.email}" /> </p>-->
<!--    <p> 氏名：<c:out value="${resisterUser.name}" /> </p>-->
<!--    <p> 年齢：<c:out value="${resisterUser.age}" /> </p>-->
<a href="ClientDailyInputServlet">ユーザー登録画面へ</a>
</c:if>
<%-- エラーがない場合のみ表示 --%>
<c:if test="${empty errorMsg}">
<h1>利用者様の勤怠記録内容の確認</h1>
<!--    <p> 利用者番号：<c:out value="${account3.client_Id}" /> </p>-->
    <p> 利用者様氏名：<c:out value="${account3.name_sei}" /> 　<c:out value="${account3.name_mei}" /></p>

        <%-- ★修正箇所：本日日付を表示 --%>
    <p> 作業日：
        <jsp:useBean id="now" class="java.util.Date" />
        <fmt:formatDate value="${now}" pattern="yyyy年MM月dd日" />
    </p>

    <p> 入室時間：<c:out value="${clientdaily.start_time}" /> </p>
    <p> 退室時間：<c:out value="${clientdaily.end_time}" /> </p>
    <p> 体調：<c:out value="${clientdaily.condition}" /> </p>
    <p> カリキュラム記録：<c:out value="${clientdaily.work_record}" /> </p>
    <p> 所感：<c:out value="${clientdaily.impression}" /> </p>
    <br>
    <a href="ClientMenuServlet">利用者様用メニューへ</a><br>
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



