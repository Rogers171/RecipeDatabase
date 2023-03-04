/**
 * @author Adell - amrogers5
 * CIS175 - Spring 2023
 * Mar 2, 2023
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@OneToOne (cascade=CascadeType.PERSIST) //One recipe would have one list of ingredients
	private Recipe recipe;
	@OneToMany(cascade=CascadeType.MERGE, fetch =FetchType.EAGER)
	private List<Ingredient> ingredientList;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, Recipe recipe, List<Ingredient> ingredientList) {
		super();
		this.id = id;
		this.listName = listName;
		this.recipe = recipe;
		this.ingredientList = ingredientList;
	}
	
	public ListDetails(String listName, Recipe recipe, List<Ingredient> ingredientList) {
		super();
		this.listName = listName;
		this.recipe = recipe;
		this.ingredientList = ingredientList;
	}
	
	public ListDetails(String listName, Recipe recipe) {
		super();
		this.listName = listName;
		this.recipe = recipe;
	}
	
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", recipe=" + recipe + ", ingredientList="
				+ ingredientList + "]";
	}
}
