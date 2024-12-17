package com.exemple.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.model.chambre;
import com.exemple.repository.ChambreRepository;

@Service
public class ChambreServiceImpl implements ChambreService {
	
	@Autowired
	private ChambreRepository chambreRepository;
	
	@Override
	public List<chambre> getAllChambres(){
		return chambreRepository.findAll();
	}

	@Override
	public chambre getChambreById(Long id) {
		 return chambreRepository.findById(id).orElse(null);
	}
	@Override
	public void deleteChambreById(Long id) {
	    chambreRepository.deleteById(id); 
	}

    public void saveChambre(chambre chambre) {
        chambreRepository.save(chambre);
    }

    public Optional<chambre> findById(Long id) {
        return chambreRepository.findById(id);
    }

    @Override
    public void updateChambre(chambre chambre) {
        chambreRepository.save(chambre);
    }
}
