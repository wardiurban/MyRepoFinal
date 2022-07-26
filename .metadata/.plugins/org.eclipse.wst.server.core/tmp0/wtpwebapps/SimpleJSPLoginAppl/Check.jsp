<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!String email,password; %>
<%
email = request.getParameter("email");
password = request.getParameter("password");
RequestDispatcher rd1 = request.getRequestDispatcher("Home.jsp");
RequestDispatcher rd2 = request.getRequestDispatcher("index.jsp");
if(email.equals("azwardi@maybank.com") && password.equals("123")){
	out.println("Successful Login!");
	rd1.forward(request, response);
	}else {
	out.println("Pls Try Again!");	
	rd2.include(request, response);
}		
%>
</body>
</html>