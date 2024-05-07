package com.example.fitfolio.dto;

public class RepasDTO {

    private String repas_reference;
    private String titre;
    private String description;
    private String categorie;
    private float nbrCalories;

    public RepasDTO() {
    }

    public RepasDTO(String repas_reference, String titre, String description, String categorie, float nbrCalories) {
        this.repas_reference = repas_reference;
        this.titre = titre;
        this.description = description;
        this.categorie = categorie;
        this.nbrCalories = nbrCalories;
    }

    

    public String getRepas_reference() {
		return repas_reference;
	}

	public void setRepas_reference(String repas_reference) {
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
}
