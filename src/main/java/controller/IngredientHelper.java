package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Ingredient;


/**
 * @author Scott Grigsby-sdgrigsby
 *CIS175-Spring 2023
 * Feb 26, 2023
 */
public class IngredientHelper {
	 static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("RecipeDatabase");
	 
	 public void insertItem(Ingredient i) {
		 EntityManager em = emfactory.createEntityManager();
		 em.getTransaction().begin();
		 em.persist(i);
		 em.getTransaction().commit();
		 em.close();
	 }
	 public List<Ingredient> showAllItems() {
		 EntityManager em = emfactory.createEntityManager();
		 List<Ingredient> allItems = em.createQuery("SELECT i FROM ingredient i").getResultList();
		 return allItems;
	 }
	 public void deleteItem(Ingredient toDelete) {
		 EntityManager em = emfactory.createEntityManager();
		 em.getTransaction().begin();
		 TypedQuery<Ingredient>typedQuery = em.createQuery("select i from Ingredient i where i.name = :selectedName and i.amount = :selectedAmount",Ingredient.class);
		 
		 typedQuery.setParameter("selectedStore",toDelete.getName());
		 typedQuery.setParameter("selectedItem", toDelete.getAmount());
		 
		 typedQuery.setMaxResults(1);
		 
		 Ingredient result = typedQuery.getSingleResult();
		 
		 em.remove(result);
		 em.getTransaction().commit();
		 em.close();
	 }
	public Ingredient searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Ingredient found = em.find(Ingredient.class,idToEdit);
		em.close();
		return found;
	}
	public void updateItem(Ingredient toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	public List<Ingredient> searchForItemByName(String ingredientName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Ingredient>typedQuery = em.createQuery("select i from Ingredient i where ii.name = :selectedName",Ingredient.class);
		typedQuery.setParameter("selectedStore",ingredientName);
		
		List<Ingredient>foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	public List<Ingredient> searchForItemByAmount(String ingredientAmount) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Ingredient>typedQuery = em.createQuery("select i from Ingredient i where i.amount = :selectedAmount",Ingredient.class);
		typedQuery.setParameter("selectedItem",ingredientAmount);
		
		List<Ingredient>foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	public void cleanUp() {
		emfactory.close();
	}
}