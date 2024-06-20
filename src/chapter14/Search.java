package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/chapter14/search"})
public class Search extends HttpServlet {


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
			String keyword=request.getParameter("keyword");

			// SQLの設定（作成）
			// DBに向けて送るSQLを記載
			PreparedStatement st=con.prepareStatement(
					//WHERE句のLIKE式を使って、あいまい検索を行う
					// ?(プレースホルダ）を検索文字列を置き換えできるようにする
					"select * from product where name like ?");
			// "%"を使うことでkeywordの前後に文字が付くデータを検索する
			// 第一引数に設定した数値番目の"?"を第二引数で置き換え
			st.setString(1,"%"+keyword+"%");
			// SQLの実行 結果をResultSet型のrsに格納
			ResultSet rs=st.executeQuery();

			// SQLの結果を全て表示する（ループ文）
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String price = rs.getString("price");

				// getIn,getStringでテーブルの項目名を指定する事で値を取得
				out.println(id);
				out.println(":");
				out.println(name);
				out.println(":");
				out.println(price);
				out.println("<br>");

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
