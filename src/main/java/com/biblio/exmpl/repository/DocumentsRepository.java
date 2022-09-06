package com.biblio.exmpl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.biblio.exmpl.entities.Documents;

public interface DocumentsRepository extends JpaRepository<Documents,Integer> {
	public Optional<Documents> findById(Integer id);
	public Page<Documents> findById(Integer id,PageRequest pageRequest);

}
