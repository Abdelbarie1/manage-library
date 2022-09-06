package com.biblio.exmpl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biblio.exmpl.entities.Adherent;
import com.biblio.exmpl.entities.Emprunt;
import com.biblio.exmpl.repository.EmpruntRepository;

@Service
@Transactional
public class EmpruntService {
	
	@Autowired
	EmpruntRepository empruntRepository;
	
	@Autowired
	AdherentService adherentService;
	
	
	public Emprunt saveEmprunt(Emprunt emprunt) {		
		return this.empruntRepository.save(emprunt);
	}
	
	public Emprunt findEmpruntById(Integer id) {		
		return this.empruntRepository.findById(id).get();
	}
	
	public boolean deleteEmprunt(Integer id) {
		this.empruntRepository.deleteById(id);
		return true;
	}
	
	
	
	public List<Emprunt> getAllEmprunt(){
		return this.empruntRepository.findAll();
	}
	

	
	public Page<Emprunt> getALlEmpruntAdherent(Adherent adherent,int p,int s){
		return empruntRepository.findByAdherent(adherent,PageRequest.of(p,s));
		}

	
	public Page<Emprunt> getAllAdherent(int p,int s){
		return this.empruntRepository.findAll(PageRequest.of(p,s));
		}

}
