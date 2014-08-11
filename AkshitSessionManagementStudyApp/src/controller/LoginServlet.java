package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String uname = request.getParameter("username");
		String upass = request.getParameter("userpass");

		if (upass.equals("123")) {

			HttpSession ses = request.getSession(true);
			ses.setAttribute("S3CRET", "S3CRET");
			ses.setAttribute("USERNAME", uname);

			List<Product> prodList = new ArrayList<Product>();
			ses.setAttribute("TROLLEY", prodList);

			// good
			RequestDispatcher rdGood = request
					.getRequestDispatcher("mypage.jsp");
			rdGood.forward(request, response);
		} else {
			// bad
			RequestDispatcher rdBad = request
					.getRequestDispatcher("failure.jsp");
			rdBad.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
