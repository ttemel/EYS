package org.tutev.envanterys.service;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Kisi;
import org.tutev.envanterys.framework.PageModel;

@ManagedBean(name = "kisiService")
@ApplicationScoped
public class KisiService implements ServiceBase<Kisi> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8290449904487069620L;

	public Kisi save(Kisi entity) throws TDbException {
		if (entity.getAd() != null && entity.getAd().equals("")) {
			throw new TDbException("Kisi 'Adı' boş olmamalıdır.");
		}

		if (entity.getSoyad() != null && entity.getSoyad().equals("")) {
			throw new TDbException("Kisi 'Soyadı' boş olmamalıdır.");
		}

		if (entity.getTcKimlikNo() != null && entity.getTcKimlikNo().equals("")) {
			throw new TDbException("Kisi 'Tc Kimlik No' boş olmamalıdır.");
		}

		if (entity.getDogumTarihi() != null
				&& entity.getDogumTarihi().equals("")) {
			throw new TDbException("Kisi 'Doğum Tarihi' boş olmamalıdır.");
		}

		if (entity.getMail() != null && entity.getMail().equals("")) {
			throw new TDbException("Kisi 'e-Mail' boş olmamalıdır.");
		}


		Session session = THibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(entity);
		t.commit();
		session.close();

		return entity;
	}

	public List<Kisi> getAll() {
		Session session = THibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kisi.class);
		return (List<Kisi>) criteria.list();
	}

	public Boolean update(Kisi entity)  throws TDbException  {
		if (entity.getAd() != null && entity.getAd().equals("")) {
			throw new TDbException("Kisi 'Adı' boş olmamalıdır.");
		}

		if (entity.getSoyad() != null && entity.getSoyad().equals("")) {
			throw new TDbException("Kisi 'Soyadı' boş olmamalıdır.");
		}

		if (entity.getTcKimlikNo() != null && entity.getTcKimlikNo().equals("")) {
			throw new TDbException("Kisi 'Tc Kimlik No' boş olmamalıdır.");
		}

		if (entity.getDogumTarihi() != null
				&& entity.getDogumTarihi().equals("")) {
			throw new TDbException("Kisi 'Doğum Tarihi' boş olmamalıdır.");
		}

		if (entity.getMail() != null && entity.getMail().equals("")) {
			throw new TDbException("Kisi 'e-Mail' boş olmamalıdır.");
		}


		Session session = THibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(entity);
		t.commit();
		session.close();
		return true;
	}

	public Boolean delete(Kisi entity) {
		Session session = THibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(entity);
		t.commit();
		session.close();

		return true;
	}

	public Kisi getById(Long id) {
		Session session = THibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kisi.class);
		criteria.add(Restrictions.eq("id", id));
		return (Kisi) criteria.uniqueResult();
	}

	public Kisi getByAd(String ad) {
		Session session = THibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kisi.class);
		criteria.add(Restrictions.eq("ad", ad));
		return (Kisi) criteria.uniqueResult();
	}

	public Kisi getBySoyad(String soyad) {
		Session session = THibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kisi.class);
		criteria.add(Restrictions.eq("soyad", soyad));
		return (Kisi) criteria.uniqueResult();
	}

	public Kisi getByTcKimlikNo(Long tcKimlikNo) {
		Session session = THibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kisi.class);
		criteria.add(Restrictions.ilike("tcKimlikNo", tcKimlikNo));
		return (Kisi) criteria.uniqueResult();
	}

	public PageModel getByPaging(int first, int pageSize, Map<String, Object> filters) {
		Session session = THibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kisi.class);

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
