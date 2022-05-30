package com.ahmed.enseignants.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Enseignant {
	
     	@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	    private Long idEnseignant;
     	@NotNull
     	@Size (min = 4,max = 40)
	    private String nomEnseignant ;
     	@Min(value = 10)
     	@Max(value = 10000)
	    private double salaireEnseignant ;
	    @Temporal(TemporalType.DATE)
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @PastOrPresent
	    private Date dateEmbauche;
	    
	    @ManyToOne//plusieur produit que avoir une meme produit
	    private Specilate specilate;
	    
	    
		
		public Enseignant() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Enseignant(String nomEnseignant, double salaireEnseignant, Date dateEmbauche,Specilate spe ) {
			super();
			this.nomEnseignant = nomEnseignant;
			this.salaireEnseignant = salaireEnseignant;
			this.dateEmbauche = dateEmbauche;
			this.setSpecilate(spe);
			
		} 
		public Long getIdEnseignant() {
			return idEnseignant;
		}
		public void setIdEnseignant(Long idEnseignant) {
			this.idEnseignant = idEnseignant;
		}
		public String getNomEnseignant() {
			return nomEnseignant;
		}
		public void setNomEnseignant(String nomEnseignant) {
			this.nomEnseignant = nomEnseignant;
		}
		public double getSalaireEnseignant() {
			return salaireEnseignant;
		}
		public void setSalaireEnseignant(double salaireEnseignant) {
			this.salaireEnseignant = salaireEnseignant;
		}
		public Date getDateEmbauche() {
			return dateEmbauche;
		}
		public void setDateEmbauche(Date dateEmbauche) {
			this.dateEmbauche = dateEmbauche;
		}
		
		public Specilate getSpecilate() {
			return specilate;
		}
		public void setSpecilate(Specilate specilate) {
			this.specilate = specilate;
		}
		
		
		@Override
		public String toString() {
			return "enseignant [idEnseignant=" + idEnseignant + ", nomEnseignant=" + nomEnseignant
					+ ", salaireEnseignant=" + salaireEnseignant + ", dateEmbauche=" + dateEmbauche + "]";
		}
   
		
	    
}
