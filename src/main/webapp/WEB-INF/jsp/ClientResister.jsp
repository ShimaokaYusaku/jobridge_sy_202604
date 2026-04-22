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
<form action="ClientResisterServlet" method="post">
利用者様のログイン名:<input type="text" name="client_login_name"><br>
利用者様の氏名（漢字）　(姓):<input type="text" name="client_name_sei">　　(名):<input type="text" name="client_name_mei"><br>
利用者様の氏名(ふりがな)(姓):<input type="text" name="client_name_sei_kana">　　(名):<input type="text" name="client_name_mei_kana"><br>
<br>
誕生年月日:（全て半角でoooo/oo/oo）:<input type="date" name="birthday"><br>
性別:<select name="gender">
        <option value="男">男</option>
        <option value="女">女</option>
        <option value="不明">不明</option>
        <option value="－－">－－</option>
    </select><br>
住所:<input type="text" name="address"><br>
記入例：大阪府大阪市北区〇〇〇１-１-１２-３１０
電話番号(ハイフォン付きで (例) 090-oooo-oooo):<input type="text" name="phone"><br>
<br>

●緊急連絡先関係<br>
氏名:<input type="text" name="emergency_name"><br>
続柄:<input type="text" name="emergency_rel"><br>
電話番号(ハイフォン付きで (例) 090-oooo-oooo):<input type="text" name="emergency_phone"><br>
<br>
●障がい関係<br>
障がい名:<input type="text" name="disability"><br>
受給者証有効期限:（全て半角でoooo/oo/oo）:<input type="date" name="expiration_start"><br>
通院先病院名:<input type="text" name="hospital"><br>
主治医名:<input type="text" name="doctor"><br>
<br>
※障がい手帳が有る場合は下記も記載（ない場合は空欄のままでＯＫ）<br>
種別:<input type="text" name="disability_type"><br>
等級:<input type="text" name="disability_grade"><br>
<br>
●通所関係<br>
最寄駅:<input type="text" name="station"><br>
交通費:<input type="number" name="expenses"> 円 <br>
事業所までの経路 [最大300文字程度]:<br>
記入例：　徒歩１０分 --- 京阪バス（三井団地 - 寝屋川市） --- 京阪電車（寝屋川市 - 京橋） --- ＪＲ（京橋 - 北新地） --- 徒歩１０分<br>
<textarea name="route" style="width: 70%; height: 100px; vertical-align: top;"></textarea><br>
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

