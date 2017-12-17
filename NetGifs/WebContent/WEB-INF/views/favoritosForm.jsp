<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Netgifx - Favoritos</title>
		<style type="text/css">
			td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
			th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		</style>
	</head>
	
	<body>
		<h1>Netgifx - Favoritos</h1>
		<table>
			<tr>
				<th width="200">Nome</th>
				<th width="200">Categoria</th>
				<th width="100">Classificação</th>
				<th width="100">Idioma</th>
				<th width="50">Assistir</th>
				<th width="50">Remover</th>
			</tr>
			<c:forEach items="${gifsFavoritos}" var="gif">
				<tr>
					<td>${gif.descricao}</td>
					<td>${gif.categoria.nome}</td>
					<td>${gif.classEtaria}</td>
					<td>${gif.idioma}</td>
					<td><a href="${gif.url}" target="_blank">Assitir</a></td>
					<td><a href="<c:url value="/removeFavorito/${gif.id}"/>">Remover</a></td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<a href="<c:url value="/favorito/home"/>">Home</a>
	</body>
</html>