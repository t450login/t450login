package com.example.fitfolio.entity;

import javax.persistence.*;

@Entity
public class Activite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activite_reference;

    @Column(name = "titre", length = 50)
    private String titre;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "categorie", length = 50)
    private String categorie;

    @Column(name = "type", length = 50) 
    private String type;

    
    
    
    
    public Activite() {
        this.titre = " ";
        this.description = " ";
        this.categorie = " ";
        this.type = " ";
    }


	public Activite(Long activite_reference, String titre, String description, String categorie, String type) {
		
		this.activite_reference = activite_reference;
		this.titre = titre;
		this.description = description;
		this.categorie = categorie;
		this.type = type;
	}
	
  public Activite( String titre, String description, String categorie, String type) {
	
		this.titre = titre;
		this.description = description;
		this.categorie = categorie;
		this.type = type;
	}

	public Long getActivite_reference() {
		return activite_reference;
	}

	public void setActivite_reference(Long activite_reference) {
		this.activite_reference = activite_reference;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    
   
}