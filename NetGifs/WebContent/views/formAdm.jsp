<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NETGIFS - ADM</title>
</head>
<body>
	<p>${mensagem}</p>
	<h1>NETGIFS - ADM</h1>
	<a	href="${pageContext.request.contextPath}/homeAdm">Home</a>	<br><br><br>
		<form action=<c:url value="/cadastrarGif"/>
		method="post" > 
		nome do gif: <input type="text" name="nomeGif"> <br>
		descricao: <input type="text" name="desc"><br> 
		categoria: <input	type="text" name="categoria"> <br> 
		idioma: <input	type="text" name="idioma"> <br> 
		link: <input	type="text" name="link"> <br> 
		classificação etaria: <input type="text" name="clsItr"> 
	 <input type="submit">
	</form>

	<br>
	<br>
	<h1>CADASTRAR USUARIO</h1>
	<form action=<c:url value="/cadastroUsuario"/> method="post">
		nome do gif: <input type="text" name="nomeGif"> <br>
		descricao: <input type="text" name="desc"><br> 
		categoria: <input	type="text" name="categoria"> <br> 
		idioma: <input	type="text" name="idioma"> <br> 
		classificação etaria: <input type="text" name="clsItr"> <br> <input type="submit">
	</form>
		<br>
	<br>
	<h1>CADASTRAR CATEGORIA</h1>
	<form action=<c:url value="/cadastrarCategoria"/> method="post">
		nome do gif: <input type="text" name="nomeGif"> <br>
		descricao: <input type="text" name="desc"><br> 
		categoria: <input	type="text" name="categoria"> <br> 
		idioma: <input	type="text" name="idioma"> <br> 
		classificação etaria: <input type="text" name="clsItr"> <br> <input type="submit">
	</form>
	<br></br>
	
	
</body>
</html>




