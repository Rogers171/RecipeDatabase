package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Recipe;

/**
 * Servlet implementation class AddRecipeServlet
 */
@WebServlet("/addRecipeServlet")
public class AddRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRecipeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String recipeName = request.getParameter("recipeName");
		LocalDate dateAdded = LocalDate.now();
		
		Recipe rec = new Recipe(recipeName, dateAdded);
		RecipeHelper dao = new RecipeHelper();
		dao.insertRecipe(rec);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request,  response);
	}

}
