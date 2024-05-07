package com.example.fitfolio.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.fitfolio.entity.PlanRepas;

import java.util.List;

@Repository
public interface PlanRepasRepo extends JpaRepository<PlanRepas, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO  plan_repas (date_jour, id_date, repas_reference) VALUES (:dateJour, :fkDateId, :fkRepaId)", nativeQuery = true)
    void insertPlanRepas(@Param("dateJour") String dateJour, @Param("fkDateId") Long fkDateId, @Param("fkRepaId") Long fkRepaId);

    
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM PlanRepas pr WHERE pr.fkDate.idDate = :idDateParam")
    void deletePlanRepasByDateId(@Param("idDateParam") Long idDate);

  
    @Query("SELECT pr.fkRepa.repas_reference FROM PlanRepas pr WHERE pr.fkDate.idDate = :idDateParam AND pr.dateJour >= :DateDebut AND pr.dateJour <= :DateFin")
    List<Long> findRepasByDateRange(@Param("idDateParam") Long idDate, @Param("DateDebut") String DateDebut, @Param("DateFin") String DateFin);
    
    
    @Query("SELECT pr.fkRepa.repas_reference FROM PlanRepas pr WHERE pr.fkDate.idDate = :idDateParam AND pr.dateJour = :DateJour")
    List<Long>  findRepasByDateandDateJ(@Param("idDateParam") Long idDate, @Param("DateJour") String DateJour);
    
    
    

}


