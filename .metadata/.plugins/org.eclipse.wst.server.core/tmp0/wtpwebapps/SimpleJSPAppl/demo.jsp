<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- Comments --%>
<%! int a,b,sum; %>
<%
a=10;
b=20;
int sum = a+b;
out.println("Welcome to simple jsp page<br/>");
out.println("Sum of two number ="+sum);
%>
<p>sum of two number is <%=100+200 %></p>
<font color="red">Sum of two number is <%=sum %></font>
</body>
</html>