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
<a href="ClientPassChangeServlet">利用者様のパスワード変更の画面へ</a>
</c:if>
<%-- エラーがない場合のみ表示 --%>
<c:if test="${empty errorMsg}">
<h1>利用者様のパスワード変更の確認</h1>

        <%-- ★修正箇所：本日日付を表示 --%>
    <p> パスワードは正しく変更されました。
    <br>
    
    <a href="ClientMenuServlet">利用者様用メニューへ</a><br>
    <a href="LogoutServlet">ログアウト</a>
</c:if>

</body>
</html>