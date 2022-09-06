package com.biblio.exmpl.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biblio.exmpl.entities.Adherent;
import com.biblio.exmpl.entities.Dictionnaire;
import com.biblio.exmpl.entities.Documents;
import com.biblio.exmpl.entities.Livre;
import com.biblio.exmpl.entities.Revue;
import com.biblio.exmpl.repository.DictionnaireRepository;
import com.biblio.exmpl.repository.DocumentsRepository;
import com.biblio.exmpl.repository.LivreRepository;
import com.biblio.exmpl.repository.RevueRepository;

@Service
@Transactional
public class DocumentsService {
	@Autowired
	DocumentsRepository documentRepository;
	
	@Autowired
	LivreRepository livrerepository;
	
	@Autowired
	DictionnaireRepository dictionnairRepository;
	
	@Autowired
	RevueRepository  revueRepository;
	
	
	
	public Documents saveDocument(Documents document) {
		return this.documentRepository.save(document);
	}
	
	public Documents getDocumentById(Integer id) {
		return this.documentRepository.findById(id).get();
	}
	
	public Page<Documents> getDocumentById(Integer id ,PageRequest pageRequest) {
		return this.documentRepository.findById(id,pageRequest);
	}
	
	public boolean deleteDocument(Integer id) {
		this.documentRepository.deleteById(id);
		return true;
	}
	
	
	public boolean updateDocument(Documents document) {
		Documents doc  = this.dictionnairRepository.findById(document.getId()).get();
		doc.setPrixVente(document.getPrixVente());
		
		return true;
	}
	
	public Page<Documents> getAllDocument(int p,int s){
		return this.documentRepository.findAll(PageRequest.of(p,s));
		}
	
	public Page<Livre> getAllLivres(int p,int s){
		return this.livrerepository.findAll(PageRequest.of(p,s));
		}
	
	public Page<Revue> getAllRevue(int p,int s){
		return this.revueRepository.findAll(PageRequest.of(p,s));
		}
	
	public Page<Dictionnaire> getAllDictionnaire(int p,int s){
		return this.dictionnairRepository.findAll(PageRequest.of(p,s));
	}

}
