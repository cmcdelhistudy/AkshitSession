<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
	<center>

		<%
			HttpSession s = request.getSession(false);
			String key = (String) s.getAttribute("S3CRET");
			if (key == null) {
				out.println("You are not in the session.Please Login");
			}else{
				String uname=(String)s.getAttribute("USERNAME");
				%>
				<h1>Welcome <%=uname%></h1>

			     <br> <br> <br> 
			     <a href="settings.jsp">Settings</a>
			     <br> <a href="shopping.jsp">Shopping</a><br>
			     <br> <a href="LogoutServlet">Logout</a>
			     
			     <hr>
			     <h3>Session Prperties</h3>
			     <br> Session ID : <%=s.getId()%>
			     <br> Session Creation Time : <%=s.getCreationTime() %>
			     <br> Session Last Accessed Time : <%=s.getLastAccessedTime() %>
			     <br> Session IS New : <%=s.isNew() %>
			     <br> Session Max Inactive Time Interval : <%=s.getMaxInactiveInterval()%>
			    
			     
			     </hr>
			
			<%				
			}
		%>

	</center>
</body>
</html>