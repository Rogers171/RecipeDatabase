/**
 * @author Adell - amrogers5
 * CIS175 - Spring 2023
 * Feb 26, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
		List<Recipe> allDetails = em.createQuery("SELECT r FROM Recipe r").getResultList();
		return allDetails;
	}
	
	public Recipe findRecipe(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Recipe> typedQuery = em.createQuery("select sh from Recipe sh where sh.recipeName = :selectedName", Recipe.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Recipe foundRecipe;
		try {
			foundRecipe = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundRecipe = new Recipe(nameToLookUp);
		}
		em.close();
		
		return foundRecipe;
	}

}
