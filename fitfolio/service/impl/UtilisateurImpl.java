package com.example.fitfolio.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fitfolio.dto.AuthentificationDTO;
import com.example.fitfolio.dto.UtilisateurDTO;
import com.example.fitfolio.entity.Utilisateur;
import com.example.fitfolio.payload.AuthentificationMessage;
import com.example.fitfolio.repository.ActiviteRepo;
import com.example.fitfolio.repository.DateERepo;
import com.example.fitfolio.repository.RepasRepo;
import com.example.fitfolio.repository.PlanRepasRepo;
import com.example.fitfolio.repository.UtilisateurRepo;
import com.example.fitfolio.service.UtilisateurService;

@Service
public class UtilisateurImpl implements UtilisateurService {

    @Autowired
    UtilisateurRepo utilisateurRepository;

    @Autowired
    RepasRepo repasRepo;

    @Autowired
    ActiviteRepo activiteRepo;
    
    @Autowired
    DateERepo dateERepo;
    
    
    @Autowired
    PlanRepasRepo  planRepasRepo;
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String addUtilisateur(UtilisateurDTO utilisateurDTO) {
        try {
            Utilisateur utilisateur = new Utilisateur();
            BeanUtils.copyProperties(utilisateurDTO, utilisateur);
            utilisateurRepository.save(utilisateur);
            return "Utilisateur added successfully.";
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    


    
    @Override
    public AuthentificationMessage authentificationUtilisateur(AuthentificationDTO authentificationDTO) {
        try {
            Utilisateur utilisateur = utilisateurRepository.findByEmailAndMotDePasse(authentificationDTO.getEmail(), authentificationDTO.getMotDePasse());
            if (utilisateur != null) {
                return new AuthentificationMessage("Authentication successful.", true);
            } else {
                return new AuthentificationMessage("Invalid credentials.", false);
            }
        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public Utilisateur findByMatricule(Long matricule) {
        return utilisateurRepository.findByMatricule(matricule);
    }

    @Override
    public String findObjectif(Utilisateur utilisateur) {
        return utilisateur.getObjectif();
    }
    
    
    
    @Override
    public Utilisateur findByEmailAndMotdepasse(String email, String motdepasse) {
        try {
            return utilisateurRepository.findByEmailAndMotDePasse(email, motdepasse);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Utilisateur findByEmail(String email) {
        try {
            return utilisateurRepository.findByEmail(email);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    @Override
    @Transactional
    public String updateUtilisateurByMatricule(UtilisateurDTO utilisateurDTO) {
        String queryString = "UPDATE Utilisateur u SET " +
                "u.email = :email, " +
                "u.nom = :nom, " +
                "u.prenom = :prenom, " +
                "u.telephone = :telephone, " +
                "u.motDePasse = :motDePasse, " +
                "u.age = :age, " +
                "u.sexe = :sexe, " +
                "u.poids = :poids, " +
                "u.taille = :taille, " +
                "u.objectif = :objectif " +
                "WHERE u.matricule = :matricule";

        int updatedEntities = entityManager.createQuery(queryString)
                .setParameter("email", utilisateurDTO.getEmail())
                .setParameter("nom", utilisateurDTO.getNom())
                .setParameter("prenom", utilisateurDTO.getPrenom())
                .setParameter("telephone", utilisateurDTO.getTelephone())
                .setParameter("age", utilisateurDTO.getAge())
                .setParameter("sexe", utilisateurDTO.getSexe())
                .setParameter("poids", utilisateurDTO.getPoids())
                .setParameter("taille", utilisateurDTO.getTaille())
                .setParameter("objectif", utilisateurDTO.getObjectif())
                .setParameter("motDePasse", utilisateurDTO.getMotDePasse())
                .setParameter("matricule", utilisateurDTO.getMatricule())
                .executeUpdate();

        if (updatedEntities == 1) {
            return "Mise à jour réussie";
        } else {
            return "Échec de la mise à jour";
        }
    }






	
	@Override
	public Utilisateur addUtilisateurleila(UtilisateurDTO utilisateurDTO) {
		 try {
	            Utilisateur utilisateur = new Utilisateur();
	            BeanUtils.copyProperties(utilisateurDTO, utilisateur);
	            Utilisateur utilisateurCree = utilisateurRepository.save(utilisateur);
	            return utilisateurCree;
	        } catch (Exception e) {
	            throw e;
	        }
	}

   
    
    
}
