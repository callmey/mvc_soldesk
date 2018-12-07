<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstlEx03.jsp</title>
</head>
<body>
	<c:set var="visitor" value="2" scope="session"></c:set>
	<jsp:forward page="jstlEx03Sub.jsp"></jsp:forward>
</body>
</html>