package com.ensa.paiement.model;

// Generated Jan 4, 2015 11:02:10 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Salarie generated by hbm2java
 */
@Entity
@Table(name = "salarie", catalog = "tp1")
public class Salarie implements java.io.Serializable {

	private Integer numSalarie;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String cin;
	private Date dateEmbauche;
	private Integer indice;
	private String grade;
	private Integer nbrEnfant;
	private String departement;
	private Directeur directeur;
	private Ouvrier ouvrier;
	private Ingenieur ingenieur;
	private String fonction;

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public Salarie() {
	}

	public Salarie(String nom, String prenom, Date dateNaissance, String cin,
			Date dateEmbauche, Integer indice, String grade, Integer nbrEnfant,
			String departement, Directeur directeur, Ouvrier ouvrier,
			Ingenieur ingenieur) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.cin = cin;
		this.dateEmbauche = dateEmbauche;
		this.indice = indice;
		this.grade = grade;
		this.nbrEnfant = nbrEnfant;
		this.departement = departement;
		this.directeur = directeur;
		this.ouvrier = ouvrier;
		this.ingenieur = ingenieur;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "num_salarie", unique = true, nullable = false)
	public Integer getNumSalarie() {
		return this.numSalarie;
	}

	public void setNumSalarie(Integer numSalarie) {
		this.numSalarie = numSalarie;
	}

	@Column(name = "nom", length = 254)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", length = 254)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance", length = 19)
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Column(name = "CIN", length = 254)
	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_embauche", length = 19)
	public Date getDateEmbauche() {
		return this.dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	@Column(name = "indice")
	public Integer getIndice() {
		return this.indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	@Column(name = "grade", length = 254)
	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Column(name = "nbr_enfant")
	public Integer getNbrEnfant() {
		return this.nbrEnfant;
	}

	public void setNbrEnfant(Integer nbrEnfant) {
		this.nbrEnfant = nbrEnfant;
	}

	@Column(name = "departement", length = 254)
	public String getDepartement() {
		return this.departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "salarie")
	public Directeur getDirecteur() {
		return this.directeur;
	}

	public void setDirecteur(Directeur directeur) {
		this.directeur = directeur;
	}

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "salarie")
	public Ouvrier getOuvrier() {
		return this.ouvrier;
	}

	public void setOuvrier(Ouvrier ouvrier) {
		this.ouvrier = ouvrier;
	}

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "salarie")
	public Ingenieur getIngenieur() {
		return this.ingenieur;
	}

	public void setIngenieur(Ingenieur ingenieur) {
		this.ingenieur = ingenieur;
	}

}
