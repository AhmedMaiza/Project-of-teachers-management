package com.ahmed.enseignants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ahmed.enseignants.entities.Enseignant;
import com.ahmed.enseignants.entities.Specilate;
import com.ahmed.enseignants.repos.EnseignantRepository;


@Service
public class EnseignantServiceImpl implements EnseignantService{

	@Autowired
	EnseignantRepository enseignantRepository;
	
	@Override
	public Enseignant saveEnseignant(Enseignant e) {
	
		return enseignantRepository.save(e);
	}

	@Override
	public Enseignant updateEnseignant(Enseignant e) {
		return enseignantRepository.save(e);
	}

	@Override
	public void deleteEnseignant(Enseignant e) {
		enseignantRepository.delete(e);
	}

	@Override
	public void deleteEnseignantById(Long id) {
		enseignantRepository.deleteById(id);
	}

	@Override
	public Enseignant getEnseignant(Long id) {
		return enseignantRepository.findById(id).get();
	}

	@Override
	public List<Enseignant> getAllEnseignants() {
		return enseignantRepository.findAll();
	}

	@Override
	public List<Enseignant> findByNomEnseignant(String nom) {
		return enseignantRepository.findByNomEnseignant(nom);
	}

	@Override
	public List<Enseignant> findByNomEnseignantContains(String nom) {
		return enseignantRepository.findByNomEnseignantContains(nom);
	}

	@Override
	public List<Enseignant> findByOrderByNomEnseignantAsc() {
		return enseignantRepository.findByOrderByNomEnseignantAsc();
	}

	@Override
	public List<Enseignant> findBySpecilate(Specilate specilate) {
		return enseignantRepository.findBySpecilate(specilate);
	}

	@Override
	public List<Enseignant> findByNomSalaire(String nom, Double salaire) {
		return enseignantRepository.findByNomSalaire(nom,salaire);
	}

	@Override
	public List<Enseignant> findBySpecilateIdSpe(Long id) {
		return enseignantRepository.findBySpecilateIdSpe(id);
	}

	@Override
	public List<Enseignant> trierEnseignantsNomsSalaire() {
		return  enseignantRepository.trierEnseignantsNomsSalaire();
	}
	
	@Override
	public Page<Enseignant> getAllEnseignantsParPage(int page, int size) {
	return enseignantRepository.findAll(PageRequest.of(page, size));
	}
	


}
