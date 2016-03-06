/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Dosya;


/**
 *
 * @author mg-Win
 */
public class DosyaService implements ServiceBase<Dosya> {

    public Dosya save(Dosya entity) throws TDbException {
        if (entity.getDosya() != null && entity.getDosya().equals("")) {
            throw new TDbException("Dosya boş olmamalıdır.");
        }

   
        Session session = THibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(entity);
        t.commit();
        session.close();

        return entity;
    }

    @SuppressWarnings("unchecked")
	public List<Dosya> getAll() {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Dosya.class);
        return (List<Dosya>) criteria.list();
    }

    public Boolean update(Dosya entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Boolean delete(Dosya entity) {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(entity);
        t.commit();
        session.close();

        return true;
    }

    public Dosya getById(Long id) {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Dosya.class);
        criteria.add(Restrictions.eq("id", id));
        return (Dosya) criteria.uniqueResult();
    }

    

}
