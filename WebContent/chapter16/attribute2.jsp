<%@page contentType="text/html; charset=UTF-8" %>

<%-- カレントディレクトリはJSPのフォルダ(URL)になる --%>
<%@include file="../header.html" %>


<!-- 例外エラーのページ設定をする -->
<%@page import="bean.Product, java.util.List" %>

<% List<Product> list=(List<Product>)request.getAttribute("list"); %>

<table border="1">
    <thead>
    <th>ID</th><th>Name</th><th>Price</th>
    </thead>

<tbody>
<% for (Product p : list) { %>
    <tr>
       <td><%=p.getId() %></td>
       <td><%=p.getName() %></td>
       <td><%=p.getPrice() %></td>
<% } %>
</tr>
</tbody>
</table>

<%@include file="../footer.html" %>
