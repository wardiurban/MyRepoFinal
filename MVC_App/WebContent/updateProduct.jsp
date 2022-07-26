<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ProductOperationController" method="post">
	<label>PId</label>
	<input type="number" name="pid"><br/>
	<label>Price</label>
	<input type="number" name="price"><br/>
	<input type="submit" value="Update Product">
	<input type="reset" value="reset">
	<br/>
</form>
</body>
</html>