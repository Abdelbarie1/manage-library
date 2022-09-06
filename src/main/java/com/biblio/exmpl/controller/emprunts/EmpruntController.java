package com.biblio.exmpl.controller.emprunts;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biblio.exmpl.entities.Adherent;
import com.biblio.exmpl.entities.Documents;
import com.biblio.exmpl.entities.Emprunt;
import com.biblio.exmpl.entities.Revue;
import com.biblio.exmpl.service.AdherentService;
import com.biblio.exmpl.service.DocumentsService;
import com.biblio.exmpl.service.EmpruntService;

@Controller
@RequestMapping("/emprunts")
public class EmpruntController {
	
	@Autowired
	EmpruntService empruntService;
	
	@Autowired
	AdherentService adherentService;
	
	@Autowired
	DocumentsService documentService;
	
	@GetMapping("")
	public String index(Model model,@RequestParam(name = "page", defaultValue = "0") int p,
            @RequestParam(name = "size", defaultValue = "6") int s) {
		Page<Emprunt>  emprunts = empruntService.getAllAdherent( p, s);
		model.addAttribute("adherents",this.adherentService.getAllAdherent(p, s).getContent());
		model.addAttribute("documents", this.documentService.getAllDocument(p, s).getContent());
		model.addAttribute("emprunts", emprunts.getContent());
		int[] nbrPages = new int [emprunts.getTotalPages()];
		model.addAttribute("nbrPages", nbrPages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		return "/emprunts/indexEmprunts";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam(name="id") Integer id) {
		this.empruntService.deleteEmprunt(id);
		return "redirect:/emprunts";
	}	
	

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("emprunt",new Emprunt());
		return "/emprunts/addEmprunt";
	}
	
	@GetMapping("update")
	public String update(Model model,@RequestParam(name="id") Integer id) {
		Emprunt  emprunt= this.empruntService.findEmpruntById(id);
		model.addAttribute("emprunt",emprunt);
		return "/emprunts/updateEmprunt";
	}
	
	@PostMapping("save")
	public String save(
			@RequestParam(name = "dateRetour", defaultValue = "1900-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1
			,@Valid Emprunt emprunt
			,@RequestParam(name = "adherent") Integer id_adherent
			,@RequestParam(name = "document") Integer id_document
			,BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return "/emprunts/AjouterEmprunt";
		Adherent adherent=this.adherentService.getAdherentById(id_adherent);
		Documents document=this.documentService.getDocumentById(id_document);
		if(adherent==null)
			throw new RuntimeException("Adhernt Introuvable check your Id");
		if(document==null)
			throw new RuntimeException("Document Introuvable check your Id");
		emprunt.setAdherent(adherent);
		emprunt.setDocument(document);
		emprunt.setDateEmprunte(new Date());
		this.empruntService.saveEmprunt(emprunt);
		return "redirect:/emprunts";
	}
	
 
}
