/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Demirbas;

/**
 *
 * @author Tütev
 */
public class DemirbasService implements ServiceBase<Demirbas> {

    @Override
    public Demirbas save(Demirbas entity) throws TDbException{
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
    public List<Demirbas> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean update(Demirbas entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(Demirbas entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Demirbas getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
