package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ingredient;

/**
 * Servlet implementation class AddIngredientServlet
 */
@WebServlet("/addIngredientServlet")
public class AddIngredientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddIngredientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("ingredientName");
		String amount = request.getParameter("ingredientAmount");
		
		Ingredient i = new Ingredient(name,amount);
		IngredientHelper dao = new IngredientHelper();
		dao.insertItem(i);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
}
