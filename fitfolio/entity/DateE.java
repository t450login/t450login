package com.example.fitfolio.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class DateE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDate; 

    @Column(name = "date_debut", length = 30)
    private String dateDebut;

    @Column(name = "date_fin", length = 30)
    private String dateFin;
    
    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "fk_matricule", referencedColumnName = "matricule")
    private Utilisateur fk_matricule;
    
   
    
    public DateE() {
    	
    }
    
	public DateE(Long idDate, String dateDebut, String dateFin, Utilisateur fk_matricule) {
		
		this.idDate = idDate;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.fk_matricule = fk_matricule;
		
	}

	public Long getIdDate() {
		return idDate;
	}

	public void setIdDate(Long idDate) {
		this.idDate = idDate;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public Utilisateur getFk_matricule() {
		return fk_matricule;
	}

	public void setFk_matricule(Utilisateur fk_matricule) {
		this.fk_matricule = fk_matricule;
	}

	

	
}
