<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>NetGifx - Cadastrar Usuário</title>
	</head>
	<body>
		<h1>NetGifx - Cadastrar Usuário</h1>
		<form action="<c:url value="/usuario/cadastrar"/>" method="post">
			Nome:<br/>
			<input type="text" name="nome" /><br/>
			Login:<br/>
			<input type="text" name="login" /><br/>
			Senha:<br/>
			<input type="password" name="senha" /><br/><br/>
			<input type="submit" value="Gravar">
			<br/>
			<br/>
		</form>
		<a href="<c:url value="/usuario"/>">Voltar</a>
	</body>
</html>