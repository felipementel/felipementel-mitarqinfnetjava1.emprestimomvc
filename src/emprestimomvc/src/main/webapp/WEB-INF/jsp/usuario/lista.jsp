<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Lista de usuário 
	
	<c:forEach var="usuario" items="${usuarioLista}">
		<h4>
			[${usuario.nome}] <a href="/usuario/excluir/${usuario.id}">Excluir</a>		
		</h4>
	</c:forEach>
</body>
</html>