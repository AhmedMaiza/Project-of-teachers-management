package com.ahmed.enseignants.controllers;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahmed.enseignants.entities.Enseignant;
import com.ahmed.enseignants.entities.Specilate;
import com.ahmed.enseignants.service.SpeService;

@Controller
public class SpecilateController {
	
	@Autowired
	SpeService speService;
	
	
	@RequestMapping("/showCreate1")
	public String showCreate(ModelMap modelMap) {
		Specilate spe=new Specilate();
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("specilate", spe);
		return "formSpecilate";
	}
	
	
	@RequestMapping("/ListeSpecilates")
	public String listeSpecilates(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Specilate> spe = speService.getAllSpecilatesParPage(page, size);
		
		
		modelMap.addAttribute("specilates", spe);
		modelMap.addAttribute("pages", new int[spe.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeSpecilates";
	}
	
	
	@RequestMapping("/saveSpecilate")
	public String saveSpecilate(@Valid Specilate specilate,
			 BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) return "formSpecilate";
	 speService.saveSpecilate(specilate);
	 return "redirect:/ListeSpecilates";
	}
	
	@RequestMapping("/supprimerSpecilate")
	public String supprimerSpecilate(@RequestParam("id") Long id, ModelMap modelMap,

		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "2") int size) {

		speService.deleteSpecilateById(id);
		Page<Specilate> spe = speService.getAllSpecilatesParPage(page,
				size);
		modelMap.addAttribute("specilates", spe);
		modelMap.addAttribute("pages", new int[spe.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeSpecilates";
	}
	
	
	@RequestMapping("/modifierSpecilate")
	public String editerSpecilate(@RequestParam("id") Long id, ModelMap modelMap) {
		
		Specilate s = speService.getSpecilate(id);
		modelMap.addAttribute("specilate", s);
		modelMap.addAttribute("mode", "edit");


		return "formSpecilate";
	}

	@RequestMapping("/updateSpecilate")
	public String updateSpecilate(@ModelAttribute("specilate") Specilate specilate, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		speService.updateSpecilate(specilate);
		List<Specilate> spe = speService.findAll();
		modelMap.addAttribute("specilates", spe);
		return "listeSpecilates";
	}

}
