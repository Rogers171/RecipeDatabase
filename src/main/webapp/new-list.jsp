<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new List</title>
</head>
<body>
	<form action = "createNewListServlet" method="post">
	ListName: <input type = "text" name = "listName">
	Recipe Name: <input type = "text" name = "recipeName"><br />
	
	Available Ingredients:<br />
	<select name= "allItemsToAdd" multiple size="6:">
	<c:forEach items="${requestScope.allItems}" var = "currentitem">
		<option value = "${currentitem.id }">${currentitem.ingredient} | ${currentitem.amount}</option>
	</c:forEach>
	</select> 
	<br />
	<input type = "submit" value="Create List and Add Ingredients">
	</form>
	<a href = "index.html">Go add new ingredients and recipes instead.</a>
</body>
</html>