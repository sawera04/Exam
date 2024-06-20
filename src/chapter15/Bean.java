package chapter15;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import tool.Page;


@WebServlet(urlPatterns={"/chapter15/bean"})
public class Bean extends HttpServlet {
	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);

		// Product(Bean)をインスタンス化
		Product p=new Product();

		// Beanに値を設定する
		p.setId(1);
		p.setName("まぐろ");
		p.setPrice(100);

		// 変数にデータを格納する
		int id = p.getId();
		String name= p.getName();
		int price = p.getPrice();

		// getInt, getStringでテーブルの項目名を指定する事で値を取得
		out.println(id);
		out.println(":");
		out.println(name);
		out.println(":");
		out.println(price);
		out.println("<br>");

		Page.footer(out);
	}
}



