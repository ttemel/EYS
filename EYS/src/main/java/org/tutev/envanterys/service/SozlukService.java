/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Sozluk;
import org.tutev.envanterys.entity.enm.SozlukTip;
import org.tutev.envanterys.framework.PageModel;

/**
 *
 * @author takatas
 */

@Service("sozlukService")
public class SozlukService {

	@Autowired
	private transient BaseService baseService;
	
	
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

        return (Sozluk) baseService.save(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Sozluk> getAll() {
    	return baseService.getAll(Sozluk.class);
    }

    public Sozluk update(Sozluk entity) {
        if (entity.getKod() != null && (entity.getKod().equals(""))) {
            new TDbException("Kod Boş Olamaz."); //To change body of generated methods, choose Tools | Templates.
        }

        if (entity.getTanim() != null && (entity.getTanim().equals(""))) {
            new TDbException("Kod Boş Olamaz.");
        }

        return (Sozluk) baseService.update(entity);

    }

    public Boolean delete(Sozluk entity) {
    	baseService.delete(entity);
		return true;
    }

    public Sozluk getById(Long id) {
    	return (Sozluk) baseService.getById(Sozluk.class, id);
    }

	public PageModel getByPaging(int first, int pageSize, Map<String, Object> filters) {
		Criteria criteria = baseService.getSession().createCriteria(Sozluk.class);

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
	@Transactional
	public List<Sozluk> getBySozlukTip(SozlukTip tip) {
        Criteria criteria = baseService.getSession().createCriteria(Sozluk.class);
        criteria.add(Restrictions.eq("sozluktip", tip));
        return criteria.list();
	}
}
