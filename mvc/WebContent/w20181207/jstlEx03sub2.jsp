<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstlEx03sub2.jsp</title>
</head>
<body>
	<!-- 자바 switch-case와 비슷한 문법 -->
	<h1>
		<c:choose>
			<c:when test="${sessionScope.visitor == 0 } ">처음 뵙겠습니다.</c:when>
			<c:when test="${sessionScope.visitor == 1 } ">어서오세요.</c:when>
			<c:when test="${sessionScope.visitor >= 2 } ">또 오셨네요.</c:when>
		</c:choose>
	</h1>
</body>
</html>