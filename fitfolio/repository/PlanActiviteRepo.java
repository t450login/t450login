package com.example.fitfolio.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.fitfolio.entity.PlanActivite;

import java.util.List;

@Repository
public interface PlanActiviteRepo extends JpaRepository<PlanActivite, Long>{
	
	
	 @Transactional
	    @Modifying
	  
	    @Query(value = "INSERT INTO plan_activite (date_jour, id_date, activite_reference) VALUES (:dateJour, :fkDateId, :fkActiviteId)", nativeQuery = true)
	    void insertPlanActivite(@Param("dateJour") String dateJour, @Param("fkDateId") Long fkDateId, @Param("fkActiviteId") Long fkActiviteId);

	    @Query("SELECT pr.fkActivite.activite_reference FROM PlanActivite pr WHERE pr.fkDate.idDate = :idDateParam AND pr.dateJour >= :DateDebut AND pr.dateJour <= :DateFin")
	    List<Long> findActiviteByDateRange(@Param("idDateParam") Long idDate, @Param("DateDebut") String DateDebut, @Param("DateFin") String DateFin);

	    @Query("SELECT pr.fkActivite.activite_reference FROM PlanActivite pr WHERE pr.fkDate.idDate = :idDateParam AND pr.dateJour = :DateJour")
	    List<Long> findActiviteByDateandDateJ(@Param("idDateParam") Long idDate, @Param("DateJour") String DateJour);

	    
	    @Transactional
	    @Modifying
	    @Query(value = "DELETE FROM PlanActivite pa WHERE pa.fkDate.idDate = :idDateParam")
	    void deletePlanActiviteByDateId(@Param("idDateParam") Long idDate);

	    
	    
}
