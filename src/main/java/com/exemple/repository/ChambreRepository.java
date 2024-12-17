package com.exemple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemple.model.chambre;

@Repository
public interface ChambreRepository extends JpaRepository<chambre, Long> {

}
