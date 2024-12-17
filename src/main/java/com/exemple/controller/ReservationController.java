package com.exemple.controller;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exemple.model.Reservation;
import com.exemple.service.ReservationService;

import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public String listReservations(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations);
        return "listReservations";
    }

    @GetMapping("/reservation/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Reservation reservation = reservationService.getReservationById(id);
        model.addAttribute("reservation", reservation);
        return "updatereservation"; 
    }
    @RequestMapping("/filter")
    public String getReservationsSorted(
            @RequestParam(required = false, defaultValue = "asc") String sortByDate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int pageSize,
            Model model) {

        Page<Reservation> reservationPage = reservationService.getReservationsSortedByDate(
                sortByDate, PageRequest.of(page, pageSize));

        model.addAttribute("reservations", reservationPage.getContent());
        model.addAttribute("sortByDate", sortByDate);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", reservationPage.getTotalPages());

        return "listReservations"; // Thymeleaf template for displaying reservations
    }

    @PostMapping("/reservation/update/{id}")
    public String updateReservation(@PathVariable("id") Long id, @ModelAttribute("reservation") Reservation reservation, BindingResult result) {
        if (result.hasErrors()) {
            return "updatereservation";
        }

        reservationService.updateReservation(reservation);
        return "redirect:/reservations"; 
    }
    @RequestMapping(value = "/reservation/delete/{id}", method = RequestMethod.GET)
    public String deleteReservation(@PathVariable("id") Long id) {
        reservationService.deleteReservationById(id);
        return "redirect:/reservations"; 
    }
}