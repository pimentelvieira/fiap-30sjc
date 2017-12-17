<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Netgifx - Home Administrador</title>
		<style type="text/css">
			td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
			th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		</style>
	</head>
<body>
	<a href="<c:url value="/gif"/>">Cadastro de Gifs</a><br/>
	<a href="<c:url value="/usuario"/>">Cadastro de Usuários</a><br/>
	<a href="<c:url value="/categoria"/>">Cadastro de Categorias</a><br/><br/><br/>
	<a href="<c:url value="/favoritos"/>">Favoritos</a><br/>
	<h1>Netgifx - Todos os Gifs</h1>
	<c:forEach var="categoria" items="${categorias}">
		<h2>Categoria - ${categoria.nome}</h2>
		<table>
			<tr>
				<th width="200">Nome</th>
				<th width="100">Classificação</th>
				<th width="100">Idioma</th>
				<th width="50">Assistir</th>
				<th width="50">Favoritos</th>
			</tr>
			<c:forEach var="gif" items="${categoria.gifs}">
				<tr>
					<td>${gif.descricao}</td>
					<td>${gif.classEtaria}</td>
					<td>${gif.idioma}</td>
					<td><a href="${gif.url}" target="_blank">Assitir</a></td>
					<td><a href="<c:url value="/addFavorito/${gif.id}"/>">Adicionar</a></td>
				</tr>	
			</c:forEach>
		</table>
		<br/>
	</c:forEach>
</body>
</html>