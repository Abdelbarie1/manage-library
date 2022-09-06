package com.biblio.exmpl.controller.documents;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biblio.exmpl.entities.Adherent;
import com.biblio.exmpl.entities.Dictionnaire;
import com.biblio.exmpl.entities.Documents;
import com.biblio.exmpl.entities.Livre;
import com.biblio.exmpl.entities.Revue;
import com.biblio.exmpl.service.DocumentsService;

@Controller
@RequestMapping("/documents")
public class DocumentsController {
	@Autowired
	private DocumentsService documentsService; 
	
	@GetMapping("")
	public String index(Model model,@RequestParam(name = "page", defaultValue = "0") int p,
            @RequestParam(name = "size", defaultValue = "6") int s) {
		
		Page<Documents>  documents = documentsService.getAllDocument(p,s);
		model.addAttribute("documents", documents.getContent());
		int[] nbrPages = new int [documents.getTotalPages()];
		model.addAttribute("nbrPages", nbrPages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		return "/documents/indexDocuments";
	}
	
	@GetMapping("addLivre")
	public String addlivre(Model model) {
		model.addAttribute("document",new Livre());
		return "/documents/addLivre";
	}
	
	@GetMapping("addRevue")
	public String addrevue(Model model) {
		model.addAttribute("document",new Revue());
		return "/documents/addRevue";
	}
	
	@GetMapping("addDictionnaire")
	public String adddic(Model model) {
		model.addAttribute("document",new Dictionnaire());
		return "/documents/addDictionnaire";
	}
	
	
	@GetMapping("updateLivre")
	public String editlivre(Model model  ,@RequestParam(name = "id") Integer id) {
		Documents  livre= this.documentsService.getDocumentById(id);
		model.addAttribute("document",(Documents)livre);
		return "/documents/updateLivre";
	}
	
	@GetMapping("updateRevue")
	public String editrevue(Model model, @RequestParam(name = "id") Integer id) {
		Documents  revue= this.documentsService.getDocumentById(id);
		model.addAttribute("document",revue);
		return "/documents/updateRevue";
	}
	
	@GetMapping("updateDictionnaire")
	public String editdic(Model model ,  @RequestParam(name = "id") Integer id) {
		Documents dic=  this.documentsService.getDocumentById(id);

		model.addAttribute("document",dic);
		return "/documents/updateDictionnaire";
	}
	
	@PostMapping("addLivre")
	public String savelivre(@Valid Livre livre
			,BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return "/documents/indexDocuments";
		documentsService.saveDocument(livre);
		return "redirect:/documents";
	}
	
	@PostMapping("addRevue")
	public String saverevue(@Valid Revue revue
			,BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return "documents/indexDocuments";
		documentsService.saveDocument(revue);
		return "redirect:/documents";
	}
	
	@PostMapping("addDictionnaire")
	public String savedic(@Valid Dictionnaire dic
			,BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return "documents/indexDocuments";
		documentsService.saveDocument(dic);
		return "redirect:/documents";
	}


	@GetMapping("deleteDocument")
	public String delteDocument(@RequestParam(name="id") Integer id) {
		this.documentsService.deleteDocument(id);
		return "redirect:/documents";
	}
	
	@GetMapping("livre")
	public String livre(Model model,@RequestParam(name = "page", defaultValue = "0") int p,
            @RequestParam(name = "size", defaultValue = "6") int s) {
		Page<Livre>  documents = documentsService.getAllLivres(p,s);
		model.addAttribute("documents", documents.getContent());
		int[] nbrPages = new int [documents.getTotalPages()];
		model.addAttribute("nbrPages", nbrPages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		return "/documents/livre";
	}
	
	@GetMapping("revue")
	public String revue(Model model,@RequestParam(name = "page", defaultValue = "0") int p,
            @RequestParam(name = "size", defaultValue = "6") int s) {
		Page<Revue>  documents = documentsService.getAllRevue(p,s);
		model.addAttribute("documents", documents.getContent());
		int[] nbrPages = new int [documents.getTotalPages()];
		model.addAttribute("nbrPages", nbrPages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		return "/documents/revue";
	}
	
	@GetMapping("dictionnaire")
	public String dictionnaire(Model model,@RequestParam(name = "page", defaultValue = "0") int p,
            @RequestParam(name = "size", defaultValue = "6") int s) {
		Page<Dictionnaire>  documents = documentsService.getAllDictionnaire(p,s);
		model.addAttribute("documents", documents.getContent());
		int[] nbrPages = new int [documents.getTotalPages()];
		model.addAttribute("nbrPages", nbrPages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);	
		return "/documents/dictionnaire";
	}
	
	@GetMapping("chercher")
	public String chercher(Model model,@RequestParam(name = "id") Integer id) {
		
		Page<Documents>  documents = documentsService.getDocumentById(id,PageRequest.of(0,1));
		model.addAttribute("documents", documents.getContent());
		int[] nbrPages = new int [documents.getTotalPages()];
		model.addAttribute("nbrPages", nbrPages);
		model.addAttribute("size", 1);
		model.addAttribute("pageCourante", 0);
		return "/documents/indexDocuments";
		
	}
	
}
