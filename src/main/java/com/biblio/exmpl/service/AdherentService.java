package com.biblio.exmpl.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biblio.exmpl.entities.Adherent;
import com.biblio.exmpl.repository.AdherentRepository;

@Service
@Transactional
public class AdherentService {
	
	@Autowired
	AdherentRepository adherentRepository;
	
	public Adherent saveAdherent(Adherent adherent) {
		
		return this.adherentRepository.save(adherent);
	}
	
	public Page<Adherent> getAllAdherent(int p,int s){
		return adherentRepository.findAll(PageRequest.of(p,s));
		}
	
	/*public List<Adherent> getAllAdherent(){
		return this.adherentRepository.findAll();
	}*/
	
	
	public Adherent getAdherentByCin(String cin) {
		return this.adherentRepository.findByCin(cin);
	}
	
	public Adherent getAdherentById(Integer id) {
		return this.adherentRepository.findById(id).get();
	}
	
	public Page<Adherent> getAdherentByCin(String cin,PageRequest pageRequest) {
		return this.adherentRepository.findByCin(cin, pageRequest);
	}
	
	public boolean  deleteAdherent(Integer l) {
		this.adherentRepository.deleteById(l);
		return true;
	}
	
	public boolean editAdherent(Adherent newAdherent) {
		Adherent adherent=adherentRepository.findByCin(newAdherent.getCin());
		adherent.setAdresse(newAdherent.getAdresse());
		adherent.setNom(newAdherent.getNom());
		adherent.setPrenom(newAdherent.getPrenom());
		return true;
	}
	
}
