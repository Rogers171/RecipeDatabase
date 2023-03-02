package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ingredient;
import model.Recipe;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RecipeHelper dao = new RecipeHelper();
		String act = request.getParameter("doThisToList");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewRecipesServlet").forward(request, response);
		} else if (act.equals("add ingredient to recipe")) {
			try {
				Recipe tempRec = new Recipe(request.getParameter("recipe")); // I need to get the value from the radio buttons of Ingredients-to-recipe.jsp, then convert it into a recipe object
				Ingredient tempIng = new Ingredient(request.getParameter("ingredient"));
				RecipeHelper rh = new RecipeHelper();
				
				rh.insertNewIngredientDetails(tempRec, tempIng);
				
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/addIngredientsForRecipeServlet").forward(request,response);
			}
			
		}
	}

}
