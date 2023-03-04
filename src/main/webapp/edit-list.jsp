<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit An Existing List</title>
</head>
<body>
	<form action = "editListDetailsServlet" method="post">
	<input type = "hidden" name = "id" value= "${listToEdit.id}">
	List Name: <input type = "text" name = "listName" value="${listToEdit.listName}"><br />
	
	Recipe Name: <input type = "text" name = "recipeName" value="${listToEdit.recipe}"><br />
	
	Available Ingredients: <br />
	<select name="allItemsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allItems}" var="currentitem">
		<option value = "${currentitem.id}">${currentitem.name} | ${currentitem.amount} </option>
	</c:forEach>
	</select>
	<br />
	<input type = "submit" value="Edit List and add Items">"
	</form>
	<a href = "index.html">Go add new ingredients instead.</a>
</body>
</html>