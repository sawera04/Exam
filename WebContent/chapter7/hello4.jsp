<%@page import="org.apache.naming.java.javaURLContextFactory" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%-- カレントディレクトリはJSPのフォルダ(URL)になる --%>
<%@include file="../header.html" %>

<p>Hello!</p>
<p>こんにちは!</p>

<%-- Javaプログラムを記述 システム日付を表示 --%>
<%--<%= でjavaプログラムの式の結果を表示することができる --%>
<p><%=new java.util.Date() %></p>

<%@include file="../footer.html" %>
