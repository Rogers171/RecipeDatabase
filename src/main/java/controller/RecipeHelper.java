/**
 * @author Adell - amrogers5
 * CIS175 - Spring 2023
 * Feb 26, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Ingredient;
import model.Recipe;

public class RecipeHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("RecipeDatabase");
	
	public void insertRecipe(Recipe rec) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(rec);
		em.getTransaction().commit();
		em.close();
	}
	public List<Recipe> getRecipes() {
		EntityManager em = emfactory.createEntityManager();
		List<Recipe> allDetails = em.createQuery("SELECT r FROM recipe r").getResultList();
		return allDetails;
	}
	
	//This should take an ingredient and add it to the ingredient list of the recipe
	public void insertNewIngredientDetails(Recipe r, Ingredient i) {
		r.getIngredientList().add(i);
	}

}
