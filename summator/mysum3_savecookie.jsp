<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Enter argumets: 
	<Form action="" method=Get> 
		<input type=Text name=a> 
		+
		<input type=Text name=b> 
		<input type=Submit value=Summ> 
	</Form> 
	<% 
		try {
				double a = Double.parseDouble(request.getParameter("a"));
				double b = Double.parseDouble(request.getParameter("b"));
				session.setAttribute("summa", a+b);
				response.sendRedirect("mysum3_opencookie.jsp");
			} catch (Exception e) {
			}
	%>
	<br><br><a href="index.jsp">main</a>
</body>
</html>