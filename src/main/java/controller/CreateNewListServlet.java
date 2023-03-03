package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ingredient;
import model.ListDetails;
import model.Recipe;

/**
 * Servlet implementation class CreteNewListServlet
 */
@WebServlet("/creteNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IngredientHelper lih = new IngredientHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		
		String recipeName = request.getParameter("recipeName");
		
		String[] selectedIngredients = request.getParameterValues("allItemsToAdd");
		List<Ingredient> selectedItemsInList = new ArrayList<Ingredient>(); 
		if (selectedIngredients != null && selectedIngredients.length > 0) {
			for(int i = 0; i<selectedIngredients.length; i++) {
				System.out.println(selectedIngredients[i]);
				Ingredient c = lih.searchForItemById(Integer.parseInt(selectedIngredients[i]));
				selectedItemsInList.add(c);
			}
		}
		
		Recipe recipe = new Recipe(recipeName);
		ListDetails sld = new ListDetails(listName, recipe);
		
		sld.setIngredientList(selectedItemsInList);
		ListDetailsHelper slh = new ListDetailsHelper();
		slh.insertNewListDetails(sld);
		
		System.out.println("Success!");
		System.out.println(sld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsSErvlet").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
