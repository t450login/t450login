package com.example.fitfolio.repository;
// jamal allah rahmek
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fitfolio.entity.Repas;

@Repository
public interface RepasRepo extends JpaRepository<Repas, Long> {
	@Query("SELECT a.repas_reference FROM Repas a WHERE a.type = :type")
    List<Long> findByType(@Param("type") String type);
	
	
	 @Query("SELECT a.repas_reference FROM Repas a WHERE a.categorie = :categorie AND a.type = :type")
	    List<Long> findByCategorieAndType(@Param("categorie") String categorie, @Param("type") String type);
	
}
