package com.example.fitfolio.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.fitfolio.entity.Utilisateur;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
	
    Utilisateur findByEmailAndMotDePasse(String email, String motDePasse);
    

    
    
   // @Query("SELECT u.matricule, u.prenom, u.telephone, u.email, u.motDePasse, u.age, u.sexe, u.poids, u.taille, u.objectif FROM Utilisateur u WHERE u.email = :email AND u.motDePasse = :motDePasse")
   // Utilisateur  findByEmailAndMotDePasse(@Param("email") String email, @Param("motDePasse") String motDePasse);

    
    Utilisateur findByEmail(String email); 
    Optional<Utilisateur> findById(Long id);
    
    @Transactional
      @Modifying
    @Query("UPDATE Utilisateur u SET u.id_date.idDate = :dateEId WHERE u.matricule = :matricule")
    void updateUtilisateurDateE(@Param("dateEId") Long dateEId, @Param("matricule") Long matricule);
    

    @Query("SELECT u FROM Utilisateur u WHERE u.matricule = :matricule")
    Utilisateur findByMatricule(@Param("matricule") Long matricule);
    
    @Query("SELECT u.objectif FROM Utilisateur u WHERE u.matricule = :matricule")
    String findByObjectif(@Param("matricule") Long matricule);

    
  
}
