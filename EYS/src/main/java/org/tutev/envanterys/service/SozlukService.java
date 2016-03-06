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
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Kisi;
import org.tutev.envanterys.entity.SKart;
import org.tutev.envanterys.entity.Sozluk;

/**
 *
 * @author takatas
 */
public class SozlukService implements ServiceBase<Sozluk> {

    @Override
    public Sozluk save(Sozluk entity) throws TDbException {
//        if (entity.getId()!= null && entity.getId().equals("")) {
//            throw new TDbException("ID Boş Olamaz"); //To change body of generated methods, choose Tools | Templates.
//        }
        if (entity.getKod() != null && entity.getKod().equals("")) {
            throw new TDbException("Kod Boş Olamaz"); //To change body of generated methods, choose Tools | Templates.
        }
        if (entity.getTanim() != null && entity.getTanim().equals("")) {
            throw new TDbException("Tanım Boş Olamaz"); //To change body of generated methods, choose Tools | Templates.
        }
        if (entity.getTip() != null && entity.getTip().equals("")) {
            throw new TDbException("Tip Boş Olamaz"); //To change body of generated methods, choose Tools | Templates.
        }

        Session session = THibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(entity);
        t.commit();
        session.close();

        return entity;
    }

    @Override
    public List<Sozluk> getAll() {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Sozluk.class);
        return (List<Sozluk>) criteria.list();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean update(Sozluk entity) {
        if (entity.getKod() != null && (entity.getKod().equals(""))) {
            new TDbException("Kod Boş Olamaz."); //To change body of generated methods, choose Tools | Templates.
        }

        if (entity.getTanim() != null && (entity.getTanim().equals(""))) {
            new TDbException("Kod Boş Olamaz.");
        }

        Session session = THibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
        session.close();

        return true;

    }

    @Override
    public Boolean delete(Sozluk entity) {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(entity);
        t.commit();
        session.close();

        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sozluk getById(Long id) {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Sozluk.class);
        criteria.add(Restrictions.eq("id", id)); // Restrictions ile listeye sadece id gelmesi sağlanıyor.
        return (Sozluk) criteria.uniqueResult();
    }

    public void deleteByKod(String kod) {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Sozluk.class);
        criteria.add(Restrictions.eq("kod", kod)); // Restrictions ile listeye sadece id gelmesi sağlanıyor.
        Sozluk sz = (Sozluk) criteria.uniqueResult();
        delete(sz);
    }
}
