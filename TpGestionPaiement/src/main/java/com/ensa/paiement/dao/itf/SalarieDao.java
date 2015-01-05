package com.ensa.paiement.dao.itf;

import java.util.List;

import com.ensa.paiement.model.Salarie;

public interface SalarieDao {
	public void add(Salarie  salarie);
	public void edit(Salarie salarie);
	public void delete(int salarieId);
	public Salarie getSalarie(int salarieId);
	public List getAllSalarie();
	public List<Salarie> getSalarieByDepartement(String departement);
}
