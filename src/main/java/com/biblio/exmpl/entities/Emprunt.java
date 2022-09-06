package com.biblio.exmpl.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Emprunt {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateEmprunte;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateRetour;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Adherent adherent;
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn
	private Documents document;

}
