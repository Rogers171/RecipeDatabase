/**
 * @author Adell - amrogers5
 * CIS175 - Spring 2023
 * Feb 25, 2023
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="recipe")
public class Recipe {
	//Attributes
	@Id
	@GeneratedValue
	private int id;
	private String recipeName;
	private LocalDate dateAdded;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Ingredient> ingredientList;
	
	//Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}
	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}
	
	//Constructors
	public Recipe() {
		super();
	}
	
	public Recipe(String recipeName, LocalDate dateAdded, List<Ingredient> ingredientList) {
		super();
		this.recipeName = recipeName;
		this.dateAdded = dateAdded;
		this.ingredientList = ingredientList;
	}
	
	public Recipe(String recipeName, LocalDate dateAdded) {
		super();
		this.recipeName = recipeName;
		this.dateAdded = dateAdded;
	}
	public Recipe(int id, String recipeName, LocalDate dateAdded, List<Ingredient> ingredientList) {
		super();
		this.id = id;
		this.recipeName = recipeName;
		this.dateAdded = dateAdded;
		this.ingredientList = ingredientList;
	}
	
	public Recipe(String recipeName) {
		super();
		this.recipeName = recipeName;
	}
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", recipeName=" + recipeName + ", dateAdded=" + dateAdded + "]";
		
	}
	
	
	
	
}
