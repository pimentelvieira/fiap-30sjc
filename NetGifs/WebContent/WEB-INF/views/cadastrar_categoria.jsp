<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>NetGifx - Cadastrar Categoria</title>
	</head>
	<body>
		<h1>NetGifx - Cadastrar Categoria</h1>
		<form action="<c:url value="/categoria/cadastrar"/>" method="post">
			Nome:<br/>
			<input type="text" name="nome" /><br/><br/>
			<input type="submit" value="Gravar">
			<br/>
			<br/>
		</form>
		<a href="<c:url value="/categoria"/>">Voltar</a>
	</body>
</html>