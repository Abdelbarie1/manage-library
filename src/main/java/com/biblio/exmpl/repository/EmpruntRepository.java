package com.biblio.exmpl.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.biblio.exmpl.entities.Adherent;
import com.biblio.exmpl.entities.Emprunt;

public interface EmpruntRepository extends JpaRepository<Emprunt,Integer> {
		
	public Page<Emprunt> findByAdherent(Adherent adherent, PageRequest pageRequest);
	
}
