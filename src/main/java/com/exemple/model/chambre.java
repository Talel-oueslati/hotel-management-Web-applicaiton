package com.exemple.model;



import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="chambre")
public class chambre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	 private String numero;
	    
	    private String type;
	    
	    private int capacite;
	    
	    private String equipements;
	    
	    private double tarifJournalier;
	    
	    private String imageFileName;
	    private String etat;
	    

	    @ManyToMany(mappedBy = "chambres")
	    private Set<Reservation> reservations = new HashSet<>();
	    
	    public chambre() {
	    }

	    public chambre(Set<Reservation> reservations,String numero, String type, int capacite, String equipements, double tarifJournalier, String imageFileName,String etat) {
	        this.numero = numero;
	        this.etat=etat;
	        this.type = type;
	        this.capacite = capacite;
	        this.equipements = equipements;
	        this.tarifJournalier = tarifJournalier;
	        this.imageFileName=imageFileName;
	        this.reservations = reservations;
	    }
	    

	

		public Set<Reservation> getReservations() {
			return reservations;
		}

		public void setReservations(Set<Reservation> reservations) {
			this.reservations = reservations;
		}

		public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNumero() {
	        return numero;
	    }

	    public void setNumero(String numero) {
	        this.numero = numero;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public int getCapacite() {
	        return capacite;
	    }

	    public void setCapacite(int capacite) {
	        this.capacite = capacite;
	    }

	    public String getEquipements() {
	        return equipements;
	    }

	    public void setEquipements(String equipements) {
	        this.equipements = equipements;
	    }

	    public double getTarifJournalier() {
	        return tarifJournalier;
	    }

	    public void setTarifJournalier(double tarifJournalier) {
	        this.tarifJournalier = tarifJournalier;
	    }

		public String getImageFileName() {
			return imageFileName;
		}

		public void setImageFileName(String imageFileName) {
			this.imageFileName = imageFileName;
		}

		public String getEtat() {
			return etat;
		}

		public void setEtat(String etat) {
			this.etat = etat;
		}
	    
	    
	}
