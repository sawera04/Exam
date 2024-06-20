<%@page import="org.apache.naming.java.javaURLContextFactory" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%-- カレントディレクトリはJSPのフォルダ(URL)になる --%>
<%@include file="../header.html" %>

<p>Hello!</p>
<p>こんにちは!</p>

<%-- Javaプログラムを記述 システム日付を表示 --%>
<p><% out.println(new java.util.Date()); %></p>

<%@include file="../footer.html" %>
