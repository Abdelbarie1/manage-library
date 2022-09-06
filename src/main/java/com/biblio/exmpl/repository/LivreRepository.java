package com.biblio.exmpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblio.exmpl.entities.Livre;

public interface LivreRepository extends JpaRepository<Livre,Integer> {
	
	

}
