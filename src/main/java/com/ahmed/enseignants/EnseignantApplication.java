package com.ahmed.enseignants;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ahmed.enseignants.entities.Enseignant;
import com.ahmed.enseignants.service.EnseignantService;

@SpringBootApplication
public class EnseignantApplication implements CommandLineRunner {

	@Autowired
	EnseignantService enseignantService;
	
	public static void main(String[] args) {
		SpringApplication.run(EnseignantApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	/*enseignantService.saveEnseignant(new Enseignant("Mr Nabil", 2600.0, new Date()));
	enseignantService.saveEnseignant(new Enseignant("Mr Walid", 2800.0, new Date()));
	enseignantService.saveEnseignant(new Enseignant("Mme Amani", 900.0, new Date()));*/

}
}
