package com.ensa.paiement.dao.itf;

import java.util.List;

import com.ensa.paiement.model.Ouvrier;

 
public interface OuvrierDao {
	public void add(Ouvrier  ouvrier);
	public void edit(Ouvrier ouvrier);
	public void delete(int ouvrierId);
	public Ouvrier getOuvrier(int ouvrierId);
	public List getAllOuvrier();
}
