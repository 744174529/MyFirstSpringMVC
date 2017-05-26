<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/SpringMVC7/buy" method="POST">
		请输入购买书籍名称<input type="text" name="bookname">
		<br>
		请输入购买数量<input type="text" name="number">
		<br>
		<input type="submit" value="购买">
		<input type="reset" value="重置">
	</form>
</body>
</html>