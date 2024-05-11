package com.example.fitfolio.repository;
//modif
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fitfolio.entity.Activite;

@Repository
public interface ActiviteRepo extends JpaRepository<Activite, Long> {
	@Query("SELECT a.activite_reference FROM Activite a WHERE a.type = :type")
    List<Long> findByType(@Param("type") String type);

}
