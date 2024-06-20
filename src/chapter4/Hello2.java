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


@WebServlet(urlPatterns={"/chapter4/hello2"})

//public class -> ファイル名と同じ　（大文字小文字判別あり）
//java の class名は先頭大文字（アッパーキャメルケース）
public class Hello2 extends HttpServlet {
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
    	response.setContentType("text/plain; charset=UTF-8");

		// HTMlへの書き出しを行うための定義
		    PrintWriter out=response.getWriter();
		    //HTMLの記述、HTMLを作成する関数
		    out.println("Hello!");
		    out.println("こんにちは！");
		    //現在時刻の取得＋ブラウザに表示
		    out.println(new java.util.Date());
	}

}
