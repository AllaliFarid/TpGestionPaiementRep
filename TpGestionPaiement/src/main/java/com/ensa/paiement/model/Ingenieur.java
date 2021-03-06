package com.ensa.paiement.model;

// Generated Jan 4, 2015 11:02:10 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Ingenieur generated by hbm2java
 */
@Entity
@Table(name = "ingenieur", catalog = "tp1")
public class Ingenieur implements java.io.Serializable {

	private int numSalarie;
	private Salarie salarie;

	public Ingenieur() {
	}

	public Ingenieur(Salarie salarie) {
		this.salarie = salarie;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "salarie"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "num_salarie", unique = true, nullable = false)
	public int getNumSalarie() {
		return this.numSalarie;
	}

	public void setNumSalarie(int numSalarie) {
		this.numSalarie = numSalarie;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	public Salarie getSalarie() {
		return this.salarie;
	}

	public void setSalarie(Salarie salarie) {
		this.salarie = salarie;
	}

}
