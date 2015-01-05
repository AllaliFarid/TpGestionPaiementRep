package com.ensa.paiement.service.itf;

import java.util.List;

import com.ensa.paiement.model.Directeur;
import com.ensa.paiement.model.Ingenieur;
import com.ensa.paiement.model.Ouvrier;
import com.ensa.paiement.model.Salarie;

public interface SalarieServices {
	public void add(Salarie  salarie);
	public void edit(Salarie salarie);
	public void delete(int salarieId);
	public Salarie getSalarieById(int salarieId);
	public List<Salarie> getSalarieByDepartement(String departement);
	public List<Salarie> getAllSalarie();
	public double CalculeSalaire(Salarie salarie,int HeuresSup);
	public Directeur getDirecteur(int directeurId);
	public Ouvrier getOuvrier(int ouvrierId);
	public Ingenieur getIngenieur(int ingenieurId);
	public void deleteDirecteur(int directeurId);
	public void deleteOuvrier(int ouvrierId);
	public void deleteIngenieur(int ingenieurId);
	public void addDirecteur(Directeur directeur);
	public void addOuvrier(Ouvrier ouvrier);
	public void addIngenieur(Ingenieur ingenieur);
 }
