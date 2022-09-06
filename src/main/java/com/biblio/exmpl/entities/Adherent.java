package com.biblio.exmpl.entities;

import java.util.Collection;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
 @NoArgsConstructor   @Getter @Setter
public class Adherent {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="Nom")
	private String nom;
	
	@Column(name="Prenom")
	private String prenom;

	@Column(name="Cin")
	private String cin;
	
	@Column(name="Adresse")
	private String adresse;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="Date_de_naissance")
	private Date dateNaissance;
	
	@OneToMany(mappedBy = "adherent",cascade=CascadeType.ALL)
	private Collection<Emprunt> emprunts;
	@Override
	public String toString() {
		return "Adherent [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", adresse=" + adresse
				+ ", dateNaissance=" + dateNaissance + "]";
	}
	
	

}
