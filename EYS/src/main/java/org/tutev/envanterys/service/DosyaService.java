/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Dosya;
import org.tutev.envanterys.entity.Kisi;


/**
 *
 * @author mg-Win
 */
@Service
public class DosyaService implements ServiceBase<Dosya> {

	@Autowired
	private transient BaseService baseService;
	
    public Dosya save(Dosya entity) throws TDbException {
        if (entity.getDosya() != null && entity.getDosya().equals("")) {
            throw new TDbException("Dosya boş olmamalıdır.");
        }

        return (Dosya) baseService.save(entity);
    }

    @SuppressWarnings("unchecked")
	public List<Dosya> getAll() {
    	return baseService.getAll(Kisi.class);
    }

    public Dosya update(Dosya entity) {
    	return (Dosya) baseService.update(entity);
    }

    public Boolean delete(Dosya entity) {
		baseService.delete(entity);
		return true;
    }

    public Dosya getById(Long id) {
    	return (Dosya) baseService.getById(Dosya.class, id);
    }

    

}
