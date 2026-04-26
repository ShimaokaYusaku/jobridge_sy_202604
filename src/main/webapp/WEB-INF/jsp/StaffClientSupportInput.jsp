<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // セッションからデータ（account3）を取得
    if (session.getAttribute("supportaccount4") == null) {
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
<h1>利用者様の利用開始／終了の年月日および就職先情報の入力</h1>
	<p>
	 利用者様氏名：${supportaccount4.name_sei} ${supportaccount4.name_mei}
	 利用を開始した年月日：${supportaccount4.admissionday}
	</p>
	<form action="StaffClientSupportInputServlet" method="post">
	利用を終了した年月日（全て半角でoooo/oo/oo）:<input type="date" name="leaving_day"><br>
	（※利用終了していない方は空欄まま）<br>
	<br>
	★就職先情報（※不明なものは空欄まま）<br>
	企業名:<input type="text" name="company"><br>
	職種:<input type="text" name="occupation"><br>
	雇用形態:<input type="text" name="employ_type"><br>
	所定労働時間:<input type="number" name="working_hours" step="0.1"><br>
	勤務開始年月日:<input type="date" name="join_day"><br>
	内定の有無:<select name="offer">
        <option value=""></option>
        <option value="内定あり">内定あり</option>
        <option value="内定なし">内定なし</option>
    </select><br>
	在職中／退職:<select name="employed">
        <option value=""></option>
        <option value="在職中">在職中</option>
        <option value="退職">退職</option>
    </select><br>
	備考 [最大300文字程度]:<br>
	<textarea name="support_note" style="width: 70%; height: 100px; vertical-align: top;"></textarea><br>
	<br>
	<input type="submit" value="登録する">
	</form>
<script>
window.onpageshow = function(event) {
    if (event.persisted) {
        window.location.reload(); // キャッシュから復元された場合に強制リロード
    }
};
</script>
</body>
</html>