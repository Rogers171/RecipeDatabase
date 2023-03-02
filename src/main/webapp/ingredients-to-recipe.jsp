<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Ingredients to Recipe</title>
</head>
<body>
	<form action = "addIngredientsForRecipeServlet" method="post">
	<!-- This table should give the option to select a recipe -->
	<table>
		<c:forEach items="${requestScope.allRecipes}" var="currentRecipe">
		<tr>
			<td><input type="radio" id = "recipe" name="${currentRecipe.recipeName}, ${currentRecipe.dateAdded}" value="${currentRecipe.id}"></td>
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
	
	<!-- This table should give the option to select an ingredient -->
	<table>
		<c:forEach items="${requestScope.allIngredients}" var="currentIngredient">
		<tr>
			<td><input type="radio" id = "ingredient" name="ingredient" value="${currentIngredient.id}"></td>
			<td><h2>${currentIngredient.name}</h2></td></tr>
			<tr><td colspan="3">Amount: ${currentIngredient.amount}</td></tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "add ingredient to recipe" name="doThisToList">
	</form>
</body>
</html>