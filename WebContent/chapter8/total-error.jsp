<%@page contentType="text/html; charset=UTF-8" %>

<%-- カレントディレクトリはJSPのフォルダ(URL)になる --%>
<%@include file="../header.html" %>


<%@page isErrorPage="true" %>

<p>数値を入力してください。</p>

<p><%=exception %></p>

<%@include file="../footer.html" %>
