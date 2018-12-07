<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstlEx01Sub.jsp</title>
</head>
<body>
	<h2>jstlEx01Sub.jsp</h2>
	<!-- jstlEx01.jsp에서 넘어오는 값을 출력해보세요 : el문법으로 -->
	<h2>두 값의 합: ${requestScope.num1 + requestScope.num2 }</h2>
	<h2>두 값의 차: ${requestScope.num1 - requestScope.num2 } </h2>
	<h2>두 값의 곱: ${requestScope.num1 * requestScope.num2 }</h2>
	<h2>두 값의 몫: ${requestScope.num1 / requestScope.num2 }</h2>
</body>
</html>