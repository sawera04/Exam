<%@page contentType="text/html; charset=UTF-8" %>

<%-- カレントディレクトリはJSPのフォルダ(URL)になる --%>
<%@include file="../header.html" %>

<p>お名前を入力してください。</p>
<!-- フォームを使って値を入力させる -->
<!-- action:submit(ボタンを押下)された時の実行されるプログラム -->
<!-- mrthod:リクエストの方法　post/get -->
<form action="greeting-out.jsp" method="post">

<!-- プログラム側ではnameの値を使って参照 -->
<input type="text" name="user">
<input type="submit" value="確定">
</form>

<%@include file="../footer.html" %>
