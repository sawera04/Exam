<%@page contentType="text/html; charset=UTF-8" %>

<%-- カレントディレクトリはJSPのフォルダ(URL)になる --%>
<%@include file="../header.html" %>

<!-- 例外エラーのページ設定をする -->
<%@page errorPage="total-error.jsp" %>

<% request.setCharacterEncoding("UTF-8");
int price=Integer.parseInt(request.getParameter("price"));
int count=Integer.parseInt(request.getParameter("count"));
%>

<%=price %>円X<%=count %>個=<%=price*count %>円

<%@include file="../footer.html" %>
