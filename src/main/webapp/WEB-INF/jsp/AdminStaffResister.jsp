<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // セッションからデータ（account3）を取得
    if (session.getAttribute("staffaccount3") == null) {
        // ログインしていない場合はログイン画面へ強制送還
        response.sendRedirect("loginmenu.html");
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
<h1>追加登録する職員情報の入力</h1>
<form action="AdminStaffResisterServlet" method="post">
職員のログイン名:<input type="text" name="admin_staff_login_name"><br>
職員の氏名（漢字）　(姓):<input type="text" name="admin_staff_name_sei">　　(名):<input type="text" name="admin_staff_name_mei"><br>
職員の氏名(ふりがな)(姓):<input type="text" name="admin_staff_name_sei_kana">　　(名):<input type="text" name="admin_staff_name_mei_kana"><br>
権限:<select name="staff_authority">
        <option value="staff">staff</option>
        <option value="Admin">Admin</option>
    </select><br>

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

