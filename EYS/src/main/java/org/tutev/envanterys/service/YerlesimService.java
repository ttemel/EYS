package org.tutev.envanterys.service;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Yerlesim;

/**
 *
 * @author Ensari Malikanesi**/
@ManagedBean(name="yerlesimService")
@ApplicationScoped

public class YerlesimService implements ServiceBase<Yerlesim>{

	private static final long serialVersionUID = 3504721535678549981L;

	/**
	 * 
	 */
	
	@Override
    public Yerlesim save(Yerlesim entity) throws TDbException {

            if (entity.getKod() != null && entity.getKod().equals("")) {
            throw new TDbException("Yerleşim Kod Alanı Boş Olamaz!"); //To change body of generated methods, choose Tools | Templates.
        }
            if (entity.getTanim() != null && entity.getTanim().equals("")) {
            throw new TDbException("Yerleşim Tanım Alanı Boş Olamaz!"); //To change body of generated methods, choose Tools | Templates.
        }
        Session session = THibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(entity);
        t.commit();
        session.close();

        return entity;
    }

    @Override
    public List<Yerlesim> getAll() {

        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Yerlesim.class);
        return (List<Yerlesim>) criteria.list();

    }

    @Override
    public Boolean update(Yerlesim entity) {
        if (entity.getKod() != null && (entity.getKod().equals(""))) {
            new TDbException("Yerleşim Kodu Boş Olamaz!"); //To change body of generated methods, choose Tools | Templates.
        }

        if (entity.getTanim() != null && (entity.getTanim().equals(""))) {
            new TDbException("Yerleşim tanımı Boş Olamaz!");
        }

        Session session = THibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
        session.close();

        return true;    }

    @Override
    public Boolean delete(Yerlesim entity) {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(entity);
        t.commit();
        session.close();

        return true;    }

    @Override
    public Yerlesim getById(Long id) {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Yerlesim.class);
        criteria.add(Restrictions.eq("id", id)); // Restrictions ile listeye sadece id gelmesi sağlanıyor.
        return (Yerlesim) criteria.uniqueResult();    }

    public void deleteByKod(String kod) {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Yerlesim.class);
        criteria.add(Restrictions.eq("kod", kod)); // Restrictions ile listeye sadece id gelmesi sağlanıyor.
        Yerlesim sz = (Yerlesim) criteria.uniqueResult();
        delete(sz);    }
    
}
