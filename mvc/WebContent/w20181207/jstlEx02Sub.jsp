<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstlEx02Sub.jsp</title>
</head>
<body>
	<%-- <c:if test="조건식">실행문</c:if> --%>
	
	<h1>
		<c:if test="${param.num1 - param.num2 >= 0 }">${param.num1 }</c:if>
	</h1>
	
	<!-- 일반 if문과 달리 else if가 없으므로 if를 계속 써야 함 -->
	
	<h1>
		<c:if test="${param.num1 - param.num2 < 0 }">${param.num2 }</c:if>
	</h1>
</body>
</html>