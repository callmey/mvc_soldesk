<%@page import="bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>el2.jsp</h2>
	
	<%
		Object obj = session.getAttribute("vo");
		if(obj!=null) {
			MemberBean mb = (MemberBean)obj;
			
			out.println(mb.getId());
			out.println(mb.getPw());
		}
	
	%>
	
	<!--  위 자바 코드랑 같은 el 방식 -->
	<h2>ID : ${vo.id} </h2>
	<h2>PW : ${vo.pw} </h2>
	
	<!-- scope 찾아오는 순서 : page, request, session, application -->
	<!-- 조금 더 빨리 정확하게 찾고 싶으면 : + Scope -->
	
	<h2>ID : ${sessionScope.vo.id } </h2>
	<h2>PW : ${sessionScope.vo.pw }</h2> <!-- 보안 취약 -->
	
</body>
</html>