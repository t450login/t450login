package com.example.fitfolio.service;

import com.example.fitfolio.dto.AuthentificationDTO;
import com.example.fitfolio.dto.UtilisateurDTO;
import com.example.fitfolio.entity.Utilisateur;
import com.example.fitfolio.payload.AuthentificationMessage;

public interface UtilisateurService {
    String addUtilisateur(UtilisateurDTO utilisateurDTO);
   
    

    AuthentificationMessage authentificationUtilisateur(AuthentificationDTO authentificationDTO);
    
    Utilisateur findByMatricule(Long matricule);
    
    String findObjectif(Utilisateur utilisateur);



	


	String updateUtilisateurByMatricule(UtilisateurDTO utilisateurDTO);



	Utilisateur findByEmailAndMotdepasse(String email, String motdepasse);



	Utilisateur findByEmail(String email);
	Utilisateur addUtilisateurleila(UtilisateurDTO utilisateurDTO);

	
    //String addPlanRepas(PlanRepasDTO planRepasDTO);
	
	

}
