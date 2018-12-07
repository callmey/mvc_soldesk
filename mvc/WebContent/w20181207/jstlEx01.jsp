<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstlEx01.jsp</title>
</head>
<body>
	<!-- 
		c:set - 변수 선언하고 그 변수에 초기값을 대입하는 기능의 액션
			  - scope 객체의 범위를 지정할 수 있음
			  (page, request, session, application)
	
	 -->
	<c:set var="num1" value="200" scope="request"></c:set>
	<c:set var="num2" value="100" scope="request"></c:set>
	<jsp:forward page="jstlEx01Sub.jsp"></jsp:forward>
</body>
</html>