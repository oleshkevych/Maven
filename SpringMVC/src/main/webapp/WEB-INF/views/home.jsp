<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="resources/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Vova


	<br>
	<sec:authentication property="name" />
	<br>
	<br>
	
	<!--  <a href="newUser">add user</a>-->
	<sec:authorize access="!isAuthenticated()">
		<a href="newUser">registration</a>
		<br>
		<a href="loginpage">login page</a>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<sf:form action="logout" method="post">
		<a href="commodity">add commodity</a>
	<br>
	<br>
	<br>
			<button>logout</button>
		</sf:form>
	</sec:authorize>

</body>
</html>