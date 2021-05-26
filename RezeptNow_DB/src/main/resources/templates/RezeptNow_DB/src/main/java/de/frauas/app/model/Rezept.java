package de.frauas.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rezept")
public class Rezept {
	//Hier wird ein Model des Objekts rezept erstellt, sowie
	//getter und setter Methiden honzugefügt

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "ingredient")
	private String ingredient;
	@Column(name = "description")
	private String description;
	
	public Rezept() {}
	public Rezept(String name, String ingredient, String description) {
		super();
		this.name = name;
		this.ingredient = ingredient;
		this.description = description;
	}

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

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
