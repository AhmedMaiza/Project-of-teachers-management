package com.ahmed.enseignants.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ahmed.enseignants.entities.Specilate;

public interface SpeService {
	List <Specilate> findAll();
	
	Specilate saveSpecilate(Specilate e);
	Specilate updateSpecilate(Specilate e);
	void deleteSpecilate(Specilate e);
	void deleteSpecilateById(Long id);
	Specilate getSpecilate(Long id);
	Page<Specilate> getAllSpecilatesParPage(int page, int size);

}
