/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.service;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.tutev.envanterys.entity.SKart;
import org.tutev.envanterys.TDbException;

/**
 *
 * @author Tütev
 */
public class SkartService implements ServiceBase<SKart> {

    @Override
    public SKart save(SKart entity) throws TDbException {
        if (entity.getKod() != null && entity.getKod().equals("")) {
            throw new TDbException("Kod Boş olmamalıdır.");
        }

        if (entity.getTanim() != null && entity.getTanim().equals("")) {
            throw new TDbException("Tanim Boş olmamalıdır.");
        }

        Session session = THibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(entity);
        t.commit();
        session.close();

        return entity;
    }

    @Override
    public List<SKart> getAll() {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(SKart.class);
        criteria.add(Restrictions.ne("tanim", ""));
        return (List<SKart>) criteria.list();
    }

    @Override
    public Boolean update(SKart entity) {
        if (entity.getKod() != null && entity.getKod().equals("")) {
            new TDbException("Kod Boş olmamalıdır.");
        }

        if (entity.getTanim() != null && entity.getTanim().equals("")) {
            new TDbException("Tanim Boş olmamalıdır.");
        }

        Session session = THibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
        session.close();

        return true;
    }

    @Override
    public Boolean delete(SKart entity) {

        Session session = THibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(entity);
        t.commit();
        session.close();

        return true;
    }

    @Override
    public SKart getById(Long id) {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(SKart.class);
        criteria.add(Restrictions.eq("id", id));
        return (SKart) criteria.uniqueResult();
    }

}
