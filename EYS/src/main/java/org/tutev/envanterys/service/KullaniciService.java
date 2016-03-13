/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.service;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Kisi;
import org.tutev.envanterys.entity.Kullanici;
import org.tutev.envanterys.framework.PageModel;

/**
 *
 * @author Tütev
 */
@ManagedBean(name = "kullaniciService")
@ApplicationScoped
public class KullaniciService implements ServiceBase<Kullanici> {

    @Override
    public Kullanici save(Kullanici entity) throws TDbException {
    	if (entity.getUsername() != null && entity.getUsername().equals("")) {
			throw new TDbException("Kullanıcı Adı boş olmamalıdır.");
		}

		if (entity.getPass() != null && entity.getPass().equals("")) {
			throw new TDbException("Şifre boş olmamalıdır.");
		}
		if (entity.getUsername()!= null && entity.getUsername().equals("")) {
			throw new TDbException("Kullanıcı seçilmelidir.");
		}


		Session session = THibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(entity);
		t.commit();
		session.close();

		return entity;    }

    @Override
    public List<Kullanici> getAll() {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Kullanici.class);

        return (List<Kullanici>) criteria.list();
    }

    @Override
    public Boolean update(Kullanici entity) throws TDbException {
    	if (entity.getUsername() != null && entity.getUsername().equals("")) {
			throw new TDbException("Kullanıcı Adı boş olmamalıdır.");
		}

		if (entity.getPass() != null && entity.getPass().equals("")) {
			throw new TDbException("Şifre boş olmamalıdır.");
		}
		if (entity.getUsername()!= null && entity.getUsername().equals("")) {
			throw new TDbException("Kullanıcı seçilmelidir.");
		}	Session session = THibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(entity);
		t.commit();
		session.close();
		return true;   
    }
    @Override
    public Boolean delete(Kullanici entity) {
    	Session session = THibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(entity);
		t.commit();
		session.close();

		return true;
    }

    @Override
    public Kullanici getById(Long id) {
    	Session session = THibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kullanici.class);
		criteria.add(Restrictions.eq("id", id));
		return (Kullanici) criteria.uniqueResult();    
		}

    public Kullanici getKullaniciByUsernameAndPassword(String username, String password) throws TDbException {
        Criteria criteria = THibernateUtil.getSessionFactory().openSession().createCriteria(Kullanici.class);
        criteria.add(Restrictions.eq("username", username));
        criteria.add(Restrictions.eq("pass", password));
        //criteria.add(Restrictions.and(Restrictions.eq("username", username),Restrictions.eq("pass", password)));
        Kullanici kullanici = (Kullanici) criteria.uniqueResult();
        if (kullanici == null) {
            throw new TDbException("Kullanici Bulunamadı");
        }

        return kullanici;
    }
    
    public PageModel getByPaging(int first, int pageSize, Map<String, Object> filters) {
		Session session = THibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kullanici.class);

		// Filterları Hallet

		PageModel model = new PageModel();
		criteria.setProjection(Projections.rowCount());
		model.setRowCount(Integer.parseInt("" + criteria.uniqueResult()));

		criteria.setProjection(null);
		criteria.setFirstResult(first);
		criteria.setMaxResults(pageSize);
		model.setList(criteria.list());
		return model;
	}
}
