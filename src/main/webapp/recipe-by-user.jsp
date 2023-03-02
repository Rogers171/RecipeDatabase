<%@ page language="java" contentType="text/html; harset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recipes</title>
</head>
<body>
<form method = "post" action = "listNavigationServlet">
<table>
<c:forEach items="${requestScope.allRecipes}" var="currentRecipe">
<tr>
	<td><input type="radio" name="id" value="${currentRecipe.id}"></td>
	<td><h2>${currentRecipe.recipeName}</h2></td></tr>
	<tr><td colspan="3">Date Added: ${currentRecipe.dateAdded}</td></tr>
	<c:forEach var = "listVal" items = "${currentRecipe.ingredientList}">
		<tr><td></td><td colspan="3">
			${listVal.name}, ${listVal.amount}
		</td>
	</tr>
  </c:forEach>
</c:forEach>
</table>

<input type = "submit" value = "edit" name="doThisToList">
<input type = "submit" value = "delete" name="doThisToList">
<input type="submit" value = "add" name = "doThisToList">
</form>
<a href="addIngredientServlet">Create a new ingredient</a>
<a href="index.html">Check the lists/add a new Recipe</a>
</body>
</html>