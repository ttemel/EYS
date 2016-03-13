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
import org.tutev.envanterys.entity.Sozluk;
import org.tutev.envanterys.entity.enm.SozlukTip;
import org.tutev.envanterys.framework.PageModel;

/**
 *
 * @author takatas
 */
@ManagedBean(name = "sozlukService")
@ApplicationScoped
public class SozlukService implements ServiceBase<Sozluk> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8222687496888735137L;
	
//	@ManagedProperty(value = "#{dataMB}")
//	private DataMB dataMB;

	@Override
    public Sozluk save(Sozluk entity) throws TDbException {
        if (entity.getKod() == null && entity.getKod().equals("")) {
            throw new TDbException("Kod Boş Olamaz"); 
        }
        if (entity.getTanim() == null && entity.getTanim().equals("")) {
            throw new TDbException("Tanım Boş Olamaz"); 
        }
        if (entity.getSozluktip() == null ) {
            throw new TDbException("Tip Boş Olamaz");
        }

        Session session = THibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(entity);
        t.commit();
//        dataMB.initializeData();
        session.close();

        return entity;
    }

    @SuppressWarnings("unchecked")
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
//        dataMB.initializeData();
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

	public PageModel getByPaging(int first, int pageSize, Map<String, Object> filters) {
		Session session = THibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Sozluk.class);

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

	@SuppressWarnings("unchecked")
	public List<Sozluk> getBySozlukTip(SozlukTip tip) {
        Session session = THibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Sozluk.class);
        criteria.add(Restrictions.eq("sozluktip", tip));
        return criteria.list();
	}
}
