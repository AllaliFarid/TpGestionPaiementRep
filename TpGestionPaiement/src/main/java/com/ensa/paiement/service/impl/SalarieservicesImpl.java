package com.ensa.paiement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.paiement.dao.itf.DirecteurDao;
import com.ensa.paiement.dao.itf.IngenieurDao;
import com.ensa.paiement.dao.itf.OuvrierDao;
import com.ensa.paiement.dao.itf.SalarieDao;
import com.ensa.paiement.model.Directeur;
import com.ensa.paiement.model.Ingenieur;
import com.ensa.paiement.model.Ouvrier;
import com.ensa.paiement.model.Salarie;
import com.ensa.paiement.service.itf.SalarieServices;

@Service("salarieServices")
@Transactional
public class SalarieservicesImpl implements SalarieServices {

	@Autowired
	SalarieDao dao;
	@Autowired
	DirecteurDao directeurDao;
	@Autowired
	OuvrierDao ouvrierDao;
	@Autowired
	IngenieurDao ingenieurDao;

	@Override
	public void add(Salarie salarie) {
		dao.add(salarie);
	}

	@Override
	public void edit(Salarie salarie) {
		dao.edit(salarie);
	}

	@Override
	public void delete(int salarieId) {
		dao.delete(salarieId);
	}

	@Override
	public Salarie getSalarieById(int salarieId) {
		return dao.getSalarie(salarieId);
	}

	@Override
	public List<Salarie> getSalarieByDepartement(String departement) {
		return dao.getSalarieByDepartement(departement);
	}

	@Override
	public List<Salarie> getAllSalarie() {
		return dao.getAllSalarie();
	}

	@Override
	public double CalculeSalaire(Salarie salarie,int HeuresSup) {
		double brute=0, prime=0;
		salarie.setNbrEnfant(1);
		if (salarie.getDirecteur() != null) {
			brute = salarie.getIndice() * 100 + 100 * salarie.getNbrEnfant();
			prime = salarie.getIndice() * 25 + 1 * 10 + 5000;
			return (brute - 0.5 * brute) * 0.83 + prime;
		} else if (salarie.getIngenieur() != null) {
			brute = salarie.getIndice() * 64 + 100 * salarie.getNbrEnfant();
			prime = salarie.getIndice() * 15 + 1 * 10 + 2000;
			return (brute - 0.5 * brute) * 0.83 + prime;
		} else {
			prime = salarie.getIndice() * 4 + HeuresSup * 20 +1*10;
			return (brute - 0.5 * brute) * 0.83 + prime;
		}
	}

	@Override
	public Directeur getDirecteur(int directeurId) {
		// TODO Auto-generated method stub
		return directeurDao.getDirecteur(directeurId);
	}

	@Override
	public Ouvrier getOuvrier(int ouvrierId) {
		// TODO Auto-generated method stub
		return ouvrierDao.getOuvrier(ouvrierId);
	}

	@Override
	public Ingenieur getIngenieur(int ingenieurId) {
		// TODO Auto-generated method stub
		return ingenieurDao.getIngenieur(ingenieurId);
	}

	@Override
	public void deleteDirecteur(int directeurId) {
		// TODO Auto-generated method stub
		directeurDao.delete(directeurId);
	}

	@Override
	public void deleteOuvrier(int ouvrierId) {
		// TODO Auto-generated method stub
		ouvrierDao.delete(ouvrierId);
	}

	@Override
	public void deleteIngenieur(int ingenieurId) {
		// TODO Auto-generated method stub
		ingenieurDao.delete(ingenieurId);
	}

	@Override
	public void addDirecteur(Directeur directeur) {

    directeurDao.add(directeur); 		
	}

	@Override
	public void addOuvrier(Ouvrier ouvrier) {
		// TODO Auto-generated method stub
		ouvrierDao.add(ouvrier);
	}

	@Override
	public void addIngenieur(Ingenieur ingenieur) {
		// TODO Auto-generated method stub
		ingenieurDao.add(ingenieur);
	}
}
