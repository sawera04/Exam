<%@page contentType="text/html; charset=UTF-8" %>

<%-- カレントディレクトリはJSPのフォルダ(URL)になる --%>
<%@include file="../header.html" %>

<form action="total-out.jsp" method="post">

<!-- プログラム側ではnameの値を使って参照 -->
<input type="text" name="price"> 円X
<input type="text" name="count"> 個=
<input type="submit" value="計算">
</form>

<%@include file="../footer.html" %>
