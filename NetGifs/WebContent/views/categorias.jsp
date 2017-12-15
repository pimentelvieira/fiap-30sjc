<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Categorias</title>
		<style type="text/css">
			td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
			th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		</style>
	</head>
	<body>
		<h1>Categorias</h1>
		<table>
			<tr>
				<th width="30">Id</th>
				<th width="200">Nome</th>
				<th width="50">Alterar</th>
				<th width="50">Remover</th>
			</tr>
			<c:forEach items="${categorias}" var="categoria">
				<tr>
					<td>${categoria.id}</td>
					<td>${categoria.nome}</td>
					<td><a href="<c:url value="/categoria/form_update/${categoria.id}"/>">Editar</a></td>
					<td><a href="<c:url value="/categoria/form_remove/${categoria.id}"/>">Remover</a></td>
				</tr>			
			</c:forEach>
		</table>
		<br/>
		<a href="<c:url value="/homeAdm"/>">Home</a>&nbsp;&nbsp;&nbsp;<a href="<c:url value="/categoria/form_cadastro"/>">Incluir</a>
	</body>
</html>