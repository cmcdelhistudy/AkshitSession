package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String pid = request.getParameter("pid");

		HttpSession s = request.getSession(false);
		String key = (String) s.getAttribute("S3CRET");
		if (key == null) {
			out.println("You are not in the session.Please Login");
		} else {

			ArrayList<Product> prodList = (ArrayList<Product>) s
					.getAttribute("TROLLEY");

			if (pid.equals("1")) {
				Product mobile = new Product(1, "Mobile", 100);
				prodList.add(mobile);

			} else if (pid.equals("2")) {
				Product lap = new Product(2, "Laptop	", 200);
				prodList.add(lap);

			} else if (pid.equals("3")) {
				Product watch = new Product(3, "Smart Watch", 50);
				prodList.add(watch);

			} else if (pid.equals("4")) {
				Product tshirt = new Product(4, "T Shirt", 15);
				prodList.add(tshirt);

			} else {
			}

			request.getRequestDispatcher("shopping.jsp").forward(request,
					response);

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
