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
import org.tutev.envanterys.entity.Kullanici;
import org.tutev.envanterys.framework.PageModel;

/**
 *
 * @author Tütev
 */

@Service
public class KullaniciService  {

	
	@Autowired
	private transient BaseService baseService;
	
    public Kullanici save(Kullanici entity) throws TDbException {
    	if (entity.getUsername() != null && entity.getUsername().equals("")) {
			throw new TDbException("Kullanıcı Adı boş olmamalıdır.");
		}

		if (entity.getPass() != null && entity.getPass().equals("")) {
			throw new TDbException("Şifre boş olmamalıdır.");
		}
		if (entity.getUsername()!= null && entity.getUsername().equals("")) {
			throw new TDbException("Kullanıcı seçilmelidir.");
		}


		return (Kullanici) baseService.save(entity);

		  }

    @SuppressWarnings("unchecked")
	public List<Kullanici> getAll() {
    	return baseService.getAll(Kullanici.class);
    }

    public Kullanici update(Kullanici entity) throws TDbException {
    	if (entity.getUsername() != null && entity.getUsername().equals("")) {
			throw new TDbException("Kullanıcı Adı boş olmamalıdır.");
		}

		if (entity.getPass() != null && entity.getPass().equals("")) {
			throw new TDbException("Şifre boş olmamalıdır.");
		}
		if (entity.getUsername()!= null && entity.getUsername().equals("")) {
			throw new TDbException("Kullanıcı seçilmelidir.");
		}	
		
		return (Kullanici) baseService.update(entity);
    }
    public Boolean delete(Kullanici entity) {
    	baseService.delete(entity);
		return true;
    }

    public Kullanici getById(Long id) {
    	return (Kullanici) baseService.getById(Kullanici.class, id); 
		}

    public Kullanici getKullaniciByUsernameAndPassword(String username, String password) throws TDbException {
        Criteria criteria =baseService.getSession().createCriteria(Kullanici.class);
        criteria.add(Restrictions.eq("username", username));
        criteria.add(Restrictions.eq("pass", password));
        Kullanici kullanici = (Kullanici) criteria.uniqueResult();
        if (kullanici == null) {
            throw new TDbException("Kullanici Bulunamadı");
        }

        return kullanici;
    }
    
    @Transactional
    public PageModel getByPaging(int first, int pageSize, Map<String, Object> filters) {
		Criteria criteria =baseService.getSession().createCriteria(Kullanici.class);

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
