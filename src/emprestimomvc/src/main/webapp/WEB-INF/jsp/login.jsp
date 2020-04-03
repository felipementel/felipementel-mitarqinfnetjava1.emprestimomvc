<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="/login" method="post">

		<font color="red"> ${msg }</font>
		Login: <input type="text" name="login"> <br> 
		Senha: <input type="text" name="senha"><br>
		 <input type="submit" value="Acessar">
	</form>
</body>
</html>