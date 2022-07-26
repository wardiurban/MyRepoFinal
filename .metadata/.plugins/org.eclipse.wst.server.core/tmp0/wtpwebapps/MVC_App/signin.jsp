<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login Page</h2>
<form action="LoginController" method="get">
    <label>Email</label>
    <input type="email" name="email"/><br/>
    <label>Password</label>
    <input type="password" name="password"/><br/>
    <input type="submit" value="signIn"/>
    <input type="reset" value="reset"/>
</form>
<br/>
<a href="signUp.jsp">SignUp!</a>
</body>
</html>