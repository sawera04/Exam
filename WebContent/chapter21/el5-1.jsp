<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<p>カートに追加する商品を入力してください。</p>
<form action="el5-2.jsp" method="post">
<input type="text" name="price">
円x
<input type="text" name="count">
個=
<input type="submit" value="計算">
</form>

<%@include file="../footer.html" %>
