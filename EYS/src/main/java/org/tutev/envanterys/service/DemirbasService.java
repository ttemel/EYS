/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Demirbas;
import org.tutev.envanterys.entity.Kisi;

/**
 *
 * @author Tütev
 */
@Service
public class DemirbasService implements ServiceBase<Demirbas> {

	@Autowired
	private transient BaseService baseService;
	
    @Override
    public Demirbas save(Demirbas entity) throws TDbException{
        if (entity.getKod() != null && entity.getKod().equals("")) {
            throw new TDbException("Kod Boş olmamalıdır.");
        }

        if (entity.getTanim() != null && entity.getTanim().equals("")) {
            throw new TDbException("Tanim Boş olmamalıdır.");
        }

        return (Demirbas) baseService.save(entity);
    }

    @Override
    public List<Demirbas> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Demirbas update(Demirbas entity) {
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
