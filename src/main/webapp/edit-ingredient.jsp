<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Ingredient</title>
</head>
<body>
<form action= "editIngredientServlet" method="post">
Name: <input type ="text" name = "store" value= "${itemToEdit.name}">
Amount: <input type = "text" name = "item" value= "${itemToEdit.amount}">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>