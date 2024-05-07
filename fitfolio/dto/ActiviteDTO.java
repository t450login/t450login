package com.example.fitfolio.dto;

public class ActiviteDTO {

    private String activite_reference;
    private String titre;
    private String description;
    private String categorie;

    public ActiviteDTO() {
    }

    public ActiviteDTO(String activite_reference, String titre, String description, String categorie) {
        this.activite_reference = activite_reference;
        this.titre = titre;
        this.description = description;
        this.categorie = categorie;
    }

    
    
    public String getActivite_reference() {
		return activite_reference;
	}

	public void setActivite_reference(String activite_reference) {
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
}