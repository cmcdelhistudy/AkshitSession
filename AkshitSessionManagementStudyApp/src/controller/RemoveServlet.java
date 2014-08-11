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

import com.sun.org.apache.bcel.internal.generic.LNEG;

import model.Product;

@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String pid = request.getParameter("pid");

		Long id = Long.parseLong(pid);

		HttpSession s = request.getSession(false);
		String key = (String) s.getAttribute("S3CRET");
		if (key == null) {
			out.println("You are not in the session.Please Login");
		} else {

			ArrayList<Product> prodList = (ArrayList<Product>) s
					.getAttribute("TROLLEY");

			for (Product p : prodList) {
				if (p.id == id) {
					prodList.remove(p);
					break;
				}
			}

			request.getRequestDispatcher("shopping.jsp").forward(request,
					response);

		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
