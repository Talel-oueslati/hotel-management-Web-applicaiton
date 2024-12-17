package com.exemple.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exemple.model.Reservation;
import com.exemple.model.chambre;
import com.exemple.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
        
    ReservationService reservationService;
    
    ChambreService chambreService;

  


    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }


    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    @Override
public void updateReservation(Reservation reservation) {
    reservationRepository.save(reservation);  
}
    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid reservation Id:" + id));
    }
	@Override
	public void deleteReservationById(Long id) {
	    reservationRepository.deleteById(id);
	}
    @Override
    public Page<Reservation> getReservationsSortedByDate(String sortByDate, Pageable pageable) {
        Sort sort = sortByDate.equalsIgnoreCase("asc") ? Sort.by("dateArrivee").ascending() : Sort.by("dateArrivee").descending();
        return reservationRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort));
    }

    @PostMapping("/submitReservation")
    public String submitReservation(@RequestParam Long chambreId,
                                     @RequestParam String dateArrivee,
                                     @RequestParam String dateDepart,
                                     @RequestParam int nombrePersonnes,
                                     @RequestParam String typePaiement,
                                     @RequestParam double montantTotal) {

        Reservation reservation = new Reservation();
        reservation.setDateArrivee(dateArrivee);
        reservation.setDateDepart(dateDepart);
        reservation.setNombrePersonnes(nombrePersonnes);
        reservation.setTypePaiement(typePaiement);
        reservation.setMontantTotal(montantTotal);

        Optional<chambre> optionalChambre = chambreService.findById(chambreId);
        
 

     
        reservationService.saveReservation(reservation);

        return "redirect:/success"; 
    }
}


