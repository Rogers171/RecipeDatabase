<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pizza Recipe Home</title>
</head>
<body>
	<h1>Welcome to the Pizza Recipe List!</h1>
	<p> This is a web app that lets you store all your favorite pizza recipes <br/>
	The basics of each pizza will remain the same, but each recipe will have a different set of ingredients <br/>
	Below, you will find the instructions for the pizza base, and then you can add your own topping combinations. </p>
	
	<h2>Making the Pizza Base</h2>
	<h3>Ingredients</h3>
		<p>One package of pizza dough<br/>
		One can of pizza sauce<br/>
		One package of shredded mozarella cheese</p>
	<h3>Instructions</h3>
		<p>Step 1: Preheat oven to 350 Degrees <br/>
		Step 2: Roll out pizza dough onto baking sheet <br/>
		Step 3: Using a spatula, spread the pizza sauce on the dough, leaving an empty space along the edge for the crust <br/>
		Step 4: Pour the mozzarella cheese over the sauce<br/>
		Step 5: (Optional) Add topping combinations from one of our recipes!<br/>
		Step 6: Bake pizza in oven for 20 minutes.<br/>
		Step 7: Let cool and then enjoy!
		</p>
	<h2>Recipes</h2>
	<p> Now, add a recipe or view the existing list of recipes!</p>
	<form action = "addRecipeServlet" method="post">
	Name: <input type="text" name="recipeName">
	<input type = "submit" value="Add Recipe">
	</form><br/>
	<a href = "viewRecipesServlet">View the List of Recipes</a>
	
</body>
</html>