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
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Kullanici;
import org.tutev.envanterys.framework.PageModel;

/**
 *
 * @author TÃ¼tev
 */

@Service
public class KullaniciService  {

	
	@Autowired
	private transient BaseService baseService;
	
    public Kullanici save(Kullanici entity) throws TDbException {
    	if (entity.getUsername() != null && entity.getUsername().equals("")) {
			throw new TDbException("KullanÄ±cÄ± AdÄ± boÅŸ olmamalÄ±dÄ±r.");
		}

		if (entity.getPass() != null && entity.getPass().equals("")) {
			throw new TDbException("Å�ifre boÅŸ olmamalÄ±dÄ±r.");
		}
		if (entity.getUsername()!= null && entity.getUsername().equals("")) {
			throw new TDbException("KullanÄ±cÄ± seÃ§ilmelidir.");
		}

		Md5PasswordEncoder encoder=new Md5PasswordEncoder();
		String sifrelenmisSifre = encoder.encodePassword(entity.getPass(), null);
		entity.setPass(sifrelenmisSifre);
		
		return (Kullanici) baseService.save(entity);

		  }

    @SuppressWarnings("unchecked")
	public List<Kullanici> getAll() {
    	return baseService.getAll(Kullanici.class);
    }

    public Kullanici update(Kullanici entity) throws TDbException {
    	if (entity.getUsername() != null && entity.getUsername().equals("")) {
			throw new TDbException("KullanÄ±cÄ± AdÄ± boÅŸ olmamalÄ±dÄ±r.");
		}

		if (entity.getPass() != null && entity.getPass().equals("")) {
			throw new TDbException("Å�ifre boÅŸ olmamalÄ±dÄ±r.");
		}
		if (entity.getUsername()!= null && entity.getUsername().equals("")) {
			throw new TDbException("KullanÄ±cÄ± seÃ§ilmelidir.");
		}	
		
		Md5PasswordEncoder encoder=new Md5PasswordEncoder();
		String sifrelenmisSifre = encoder.encodePassword(entity.getPass(), null);
		entity.setPass(sifrelenmisSifre);
		
		return (Kullanici) baseService.update(entity);
    }
    public Boolean delete(Kullanici entity) {
    	baseService.delete(entity);
		return true;
    }

    public Kullanici getById(Long id) {
    	return (Kullanici) baseService.getById(Kullanici.class, id); 
		}

    @Transactional
    public Kullanici getKullaniciByUsernameAndPassword(String username) throws TDbException {
        Criteria criteria =baseService.getSession().createCriteria(Kullanici.class);
        criteria.add(Restrictions.eq("username", username));
        Kullanici kullanici = (Kullanici) criteria.uniqueResult();
        if (kullanici == null) {
            throw new TDbException("Kullanici BulunamadÄ±");
        }

        return kullanici;
    }
    
    @Transactional
    public PageModel getByPaging(int first, int pageSize, Map<String, Object> filters) {
		Criteria criteria =baseService.getSession().createCriteria(Kullanici.class);

		// FilterlarÄ± Hallet

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
