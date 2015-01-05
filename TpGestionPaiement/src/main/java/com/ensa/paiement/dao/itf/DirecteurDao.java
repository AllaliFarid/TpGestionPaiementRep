package com.ensa.paiement.dao.itf;

import java.util.List;

import com.ensa.paiement.model.Directeur;
import com.ensa.paiement.model.Salarie;
  
public interface DirecteurDao {
	public void add(Directeur  directeur);
	public void edit(Directeur directeur);
	public void delete(int directeurId);
	public Directeur getDirecteur(int directeurId);
	public List getAllDirecteur();
}
