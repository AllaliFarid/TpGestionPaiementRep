package com.ensa.paiement.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensa.paiement.dao.itf.SalarieDao;
import com.ensa.paiement.model.Salarie;
@Repository
public class SalarieDaoImpl implements SalarieDao {

	@Autowired
	private SessionFactory session;

	@Override
	public void add(Salarie salarie) {
		session.getCurrentSession().save(salarie);
	}

	@Override
	public void edit(Salarie salarie) {
		session.getCurrentSession().merge(salarie);
	}

	@Override
	public void delete(int salarieId) {
		 session.getCurrentSession().delete(getSalarie(salarieId));
	}

	@Override
	public Salarie getSalarie(int salarieId) {
 		return  (Salarie) session.getCurrentSession().get(Salarie.class, salarieId);
	}

	@Override
	public List<Salarie> getAllSalarie() {
 		return session.getCurrentSession().createQuery("from Salarie").list();
	}

	@Override
	public List<Salarie> getSalarieByDepartement(String departement) {
		Query q=session.getCurrentSession().createQuery("from Salarie s where s.departement = :departement ");
		q.setParameter("departement",departement);
 		return q.list();
	}

}
