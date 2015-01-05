package com.ensa.paiement.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensa.paiement.dao.itf.OuvrierDao;
import com.ensa.paiement.model.Ouvrier;
@Repository
public class OuvrierDaoImpl implements OuvrierDao {

	@Autowired
	private SessionFactory session;
	@Override
	public void add(Ouvrier ouvrier) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(ouvrier);
	}

	@Override
	public void edit(Ouvrier ouvrier) {
		// TODO Auto-generated method stub
		session.getCurrentSession().merge(ouvrier);
	}

	@Override
	public void delete(int ouvrierId) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getOuvrier(ouvrierId));
	}

	@Override
	public Ouvrier getOuvrier(int ouvrierId) {
		// TODO Auto-generated method stub
		return (Ouvrier) session.getCurrentSession().get(Ouvrier.class, ouvrierId);
	}

	@Override
	public List getAllOuvrier() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Ouvrier").list();
	}

}
