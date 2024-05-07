package com.example.fitfolio.entity;

import javax.persistence.*;

@Entity
public class PlanActivite {

	



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanA;
	
	

	 @Column(name = "date_jour", length = 30)
	    private String dateJour;
	 
	 @ManyToOne
	    @JoinColumn(name = "idDate")
	    private DateE fkDate;
	 
	 
	
	 @ManyToOne
	    @JoinColumn(name = "activite_reference")
	    private Activite fkActivite;


	 
	 
	 
		public PlanActivite() {
		
	}




		
		

		public PlanActivite(Long idPlanA, String dateJour, DateE fkDate, Activite fkActivite) {
			
			this.idPlanA = idPlanA;
			this.dateJour = dateJour;
			this.fkDate = fkDate;
			this.fkActivite = fkActivite;
		}







		public Long getIdPlanA() {
			return idPlanA;
		}





		public void setIdPlanA(Long idPlanA) {
			this.idPlanA = idPlanA;
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





		public Activite getFkActivite() {
			return fkActivite;
		}





		public void setFkActivite(Activite fkActivite) {
			this.fkActivite = fkActivite;
		}



		
		

	
	 
	 
	 
}
