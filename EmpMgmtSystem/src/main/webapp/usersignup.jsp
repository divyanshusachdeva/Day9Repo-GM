<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "UserInfoServlet">
	<label for="userid">UserID:</label><br>
    <input type="number" id="userid" name="userid" required><br><br>

    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username" maxlength="15" required><br><br>

    <label for="email">Email ID:</label><br>
    <input type="email" id="email" name="email" maxlength="20" required><br><br>
    
    <label for="mobno">Mobile Number::</label><br>
    <input type="number" id="mobno" name="mobno" required><br><br>

    <label for="userpass">Password:</label><br>
    <input type="password" id="userpass" name="userpass" maxlength="10" required><br><br>

    <input type="submit" value="Submit Details">
  </form>
</body>
</html>