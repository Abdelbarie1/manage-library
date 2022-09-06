package com.biblio.exmpl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.biblio.exmpl.entities.Adherent;

public interface AdherentRepository extends JpaRepository<Adherent,Integer> {
	public Adherent findByCin(String cin);
	public Page<Adherent> findByCin(String cin,PageRequest pageRequest);

	
	
}
