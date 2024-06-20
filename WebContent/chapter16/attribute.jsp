<%@page contentType="text/html; charset=UTF-8" %>

<%-- カレントディレクトリはJSPのフォルダ(URL)になる --%>
<%@include file="../header.html" %>

<!-- Product型のオブジェクトをrequest.getAttribute()
     メソッドを使ってサーブレットからデータを受け取る
     ()の中はサーブレットで指定した変数名で取得  -->
<%@page import="bean.Product" %>

<% Product p=(Product)request.getAttribute("Product"); %>

<!-- productオブジェクトのゲッターを使って値を表示 -->
<%=p.getId() %> : <%=p.getName() %> : <%=p.getPrice() %><br>

<%@include file="../footer.html" %>
