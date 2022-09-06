 package com.biblio.exmpl;

import java.util.Date;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;

import com.biblio.exmpl.entities.Adherent;
import com.biblio.exmpl.entities.Dictionnaire;
import com.biblio.exmpl.entities.Emprunt;
import com.biblio.exmpl.entities.Livre;
import com.biblio.exmpl.entities.Revue;
import com.biblio.exmpl.service.AdherentService;
import com.biblio.exmpl.service.DocumentsService;
import com.biblio.exmpl.service.EmpruntService;

@SpringBootApplication
public class GestionBiblioApplication implements CommandLineRunner , ErrorController {
	
	@Autowired
	AdherentService adherentService;
	
	@Autowired
	DocumentsService documentsService;
	
	@Autowired
	EmpruntService empruntService;
	

	public static void main(String[] args) {
		
		SpringApplication.run(GestionBiblioApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*Tessst 
		Adherent adherent1=new Adherent();
		Adherent adherent2=new Adherent();
		Adherent adherent3=new Adherent();
		
		adherent1.setAdresse("Kenitra");
		adherent1.setCin("G737470");
		adherent1.setDateNaissance(new Date());
		adherent1.setNom("Ayouni");
		adherent1.setPrenom("Abdelbarie");
		adherent1.setId(1);
		
		adherent2.setAdresse("Casa");
		adherent2.setCin("C78972");
		adherent2.setDateNaissance(new Date());
		adherent2.setNom("Dadas");
		adherent2.setPrenom("Tarik");

		adherent3.setAdresse("Fes");
		adherent3.setCin("Cv7808");
		adherent3.setDateNaissance(new Date());
		adherent3.setNom("Gendafi");
		adherent3.setPrenom("Nousayba");
		
		Livre livre=new Livre();
		Dictionnaire dictionnaire=new Dictionnaire();
		Revue revue = new Revue();
		
		livre.setAuteur("Ahmed");
		livre.setNbrPages(300);
		livre.setPrixVente(190.00);
	
		dictionnaire.setLangue("Arabic");
		dictionnaire.setPrixVente(120.00);
		dictionnaire.setId(2);
		
		revue.setAnneepub(2014);
		revue.setPrixVente(60.00);
		
		Emprunt emprunt = new Emprunt();
		emprunt.setAdherent(adherent1);
		emprunt.setDocument(dictionnaire);
		emprunt.setDateEmprunte(new Date());
		emprunt.setDateRetour(new Date());
		
		adherentService.saveAdherent(adherent1);
		adherentService.saveAdherent(adherent2);
		adherentService.saveAdherent(adherent3);
		
		documentsService.saveDocument(revue);
		documentsService.saveDocument(dictionnaire);
		documentsService.saveDocument(livre);
		
		//System.out.println(documentsService.getAllDocuments());		
	//	System.out.println(adherentService.getAllAdherent());		
	
		//empruntService.deleteEmprunt(2);
		
	//	System.out.println(empruntService.getALlEmpruntAdherent(adherent2));		

		empruntService.saveEmprunt(emprunt);
		*/
		
		
	}
	
	

}
