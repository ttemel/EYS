/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Kisi;
import org.tutev.envanterys.entity.SKart;

/**
 *
 * @author Tütev
 */
@Service
public class SkartService implements ServiceBase<SKart> {

	@Autowired
	private transient BaseService baseService;
	
    @Override
    public SKart save(SKart entity) throws TDbException {
        if (entity.getKod() != null && entity.getKod().equals("")) {
            throw new TDbException("Kod Boş olmamalıdır.");
        }

        if (entity.getTanim() != null && entity.getTanim().equals("")) {
            throw new TDbException("Tanim Boş olmamalıdır.");
        }

        return (SKart) baseService.save(entity);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<SKart> getAll() {
    	return baseService.getAll(Kisi.class);
    }

    @Override
    public SKart update(SKart entity) {
        if (entity.getKod() != null && entity.getKod().equals("")) {
            new TDbException("Kod Boş olmamalıdır.");
        }

        if (entity.getTanim() != null && entity.getTanim().equals("")) {
            new TDbException("Tanim Boş olmamalıdır.");
        }

        return (SKart) baseService.update(entity);
    }

    @Override
    public Boolean delete(SKart entity) {
    	baseService.delete(entity);
		return true;
    }

    @Override
    public SKart getById(Long id) {
    	return (SKart) baseService.getById(SKart.class, id);
    }

}
