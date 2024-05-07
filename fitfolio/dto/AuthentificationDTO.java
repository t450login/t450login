package com.example.fitfolio.dto;

public class AuthentificationDTO {
	private String Email;
	private String MotDePasse;
	
	public AuthentificationDTO() {
	}
	
	public AuthentificationDTO(String Email, String MotDePasse) {
		this.Email = Email;
		this.MotDePasse = MotDePasse;
	} 
	
	public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMotDePasse() {
        return MotDePasse;
    }

    public void setMotDePasse(String MotDePasse) {
        this.MotDePasse = MotDePasse;
    }
}