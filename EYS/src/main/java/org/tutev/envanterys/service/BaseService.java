package org.tutev.envanterys.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("baseService")
public class BaseService {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation=Propagation.REQUIRED)
	public Object save(Object o) {
		getSession().save(o);
		return o;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Object update(Object o) {
		getSession().update(o);
		return o;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(Object o) {
		getSession().delete(o);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public Object getById(Class cls, Long id) {
		Criteria criteria = getSession().createCriteria(cls);
		criteria.add(Restrictions.idEq(id));
		return criteria.uniqueResult();
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List getAll(Class cls) {
		Criteria criteria = getSession().createCriteria(cls);
		return criteria.list();

	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
