package com.ahmed.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ahmed.enseignants.entities.Enseignant;
import com.ahmed.enseignants.entities.Specilate;
import com.ahmed.enseignants.repos.EnseignantRepository;

@SpringBootTest
class EnseignantApplicationTests {

	@Autowired
	private EnseignantRepository enseignantRepository;

	
	@Test
	public void testfindByNomEnseignant() {
		List<Enseignant> ensi=enseignantRepository.findByNomEnseignant("Sonia grj");
		System.out.println(ensi);
	}
	
	@Test
	public void testfindByNomSalaire(){
	List<Enseignant> ensi = enseignantRepository.findByNomSalaire("Sonia grj", 2200.5);
	for (Enseignant e : ensi)
	{
	System.out.println(e);
	}
	}
	
	@Test
	public void testfindByCategorie()
	{
	Specilate spe = new Specilate();
	spe.setIdSpe(1L);
	List<Enseignant> ensi = enseignantRepository.findBySpecilate(spe);
	for (Enseignant e : ensi)
	{
	System.out.println(e);
	}
	}
	
	@Test
	public void findBySpecilateIdSpe()
	{
	List<Enseignant> ensi = enseignantRepository.findBySpecilateIdSpe(1L);
	for (Enseignant e : ensi)
	{
	System.out.println(e);
	}
	}
	
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
	List<Enseignant> ensi = enseignantRepository.findByOrderByNomEnseignantAsc();
	for (Enseignant e : ensi)
	{
	System.out.println(e);
	}
	}
	
	@Test public void testtrierEnseignantsNomsSalaire()
	{
	List<Enseignant> ensi = enseignantRepository.trierEnseignantsNomsSalaire();
	for (Enseignant e : ensi)
	{
	System.out.println(e);
	}
	}

}
