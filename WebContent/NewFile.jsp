<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-9">
<title>Insert title here</title>
</head>
<body>
	<form action="/SpringMVC7/addbook" method="POST">
		请输入图书名<input type="text" name="bookname">
		请输入添加数量<input type="text" name="stocks">
		请输入金额<input type="text" name="price">
		<input type="submit" value="提交">
	</form>
	
	<br><br><br>
	<form action="/SpringMVC7/updatebook" method="POST">
		请输入图书名<input type="text" name="bookname">
		请输入金额<input type="text" name="price">
		<input type="submit" value="提交">
	</form>
</body>
</html>