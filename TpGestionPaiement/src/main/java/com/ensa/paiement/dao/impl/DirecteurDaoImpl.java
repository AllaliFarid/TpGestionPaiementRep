package com.ensa.paiement.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensa.paiement.dao.itf.DirecteurDao;
import com.ensa.paiement.model.Directeur;
@Repository
public class DirecteurDaoImpl implements DirecteurDao {

	
	@Autowired
	private SessionFactory session;
	@Override
	public void add(Directeur directeur) {
     	session.getCurrentSession().save(directeur);	
	}

	@Override
	public void edit(Directeur directeur) {
		// TODO Auto-generated method stub
		session.getCurrentSession().merge(directeur);
	}

	@Override
	public void delete(int directeurId) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getDirecteur(directeurId));
	}

	@Override
	public Directeur getDirecteur(int directeurId) {
		// TODO Auto-generated method stub
		return (Directeur) session.getCurrentSession().get(Directeur.class, directeurId);
	}

	@Override
	public List getAllDirecteur() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Directeur").list();
	}

}
