package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Scott Grigsby-sdgrigsby
 *CIS175-Spring 2023
 * Feb 26, 2023
 */
@Entity
@Table(name="ingredient")
public class Ingredient {
	//Attributes
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="AMOUNT")
	private String amount;
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	//Construtors
	public Ingredient() {
		super();
	}
	public Ingredient(int id, String name, String amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
	}
	public Ingredient(String name, String amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
	
	public Ingredient(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}
	
	
	
	
	
	
	
	
	
}
