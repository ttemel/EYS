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
import org.tutev.envanterys.entity.KullaniciRol;
import org.tutev.envanterys.entity.Rol;

/**
 *
 * @author Hoca
 */
public class KullaniciRolService implements ServiceBase<KullaniciRol> {

    @Override
    public KullaniciRol save(KullaniciRol entity) throws TDbException {
        if (entity.getKullanici() == null) {
            throw new TDbException("Kullanici Boş olmamalıdır.");
        }

        if (entity.getRol() == null) {
            throw new TDbException("Rol Boş olmamalıdır.");
        }

        Session session = THibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(entity);
        t.commit();
        session.close();

        return entity;
    }

    public KullaniciRol save(KullaniciRol entity, List<Rol> list) throws TDbException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param userId Aktif Kullanıcının Id Bilgisi
     * @return İlgili Kullanıcıya Ait Roller
     */
    public List<KullaniciRol> getAllByUserId(Long userId) {

        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(KullaniciRol.class);
        criteria.add(Restrictions.eq("kullanici.id", userId));
        return (List<KullaniciRol>) criteria.list();
    }

    @Override
    public List<KullaniciRol> getAll() {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(KullaniciRol.class);

        return (List<KullaniciRol>) criteria.list();
    }

    @Override
    public Boolean update(KullaniciRol entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(KullaniciRol entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KullaniciRol getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Rol> getAllRol() {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Rol.class);
        return (List<Rol>) criteria.list();
    }

}
