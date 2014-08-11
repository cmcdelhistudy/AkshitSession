<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList,model.Product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#basket {
	width: 200px;
	border-color: black;
	border-width: 5px;
	border-style: dashed;
	float: right;
}
</style>
</head>
<body>
	<center>

		<%
			HttpSession s = request.getSession(false);
			String key = (String) s.getAttribute("S3CRET");
			if (key == null) {
				out.println("You are not in the session.Please Login");
			} else {
				String uname = (String) s.getAttribute("USERNAME");
		%>

		<div align="center">
			Logged in as
			<%=uname%>
		</div>

		<h3>
			Hey
			<%=uname%>, we have some products for you
		</h3>

		<div id="basket">
			<h2>Items in your cart</h2>
			<%
				double totalAmount=0;
									ArrayList<Product> prodList = (ArrayList<Product>) s
											.getAttribute("TROLLEY");
											
										for(Product p:prodList){
											
											out.println("<br><a href='RemoveServlet?pid="+p.id+"'><img src='images/del.png'></a>"+p.name+"  &nbsp  Rs."+p.price);
											totalAmount=totalAmount+p.price;
										}
									out.println("<h2> Total Amount "+totalAmount+"</h2>");
			%>
		</div>

		<br> <br> <br> <br> <br> <img
			src="images/images.jpg"><br> <a
			href="PurchaseServlet?pid=1">Buy</a> <br> <img
			src="images/laptop.jpg""><br> <a
			href="PurchaseServlet?pid=2">Buy</a> <br> <img
			src="images/smart.jpg""><br> <a
			href="PurchaseServlet?pid=3">Buy</a> <br> <img
			src="images/tshirt.jpg""><br> <a
			href="PurchaseServlet?pid=4">Buy</a> <br> <a href="mypage.jsp">Back
			to Profile </a> <br> <a href="settings.jsp">Settings</a> <br> <a
			href="LogoutServlet">Logout</a>

		<hr>
		<h3>Session Prperties</h3>
		<br> Session ID :
		<%=s.getId()%>
		<br> Session Creation Time :
		<%=s.getCreationTime()%>
		<br> Session Last Accessed Time :
		<%=s.getLastAccessedTime()%>
		<br> Session IS New :
		<%=s.isNew()%>
		<br> Session Max Inactive Time Interval :
		<%=s.getMaxInactiveInterval()%>


		</hr>

		<%
			}
		%>

	</center>

</body>
</html>