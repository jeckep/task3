<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8080/Task3/CreateDB" metod=Get>
		<input type=Submit value="Creaete DB">
	</form>
	<form action="http://localhost:8080/Task3/ShowDB" metod=Get>
		<input type=Submit value="Show DB">
	</form>
	<Form action="http://localhost:8080/Task3/UpdateDB" method=Get> 
		<p>
		<label for="EMPNO">Employee No: </label>
		<input type="text" name="EMPNO"> 
		</p><p>
		<label for="ENAME">Name: </label>
		<input type="text" name="ENAME">
		</p><p>
		<label for="JOB_TITLE">Job title: </label> 
		<input type="text" name="JOB_TITLE">
		</p>
		<input type=Submit value="Add new employee"> 
	</Form>
	<br><br><a href="index.jsp">main</a>
	
</body>
</html>