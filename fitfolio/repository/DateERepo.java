package com.example.fitfolio.repository;
// modif deux
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.fitfolio.entity.DateE;

@Repository
public interface DateERepo extends JpaRepository<DateE, Long> {
	

	
	 @Transactional
	    @Modifying
	  
	    @Query(value = "INSERT INTO datee (date_debut, date_fin, fk_matricule) VALUES (:dateDebut, :dateFin, :fkmatricule)", nativeQuery = true)
	    void addDate(@Param("dateDebut") String dateDebut, @Param("dateFin") String dateFin, @Param("fkmatricule") Long fkmatricule);
        
	 
	 @Query(value = "INSERT INTO datee (date_debut, date_fin, fk_matricule) VALUES (:dateDebut, :dateFin, :fkmatricule)", nativeQuery = true)
	    void findBymatricule(@Param("dateDebut") String dateDebut, @Param("dateFin") String dateFin, @Param("fkmatricule") Long fkmatricule);

	 
	
	 @Query("SELECT pr.idDate FROM DateE pr WHERE pr.fk_matricule = :fkmatricule ")
	    Long findByMatricule1(@Param("fkmatricule")Long fkmatricule);

	 
	 @Query("SELECT pr.idDate FROM DateE pr WHERE pr.fk_matricule.matricule = :fkmatricule")
	 Long findByMatricule(@Param("fkmatricule") Long fkmatriculeId);


	  
		DateE findByIdDate(Long idDate);
		
	
}
