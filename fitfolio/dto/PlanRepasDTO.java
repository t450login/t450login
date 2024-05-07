
	 
	 package com.example.fitfolio.dto;

public class PlanRepasDTO {

	   
	    private String dateJour;
	    private Long fkDateId; 
	    private Long fkRepaId;
	    
	    
	    public PlanRepasDTO() {
			
	    }

	    
		public PlanRepasDTO( String dateJour, Long fkDateId, Long fkRepaId) {
		
		
			this.dateJour = dateJour;
			this.fkDateId = fkDateId;
			this.fkRepaId = fkRepaId;
		} 
		
	


		public String getDateJour() {
			return dateJour;
		}
		public void setDateJour(String dateJour) {
			this.dateJour = dateJour;
		}
		public Long getFkDateId() {
			return fkDateId;
		}
		public void setFkDateId(Long fkDateId) {
			this.fkDateId = fkDateId;
		}
		public Long getFkRepaId() {
			return fkRepaId;
		}
		public void setFkRepaId(Long fkRepaId) {
			this.fkRepaId = fkRepaId;
		}
	
}