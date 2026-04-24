<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // セッションからデータ（account3）を取得
    if (session.getAttribute("staffaccount3") == null) {
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
<form action="StaffInterviewServlet" method="post">
情報を入力する利用者様の氏名（漢字）　(姓):<input type="text" name="client_name_sei">　　(名):<input type="text" name="client_name_mei"><br>
利用を開始した年月日（全て半角でoooo/oo/oo）:<input type="date" name="admission_day"><br>
利用を終了した年月日（全て半角でoooo/oo/oo）[利用終了した人以外は空欄のまま]:<input type="date" name="leaving_day"><br>
<br>
★就職先情報（こちらも就職先が決まるまでは空欄のまま）
企業名　:<input type="text" name="company"><br>
職種　:<input type="text" name="occupation"><br>
雇用形態　:<input type="text" name="employ_type"><br>
所定労働時間　:<input type="text" name="working_hours"><br>
勤務開始日（全て半角でoooo/oo/oo）:<input type="date" name="join_day"><br>
内定の有無　:<input type="text" name="offer"><br>
在職中／退職　:<select name="employed">
        <option value=""></option>
        <option value="在職中">男</option>
        <option value="退職">女</option>
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

