<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>el.jsp</title>
</head>
<body>
	<!-- 
		EL(Expression Language)
		: jsp 문법에서 저장 객체를 출력할 때 스크립팅 기술
										<%-- <% %> --%>
		을 전혀 쓰지 않을 수 있도록 해주는 언어
		: 기본적으로 지원하기 때문에 따로 설정할 것이 없음
	 -->
	 
	 <%-- <%
	 	String id = request.getParameter("id");
	 	out.println(id);
	 %>
	  --%>
	 <br />
	 <%-- <%=id %> --%>
	 
	 <!-- ex) el로 같은 값 -->
	 <h2>${param.id }</h2> <%-- <%=id %> 와 같음. --%>
</body>
</html>