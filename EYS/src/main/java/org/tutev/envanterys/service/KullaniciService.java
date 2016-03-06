/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.service;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Kullanici;

/**
 *
 * @author Tütev
 */
public class KullaniciService implements ServiceBase<Kullanici> {

    @Override
    public Kullanici save(Kullanici entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Kullanici> getAll() {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Kullanici.class);

        return (List<Kullanici>) criteria.list();
    }

    @Override
    public Boolean update(Kullanici entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(Kullanici entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Kullanici getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
