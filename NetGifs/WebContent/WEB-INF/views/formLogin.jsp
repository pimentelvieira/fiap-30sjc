<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NetGifx - Login</title>
</head>
<body>
	<p>${mensagem}</p>
	<h1>NetGifx - Login</h1>
	<form action=<c:url value="/login"/> method="post">
		Login:<br/>
		<input type="text" name="login"><br/>
		Senha:<br />
		<input type="password" name="senha"><br/><br/>
		<input type="submit" value="Logar">
	</form>
</body>
</html>