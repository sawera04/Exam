<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<!--
 formの入力は リクエスト属性のparamに値が保持される
 EL式では属は無視できる
 =>param. "name"で値を取得できる
 -->
${param.price}円 x
${param.count}個 =
${param.price*param.count}円

<%@include file="../footer.html" %>
