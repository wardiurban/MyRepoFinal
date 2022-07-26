<%@page import="com.bean.Product"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>PId</th>
		<th>PName</th>
		<th>Price</th>
	</tr>

<%
Object obj =request.getAttribute("obj");
List<Product> listOfProdut = (List<Product>)obj;
Iterator<Product> li = listOfProdut.iterator();
while(li.hasNext()){
	Product p  = li.next();
	%>
	<tr>
		<td><%=p.getPid() %> </td>
		<td><%=p.getPname() %> </td>
		<td><%=p.getPrice() %> </td>
	</tr>
	<%
}
%>

</table>
<br/>
<a href="Home.jsp">Home Page</a>
</body>
</html>