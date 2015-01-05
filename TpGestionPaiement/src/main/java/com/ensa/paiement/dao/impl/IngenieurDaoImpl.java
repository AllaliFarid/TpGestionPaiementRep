package com.ensa.paiement.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensa.paiement.dao.itf.IngenieurDao;
import com.ensa.paiement.model.Ingenieur;
@Repository
public class IngenieurDaoImpl implements IngenieurDao {

	@Autowired
	private SessionFactory session;
	@Override
	public void add(Ingenieur ingenieur) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(ingenieur);
	}

	@Override
	public void edit(Ingenieur ingenieur) {
		// TODO Auto-generated method stub
		session.getCurrentSession().merge(ingenieur);
	}

	@Override
	public void delete(int ingenieurId) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getIngenieur(ingenieurId));
	}

	@Override
	public Ingenieur getIngenieur(int ingenieurId) {
		// TODO Auto-generated method stub
		return (Ingenieur) session.getCurrentSession().get(Ingenieur.class, ingenieurId);
	}

	@Override
	public List getAllIngenieur() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Ingenieur").list();
	}

}
