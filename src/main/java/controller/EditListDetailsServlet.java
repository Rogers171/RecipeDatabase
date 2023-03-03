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
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
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
		ListDetailsHelper dao = new ListDetailsHelper();
		IngredientHelper ih = new IngredientHelper();
		RecipeHelper rh = new RecipeHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String recipeName = request.getParameter("recipeName");
		
		Recipe newRecipe = rh.findRecipe(recipeName);
		
		try {
			String[] selectedItems = request.getParameterValues("allItemsToAddd");
			List<Ingredient> selectedItemsInList = new ArrayList<Ingredient>();
			
			for (int i = 0; i <selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Ingredient c = ih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			listToUpdate.setIngredientList(selectedItemsInList);
		} catch (NullPointerException ex) {
			List<Ingredient> selectedItemsInList = new ArrayList<Ingredient>();
			listToUpdate.setIngredientList(selectedItemsInList);
		}
		
		listToUpdate.setListName(newListName);
		listToUpdate.setRecipe(newRecipe);
		
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request,  response);
	}

}
