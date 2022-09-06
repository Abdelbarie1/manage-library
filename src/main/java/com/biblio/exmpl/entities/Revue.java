package com.biblio.exmpl.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@DiscriminatorValue("Revue")
public class Revue extends Documents{
	private int anneepub;
}
