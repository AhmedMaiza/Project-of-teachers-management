package com.ahmed.enseignants.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ahmed.enseignants.entities.Specilate;
import com.ahmed.enseignants.repos.SepRepository;

@Service
public class SpeServiceImpl implements SpeService {
	
	@Autowired
	private SepRepository speRepository;

	@Override
	public List<Specilate> findAll() {
	
		return speRepository.findAll();
		
	}

	@Override
	public Specilate saveSpecilate(Specilate e) {
		// TODO Auto-generated method stub
		return speRepository.save(e) ;
	}

	@Override
	public Specilate updateSpecilate(Specilate e) {
		// TODO Auto-generated method stub
		return speRepository.save(e);
	}

	@Override
	public void deleteSpecilate(Specilate e) {
		speRepository.delete(e);		
	}

	@Override
	public void deleteSpecilateById(Long id) {
		speRepository.deleteById(id);		
	}

	@Override
	public Specilate getSpecilate(Long id) {
		return speRepository.findById(id).get();
	}

	

	@Override
	public Page<Specilate> getAllSpecilatesParPage(int page, int size) {
		return speRepository.findAll(PageRequest.of(page, size));
	}

}
