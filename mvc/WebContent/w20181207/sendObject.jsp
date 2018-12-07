<%@page import="bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sendObject.jsp</title>
</head>
<body>
	<!-- 
		jsp action tag 사용해서
		MemberBean에 id : hong, pw : 1234 를 담아서
		forward 방식으로 el2.jsp로 이동시켜 보세요
		
		el2.jsp에서 bean 객체를 받아서 id, pw 값을 el문법으로 출력
	 -->
	 
	<jsp:useBean id="vo" class="bean.MemberBean" scope="session"></jsp:useBean>
	 
	<jsp:setProperty property="id" name="vo" value="hong"/>
	<jsp:setProperty property="pw" name="vo" value="1234"/>
	
	<jsp:forward page="el2.jsp"></jsp:forward> <!-- 최종주소를 알 수 없음 -->
</body>
</html>