<%@page contentType="text/html; charset=UTF-8" %>

<%-- カレントディレクトリはJSPのフォルダ(URL)になる --%>
<%@include file="../header.html" %>

<%--JSPの宣言による変数の宣言 メンバ変数になる --%>
<%!
   //サーバーが重くなる
   int countA=0;
   int countC=0;%>

<%
    // スクリプトレット内で定義される変数
    // JSPが実行している間だけ有効
    int countB=0;

    // インクリメント
    countA++;
    // デクリメント
    countB++;
    countC--;

    if(countA >= 100){
    	countA=0;
    }
    if(countC <= 0 ){
    	countC = 100;
    }
%>

<p>宣言による変数countAは<%=countA%></p>
<p>スクリプトレット内の変数countBは<%=countB%></p>

<%@include file="../footer.html" %>
