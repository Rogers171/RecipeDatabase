package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ingredient;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String act = request.getParameter("doThisToItem");
		String path = "/viewIngredientsServlet";
		IngredientHelper dao = new IngredientHelper();
		
		if (act.equals("delete")) {
			try{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Ingredient itemToDelete = dao.searchForItemById(tempId);
				dao.deleteItem(itemToDelete);
			} catch(NumberFormatException e) {
				System.out.println("Forgot to select an ingredient");
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Ingredient ingredientToEdit = dao.searchForItemById(tempId);
				request.setAttribute("ingredientToEdit",  ingredientToEdit);
				path ="/edit-ingredient.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an ingredient");
			}
		} else if (act.equals("add")) {
			path = "/new-ingredient.jsp"; //Update this once we figure out what to do with the adding ingredients
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
