package chapter16;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;

@WebServlet(urlPatterns={"/chapter16/attribute"})
public class Attribute extends HttpServlet {

	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException {
		// bean.Product型のオブジェクトのインスタンス
		Product p=new Product();
		// Product型のオブジェクトにsetメソッドを使って値を設定
		p.setId(1);
		p.setName("まぐろ");
		p.setPrice(100);

		// Request.setAttribute(メソッド）を使って
		// jsp にProduct型のオブジェクト p を渡せるようにする
		request.setAttribute("product", p);

		// attribute.jspをフォワード（実行）する
		request.getRequestDispatcher("attribute.jsp").forward(request, response);
	}
}
