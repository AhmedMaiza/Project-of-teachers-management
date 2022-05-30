package com.ahmed.enseignants.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahmed.enseignants.entities.Enseignant;
import com.ahmed.enseignants.entities.Specilate;
import com.ahmed.enseignants.service.EnseignantService;
import com.ahmed.enseignants.service.SpeService;

@Controller
public class EnseignantController {

	@Autowired
	EnseignantService enseignantService;

	@Autowired
	SpeService speService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Specilate> spes = speService.findAll();
		Enseignant ensi=new Enseignant();
		Specilate spe=new Specilate();
		spe=spes.get(0);
		ensi.setSpecilate(spe);
		
		modelMap.addAttribute("enseignant", ensi);
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("specilates", spes);

		return "formEnseignant";
	}
	
	
	@RequestMapping("/search")
	public String doSearchEnseignant(@ModelAttribute("enseignantSearchFormData")Enseignant formData,Model model, @RequestParam("nomEn") String nomEn) {
		List<Enseignant> ensi=enseignantService.findByNomEnseignantContains(nomEn);
		model.addAttribute("enseignants",ensi);
		return "listeEnseignants";
	}
	
	@RequestMapping("/search2")
	public String doSearchEnseignant1(@ModelAttribute("enseignantSearchFormData")Enseignant formData,Model modelMap, @RequestParam("s") Long s) {
		List<Specilate> spes = speService.findAll();
		modelMap.addAttribute("specilates", spes);
		
		List<Enseignant> ensi=enseignantService.findBySpecilateIdSpe(s);
		modelMap.addAttribute("enseignants",ensi);

		return "listeEnseignants";
	}


	@RequestMapping("/saveEnseignant")
	public String saveEnseignant(@Valid Enseignant enseignant,
			 BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) return "formEnseignant";
	 enseignantService.saveEnseignant(enseignant);
	 return "redirect:/ListeEnseignants";
	}

	@RequestMapping("/ListeEnseignants")
	public String listeEnseignants(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Enseignant> ensi = enseignantService.getAllEnseignantsParPage(page, size);
		
		List<Specilate> spes = speService.findAll();
		modelMap.addAttribute("specilates", spes);
		
		modelMap.addAttribute("enseignants", ensi);
		modelMap.addAttribute("pages", new int[ensi.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeEnseignants";
	}

	@RequestMapping("/supprimerEnseignant")
	public String supprimerEnseignant(@RequestParam("id") Long id, ModelMap modelMap,

		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "2") int size) {

		enseignantService.deleteEnseignantById(id);
		Page<Enseignant> ensi = enseignantService.getAllEnseignantsParPage(page,
				size);
		modelMap.addAttribute("enseignants", ensi);
		modelMap.addAttribute("pages", new int[ensi.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeEnseignants";
	}

	@RequestMapping("/modifierEnseignant")
	public String editerEnseignant(@RequestParam("id") Long id, ModelMap modelMap) {
		
		Enseignant e = enseignantService.getEnseignant(id);
		List<Specilate> spes = speService.findAll();
		modelMap.addAttribute("enseignant", e);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("specilates", spes);


		return "formEnseignant";
	}

	@RequestMapping("/updateEnseignant")
	public String updateProduit(@ModelAttribute("enseignant") Enseignant enseignant, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateEmbauche = dateformat.parse(String.valueOf(date));
		enseignant.setDateEmbauche(dateEmbauche);

		enseignantService.updateEnseignant(enseignant);
		List<Enseignant> ensi = enseignantService.getAllEnseignants();
		modelMap.addAttribute("enseignants", ensi);
		return "listeEnseignants";
	}

}
