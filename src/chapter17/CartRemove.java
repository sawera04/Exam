package chapter17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Page;

@WebServlet(urlPatterns={"/chapter17/cart-remove"})
public class CartRemove extends HttpServlet {

	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);

		// セッションの開始
		HttpSession session=request.getSession();

		// セッションの保存されているデータを削除
		session.removeAttribute("cart");

		out.println("カートを削除しました。");
		Page.footer(out);
	}


}
