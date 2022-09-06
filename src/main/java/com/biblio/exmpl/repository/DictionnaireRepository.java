package com.biblio.exmpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblio.exmpl.entities.Dictionnaire;

public interface DictionnaireRepository extends JpaRepository<Dictionnaire,Integer> {

}
