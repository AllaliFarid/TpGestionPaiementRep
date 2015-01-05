package com.ensa.paiement.dao.itf;

import java.util.List;

import com.ensa.paiement.model.Ingenieur;

 
public interface IngenieurDao {
	public void add(Ingenieur  ingenieur);
	public void edit(Ingenieur ingenieur);
	public void delete(int ingenieurId);
	public Ingenieur getIngenieur(int ingenieurId);
	public List getAllIngenieur();
}
