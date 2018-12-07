<%@page import="bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginOk.jsp</title>
</head>
<body>
	<!--  loginForm에서 전달한 값을 출력  -->
	<%-- <%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		out.println(id);
	%> --%>
	
	<!--  jsp action tag : 자바 문법을 태그로 만들어 둔 것 -->
	<!-- jsp 페이지에서 최대한 자바 코드를 사용하지 않으려고 -->
	
	<%-- <%
		MemberBean mb = new MemberBean();
	%> --%>
	
	<jsp:useBean id="vo" class="bean.MemberBean" scope="session">
	</jsp:useBean>
	
	<!-- loginOk.jsp 에서 session으로 설정해서 보냈으므로
		정보가 필요한 페이지에서 session으로 받으면 됨
	 -->
	
	<%-- <%
		mb.setId(request.getParameter("id"));
	%> --%>
	<jsp:setProperty property="id" name="vo" param="id"/> <!-- useBean의 vo를 불러와 set id로 설정하는 것과 같음 -->
	<jsp:setProperty property="pw" name="vo" param="pw"/>
	
	<!-- 만약 property와 param(form을 통해 넘어오는 name값)
		의 이름이 같다면 property를 *로 지정해주면
		개발자가 한개씩 맵핑할 필요없이 자동으로 찾아줌
	-->
	<jsp:setProperty property="*" name="vo"/>
	
	<%-- <%.
		out.println(mb.getId());
	%> --%>
	
	<h2>ID : <jsp:getProperty property="id" name="vo"/></h2>
	<h2>PW : <jsp:getProperty property="pw" name="vo"/></h2>
	
	<!-- 페이지 이동 -->
	<jsp:forward page="loginMain.jsp"></jsp:forward>
</body>
</html>