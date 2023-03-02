<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new Ingredient</title>
</head>
<body>
<form action = "addIngredientServlet" method="post">
Ingredient Name: <input type ="text" name = "ingredientName"><br />
Amount: <input type = "text" name = "ingredientAmount"><br />
<br />
<input type = "submit" value="Create Ingredient">
</form>
<a href = "index.html">Go add new Recipes or check Lists.</a>
</body>
</html>