package com.ahmed.enseignants.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Specilate {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSpe;
	private String nomSpe;
	private String descriptionSpe;
	
	
	@OneToMany(mappedBy="specilate")
	@JsonIgnore
	private List<Enseignant> enseignants; 
}	
	
	