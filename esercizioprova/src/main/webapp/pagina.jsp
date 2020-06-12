<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="aggiungiutente" method="post" >
             
			<input name="nome" id="nome" type="text" placeholder="nome">
		    <input name="cognome" id="cognome" type="text" placeholder="cognome" >
		    <input name="numero" id="numero" type="number" placeholder="numero" >
		    
		<input type="submit" value="Aggiungi">
		</form>


<table >
								<tr>
									<th>Nome</th>
									<th>Cognome</th>
									<th>Numero</th>
									
								</tr>

								<c:forEach items="${lista}" var="utente">

									<tr>
										<td><c:out value="${utente.getNome()}" /></td>
										<td><c:out value="${utente.getCognome()}" /></td>
										<td><c:out value="${utente.getNumero()}" /></td>
									</tr>
									</c:forEach>


</table>

</body>
</html>