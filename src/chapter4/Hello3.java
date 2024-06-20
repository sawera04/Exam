package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//パス
//コンテキストのパス　http://localhost:8080
//コンテキストパスからの相対パス　/chapter/hello
//　:404エラーが発生したら確認する場所
//　404エラー：ページが見つかりません。


@WebServlet(urlPatterns={"/chapter4/hello3"})

//public class -> ファイル名と同じ　（大文字小文字判別あり）
//java の class名は先頭大文字（アッパーキャメルケース）
public class Hello3 extends HttpServlet {
	//ブラウザからのリクエストはアプリケーションに対して、
	//Getを送信する為のdoGetメソッドが実行される
    public void doGet (
    		// HttpServletRequest・・サーバに対してのリクエスト情報を取得する
			HttpServletRequest request, HttpServletResponse response
			// ServletException・・レスポンスを生成するために使用する引数
			//IOException：入力処理において例外が発生した際に知らせる
		) throws ServletException, IOException {

		    //日本語を表示する設定
    	    //文字コードを設定する（UTF-8）
    	    // printなどの記述の意味を設定（htmlでhtmlの要素を判定）
    	    response.setContentType("text/html; charset=UTF-8");

		    PrintWriter out=response.getWriter();

		    out.println("<!DOCTYPE html>");
		    out.println("<html>");
		    out.println("<headl>");
		    out.println("<meta charset='UTF-8'>");
		    out.println("<title>Servlet/JSP Sample Programs</title>");
		    out.println("</head>");
		    out.println("<body>");

		    out.println("<p>Hello!</p>");
		    out.println("<p>こんにちは！</p>");
		    out.println("<p>"+new java.util.Date()+"</p>");

		    out.println("</body>");
		    out.println("</html>");




	}

}
