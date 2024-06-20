package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/chapter14/insert"})
public class Insert extends HttpServlet {

	public void doPost (
			HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try{
			// データベースへの接続 start
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
					"java:/comp/env/jdbc/book");
			Connection con=ds.getConnection();
			// データベースへの接続 end

			// getParameterメソッドを利用してJSPの中で入力された値を取得
			String name=request.getParameter("name");
			int price=Integer.parseInt(request.getParameter("price"));

			// SQLの設定（作成）
			// DBに向けて送るSQLを記載
			PreparedStatement st=con.prepareStatement(
					//INSRT文を用意してデータベース
					// ?(プレースホルダ）を検索文字列を置き換えできるようにする
					"insert into product values(null, ?, ?)");

			// 第一引数に設定した数値番目の"?"を第二引数で置き換え
			st.setString(1, name);
			st.setInt(2, price);
			// SQLをDBMSに実行依頼 結果を取得
			// 登録件数、更新件数を取得
			int line=st.executeUpdate();

			if (line>0) {
				out.println("追加に成功しました。");
				// JSPをforwardする仕組み
				// JSPに画面表示は全て任せる
				//サーブレット側でデータ処理を行う
				request.getRequestDispatcher("insert_success.jsp").forward(request, response);

			}

			// SQLの設定を終了（開放）する
			st.close();
			// DBとの接続を切断する
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}

}
