package com.example.fitfolio.entity;

import javax.persistence.*;

@Entity
public class PlanRepas {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanR;

    @Column(name = "date_jour", length = 30)
    private String dateJour;

    @ManyToOne
    @JoinColumn(name = "idDate")
    private DateE fkDate;

    @ManyToOne
    @JoinColumn(name = "repas_reference")
    private Repas fkRepa;

    public PlanRepas() {
    }

	public PlanRepas(Long idPlanR, String dateJour, DateE fkDate, Repas fkRepa) {
		
		this.idPlanR = idPlanR;
		this.dateJour = dateJour;
		this.fkDate = fkDate;
		this.fkRepa = fkRepa;
	}

	public Long getIdPlanR() {
		return idPlanR;
	}

	public void setIdPlanR(Long idPlanR) {
		this.idPlanR = idPlanR;
	}

	public String getDateJour() {
		return dateJour;
	}

	public void setDateJour(String dateJour) {
		this.dateJour = dateJour;
	}

	public DateE getFkDate() {
		return fkDate;
	}

	public void setFkDate(DateE fkDate) {
		this.fkDate = fkDate;
	}

	public Repas getFkRepa() {
		return fkRepa;
	}

	public void setFkRepa(Repas fkRepa) {
		this.fkRepa = fkRepa;
	}


	 
	
	 
   }
