package com.example.fitfolio.entity;

import javax.persistence.*;

@Entity
public class Repas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repas_reference;

    @Column(name = "titre", length = 50)
    private String titre;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "categorie", length = 50)
    private String categorie;

    @Column(name = "nbr_calories")
    private float nbrCalories;

    @Column(name = "type", length = 50) 
    private String type;

   

	public Long getRepas_reference() {
		return repas_reference;
	}

	public void setRepas_reference(Long repas_reference) {
		this.repas_reference = repas_reference;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public float getNbrCalories() {
		return nbrCalories;
	}

	public void setNbrCalories(float nbrCalories) {
		this.nbrCalories = nbrCalories;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Repas(Long repas_reference, String titre, String description, String categorie, float nbrCalories,
			String type) {

		this.repas_reference = repas_reference;
		this.titre = titre;
		this.description = description;
		this.categorie = categorie;
		this.nbrCalories = nbrCalories;
		this.type = type;
	}
	
 public Repas() {
    	
    	    this.titre = "leila ";
    	    this.description = " leila";
    	    this.categorie = " leila";
    	    this.nbrCalories = 10;
    	    this.type = " leila";

    }
	public Repas( String titre, String description, String categorie, float nbrCalories,
			String type) {

		
		this.titre = titre;
		this.description = description;
		this.categorie = categorie;
		this.nbrCalories = nbrCalories;
		this.type = type;
	}
   
}