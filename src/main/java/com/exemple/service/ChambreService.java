package com.exemple.service;

import java.util.List;
import java.util.Optional;

import com.exemple.model.chambre;

public interface ChambreService {
	List<chambre> getAllChambres();
    chambre getChambreById(Long id);
    void deleteChambreById(Long id);
    void saveChambre(chambre chambre);
    Optional<chambre> findById(Long id);


    void updateChambre(chambre chambre); 
}
