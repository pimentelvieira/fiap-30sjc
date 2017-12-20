<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>NetGifx - Cadastrar Gif</title>
	</head>
	<body>
		<h1>NetGifx - Cadastrar Gif</h1>
		<form action="<c:url value="/gif/cadastrar"/>" method="post">
			Nome:<br/>
			<input type="text" name="descricao"/><br/>
			Categoria:<br/>
			<select name="categoria">
				<c:forEach items="${categorias}" var="categoria">
					<option value="${categoria.id}">${categoria.nome}</option>
				</c:forEach>
			</select><br/>
			Classificação:<br/>
			<select name="classEtaria">
				<c:forEach items="${classEtarias}" var="classEtaria">
					<option value="${classEtaria}">${classEtaria}</option>
				</c:forEach>
			</select><br/>
			Idioma:<br/>
			<select name="idioma">
				<c:forEach items="${idiomas}" var="idioma">
					<option value="${idioma}">${idioma}</option>
				</c:forEach>
			</select><br/>
			URL:<br/>
			<input type="text" name="url" /><br/><br/>
			<input type="submit" value="Gravar">
			<br/>
			<br/>
		</form>
		<a href="<c:url value="/gif"/>">Voltar</a>
	</body>
</html>