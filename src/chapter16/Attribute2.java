package chapter16;

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

@WebServlet(urlPatterns={"/chapter16/attribute2"})
public class Attribute2 extends HttpServlet {

	public void doGet (
			HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		// 例外処理
		try{
            // DB内のデータにアクセスする為DAOを使う
			// アクセスするデーブル名がPRODUCTなので
			// ProductDAOをインスタンスする
			ProductDAO dao=new ProductDAO();
			// 検索の結果をList型（ProductのList）で取得する
			// DB検索はseach()メソッドを使う
			List<Product> list=dao.search("");

			// Request.setAttribute()メソッドを使って
			// JSPにProduct型オブジェクトのリスト"list"を渡せるようにする
			request.setAttribute("list", list);
			
            // "attribute2.jsp"をフォワード(実行)する
			request.getRequestDispatcher("attribute2.jsp").forward(request, response);


		} catch (Exception e) {
			e.printStackTrace(out);
		}

	}

}



