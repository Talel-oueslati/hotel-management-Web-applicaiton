package com.exemple.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exemple.model.Reservation;
import com.exemple.model.chambre;
import com.exemple.service.ChambreService;
import com.exemple.service.ReservationService;

@Controller
public class ChambreController {
	@Autowired
	private ChambreService chambreService;

    @Autowired
    private ReservationService reservationService;
	@GetMapping("/index")
	public String viewHomePage(Model model) {
		model.addAttribute("listChambres",chambreService.getAllChambres());
		
		return "index";
	}


	 @GetMapping("navbarUs")
	    public String navbar() {
	        return "navbar";
	    }
	 @GetMapping("navbarser")
	    public String navbaruser() {
	        return "navbaruser";
	    }
	 @GetMapping("/")
		public String viewindexPage(Model model) {
			model.addAttribute("listChambres",chambreService.getAllChambres());
			return "indexuser";
		}
	    @GetMapping("/about")
	    public String about() {
	        return "aboutUs"; // This corresponds to aboutUs.html in the templates folder
	    }
	 @GetMapping("/chambre/{id}")
	 public String viewChambreDetails(@PathVariable("id") Long id, Model model) {
	     chambre chambre = chambreService.getChambreById(id);
	     model.addAttribute("chambre", chambre);
	     return "chambreDetail";
	 }
	 @PostMapping("/submitReservation")
	 public String submitReservation(@ModelAttribute Reservation reservation, @RequestParam("chambreId") Long chambreId) {
		
		
		     reservationService.saveReservation(reservation);
		     return "redirect:/index";
		
	 }
	   @RequestMapping(value = "/chambre/delete/{id}", method = RequestMethod.POST)
	    public String deleteChambre(@PathVariable("id") Long id) {
	        chambreService.deleteChambreById(id);
	        return "redirect:/index"; 
	    }
	   @GetMapping("/chambre/add")
	   public String showAddChambreForm(Model model) {
	       model.addAttribute("chambre", new chambre()); 
	       return "add_chambre";
	   }
	   @PostMapping("/chambre/add")
	   public String addChambre(@ModelAttribute chambre chambre) {
	       chambreService.saveChambre(chambre); 
	       return "redirect:/index"; 
	   }
	    @GetMapping("/chambre/update/{id}")
	    public String showUpdateForm(@PathVariable Long id, Model model) {
	        chambre chambre = chambreService.getChambreById(id);
	        model.addAttribute("chambre", chambre);
	        return "updateChambre";
	    }
	    
	    // Method to handle form submission and save updates
	    @PostMapping("/chambre/update")
	    public String updateChambre(@ModelAttribute("chambre") chambre chambre, RedirectAttributes redirectAttributes) {
	        chambreService.updateChambre(chambre); // Ensure this method updates the chambre
	        redirectAttributes.addFlashAttribute("successMessage", "Chambre updated successfully!");
	        return "redirect:/index";
	    }
}
