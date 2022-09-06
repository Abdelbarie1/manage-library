package com.biblio.exmpl.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor  @ToString
@DiscriminatorValue("Livre")

public class Livre extends Documents {
	private String auteur;
	private int nbrPages;
}
