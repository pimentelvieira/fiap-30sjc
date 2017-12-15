<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <mvc:resources mapping="/resources/**" location="/resources/" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NETGIFS - ADM</title>
</head>
<body>
<h1>TODOS OS GIFS</h1>
	<a href="${pageContext.request.contextPath}/favoritos"> Favoritos</a>
	<br>
	<br>
	<c:forEach var="gif" items="${gifs.gifs}">	
	<form action=<c:url value="/gif"/> 
		method="get">
		nome: ${gif.nomeGif}<br>
		categoria: ${gif.categoria.getNomeCategoria()}<br>			
		classif : ${gif.clsItr}<br>		
		idioma: ${gif.idioma}<br>
		<a href="${pageContext.request.contextPath}/resources/gifs/${gif.nomeGif}.gif">Assitir</a>
	</form>

<%-- 		<iframe  src="${pageContext.request.contextPath}/resources/gifs/${gif}.gif" frameborder="0" scrolling="no" ></iframe> --%>
	</c:forEach>
</body>
</html>