<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "LoginServlet" method = "post">
	<label for= "username">Username:</label>
	<input type ="text" name="username" value="username" id="username">
	<label for="userpass">Password:</label>
	<input type ="password" name="userpass" value="userpass" id="userpass">
	<input type ="submit" value="Submit">

</form>
</body>
</html>