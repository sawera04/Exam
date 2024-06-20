package chapter15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Page;

@WebServlet(urlPatterns={"/chapter15/search"})
public class Search extends HttpServlet {

	public void doPost (
			HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		// tryを使って例外処理を実施
		// DB接続を行う場合例外処理の可能性が高まるので必須
		try{
			// JSPで入力された値を取得 -> 変数:keywordに格納
			String keyword=request.getParameter("keyword");
            // ProductDAOのインスタンス
			ProductDAO dao=new ProductDAO();
			// searchメソッドの実行でDBからデータを取得
			// 引数に入力値を入れる事で入力した値を元にデータを取得
			List<Product> list=dao.search(keyword);

		// ループ文を使って画面にデータを表示する
		// Product型の変数:pにlistの中身を1つずつ格納する
		for (Product p : list) {
			// ゲッターを使って変数にデータを格納する
			int id = p.getId();
			String name= p.getName();
			int price = p.getPrice();


            out.println(p.getId());
		    out.println(":");
			out.println(p.getName());
			out.println(":");
			out.println(p.getPrice());
			out.println("<br>");

			}

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}

}



