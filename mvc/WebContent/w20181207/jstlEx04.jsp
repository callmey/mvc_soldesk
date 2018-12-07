<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstlEx04.jsp</title>
</head>
<body>
	<!-- 자바 for문 역할 -->
	<h1><c:forEach begin="1" end="10" step="1">하이</c:forEach></h1>
	<h1>
		<c:forEach var="i" begin="1" end="10" step="2">${i}</c:forEach>
	</h1>
	
	<!-- 구구단 3단 출력해보세요 -->
	<h1>
		<c:forEach var="i" begin="1" end="9" step="1" >
			3 * ${i} = ${i*3} <br /> 
		</c:forEach>
	</h1>
	
	<!-- 중첩가능 : 구구단 9단까지 출력해보세요 -->
	<!--  <h1>
		<c:forEach var="i" begin="2" end="9" step="1" >
			<c:forEach var="j" begin="1" end="9" step="1">
				${i} * ${j} = ${i*j} <br />
			</c:forEach>
			<br />
		</c:forEach>
	</h1> -->
	
	<table border="1" border-collapse="collapse">
		<c:forEach var="g1" begin="2" end="9" step="1" >
			<c:forEach var="g2" begin="1" end="9" step="1">
				<tr>
					<td>${g1}* ${g2} = ${g1*g2}</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
	
	<!-- 배열값 출력 -->
	<h1>
		<c:set var="arr" value="<%=new int[]{1, 2, 3, 4, 5} %>"></c:set>
		<c:forEach var="i" items="${arr}">
			${i}
		</c:forEach>
	</h1>
	
</body>
</html>