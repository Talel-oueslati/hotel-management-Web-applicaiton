package com.exemple.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String dateArrivee;

    @Column(nullable = false)
    private String dateDepart;

    @Column(nullable = false)
    private int nombrePersonnes;

    @Column(nullable = false)
    private String typePaiement; 

    @Column(nullable = false)
    private double montantTotal;

    @ManyToMany
    @JoinTable(
        name = "reservation_chambre",
        joinColumns = @JoinColumn(name = "reservation_id"),
        inverseJoinColumns = @JoinColumn(name = "chambre_id")
    )
    private Set<chambre> chambres = new HashSet<>();

    public Reservation() {
    }

    public Reservation(Set<chambre> chambres,String dateArrivee, String dateDepart, int nombrePersonnes, String typePaiement, double montantTotal) {
        this.dateArrivee = dateArrivee;
        this.dateDepart = dateDepart;
        this.nombrePersonnes = nombrePersonnes;
        this.typePaiement = typePaiement;
        this.montantTotal = montantTotal;
    	this.chambres = chambres;
    }




		public Set<chambre> getChambres() {
		return chambres;
	}

	public void setChambres(Set<chambre> chambres) {
		this.chambres = chambres;
	}

		public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getDateArrivee() {
	        return dateArrivee;
	    }

	    public void setDateArrivee(String dateArrivee) {
	        this.dateArrivee = dateArrivee;
	    }

	    public String getDateDepart() {
	        return dateDepart;
	    }

	    public void setDateDepart(String dateDepart) {
	        this.dateDepart = dateDepart;
	    }

	    public int getNombrePersonnes() {
	        return nombrePersonnes;
	    }

	    public void setNombrePersonnes(int nombrePersonnes) {
	        this.nombrePersonnes = nombrePersonnes;
	    }

	    public String getTypePaiement() {
	        return typePaiement;
	    }

	    public void setTypePaiement(String typePaiement) {
	        this.typePaiement = typePaiement;
	    }

	    public double getMontantTotal() {
	        return montantTotal;
	    }

	    public void setMontantTotal(double montantTotal) {
	        this.montantTotal = montantTotal;
	    }
}

