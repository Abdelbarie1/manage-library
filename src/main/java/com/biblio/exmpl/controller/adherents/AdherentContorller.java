package com.biblio.exmpl.controller.adherents;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.biblio.exmpl.entities.Adherent;
import com.biblio.exmpl.entities.Emprunt;
import com.biblio.exmpl.service.AdherentService;
import com.biblio.exmpl.service.EmpruntService;
@Controller
@RequestMapping("/adherents")
public class AdherentContorller {
	@Autowired
	private AdherentService adherentService;
	
	@Autowired
	private EmpruntService empruntService;
	
	@GetMapping("")
	public String index(Model model,@RequestParam(name = "page", defaultValue = "0") int p,
            @RequestParam(name = "size", defaultValue = "6") int s) {
		Page<Adherent>  adherents = adherentService.getAllAdherent( p, s);
		model.addAttribute("adherents", adherents.getContent());
		int[] nbrPages = new int [adherents.getTotalPages()];
		model.addAttribute("nbrPages", nbrPages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		return "/adherents/indexAdherents";
	}
	
	@GetMapping("chercher")
	public String chercher(Model model,@RequestParam(name = "cin") String cin) {
		
		Page<Adherent>  adherents = adherentService.getAdherentByCin(cin,PageRequest.of(0,1));
		model.addAttribute("adherents", adherents.getContent());
		int[] nbrPages = new int [adherents.getTotalPages()];
		model.addAttribute("nbrPages", nbrPages);
		model.addAttribute("size", 1);
		model.addAttribute("pageCourante", 0);
		return "/adherents/indexAdherents";
		
	}
	
	@GetMapping("addAdherent")
	public String addAdherent(Model model) {
		model.addAttribute("adherent",new Adherent());
		return "/adherents/addAdherent";
	}
	
	
	@GetMapping("updateAdherent")
	public String updateAdherent(Model model,String cin) {
		Adherent adherent = adherentService.getAdherentByCin(cin);
		model.addAttribute("adherent", adherent);
		return "/adherents/updateAdherent";
	}
	
	@PostMapping("saveAdherent")
	public String saveAdherent(
			@RequestParam(name = "dateNaissance", defaultValue = "1900-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1
			,@Valid Adherent adherent
			,BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return "/adherents/addAdherent";
		adherentService.saveAdherent(adherent);
		return "redirect:/adherents";
	}
	
	
	
	@GetMapping("deleteAdherent")
	public String deleteAdherent(Model model,@RequestParam(name = "id") Integer id,@RequestParam(name = "page", defaultValue = "0") int p,
            @RequestParam(name = "size", defaultValue = "6") int s) {
		adherentService.deleteAdherent(id);
		
		return "redirect:/adherents";
	}
	
	@GetMapping("consulterAdherent")
	public String consulterAdherent(Model model ,@RequestParam(name = "cin") String cin) {
		Adherent a =adherentService.getAdherentByCin(cin);
		Page<Emprunt> emprunts = empruntService.getALlEmpruntAdherent(a, 0, 4);
		model.addAttribute("emprunts", emprunts);
		model.addAttribute("adherent", a);		
		return "/adherents/consulterProfilAdherent";
	}

}
