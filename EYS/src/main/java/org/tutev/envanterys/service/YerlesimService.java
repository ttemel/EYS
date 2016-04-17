package org.tutev.envanterys.service;

import java.util.List;
import java.util.Map;



import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Yerlesim;
import org.tutev.envanterys.framework.PageModel;

/**
 * 
 * @author Ensari Malikanesi
 **/
@Service
public class YerlesimService implements ServiceBase<Yerlesim> {


	@Autowired
	private transient BaseService baseService;
	
	/**
	 * 
	 */

	@Override
	public Yerlesim save(Yerlesim entity) throws TDbException {

		if (entity.getKod() != null && entity.getKod().equals("")) {
			throw new TDbException("Yerleşim Kod Alanı Boş Olamaz!"); 
		}
		if (entity.getTanim() != null && entity.getTanim().equals("")) {
			throw new TDbException("Yerleşim Tanım Alanı Boş Olamaz!"); 
		}
		return (Yerlesim) baseService.save(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Yerlesim> getAll() {
		return baseService.getAll(Yerlesim.class);
	}

	@Override
	public Yerlesim update(Yerlesim entity) {
		if (entity.getKod() != null && entity.getKod().equals("")) {
			new TDbException("Yerleşim Kodu Boş Olamaz!"); 
		}
		if (entity.getTanim() != null && entity.getTanim().equals("")) {
			new TDbException("Yerleşim tanımı Boş Olamaz!");
		}
		return (Yerlesim) baseService.update(entity);
	}

	@Override
	public Boolean delete(Yerlesim entity) {
    	baseService.delete(entity);
		return true;
	}

	@Override
	public Yerlesim getById(Long id) {
		Criteria criteria = baseService.getSession().createCriteria(Yerlesim.class);
		criteria.add(Restrictions.eq("id", id)); // Restrictions ile listeye
													// sadece id gelmesi
													// sağlanıyor.
		return (Yerlesim) criteria.uniqueResult();
	}

	
	public PageModel getByPaging(int first, int pageSize, Map<String, Object> filters) {
		Criteria criteria = baseService.getSession().createCriteria(Yerlesim.class);

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
