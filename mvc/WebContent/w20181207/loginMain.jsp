<%@page import="bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginMain.jsp</title>
</head>
<body>
	<h2>loginMain.jsp</h2>
	<%
		Object obj = session.getAttribute("vo");
		
		if(obj!=null) {
			/* out.println(obj); */
			
			MemberBean mb = (MemberBean)obj; 
			
			out.println(mb.getId());
			
		} else {
			MemberBean mb = new MemberBean();
		}
		
	%>
	
	
	<jsp:useBean id="vo" class="bean.MemberBean" scope="session"></jsp:useBean>
	
	<h2>ID : <jsp:getProperty property="id" name="vo"/></h2>
	<h2>PW : <jsp:getProperty property="pw" name="vo"/></h2>
</body>
</html>