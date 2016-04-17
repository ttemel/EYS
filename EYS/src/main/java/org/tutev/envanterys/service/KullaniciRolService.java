/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.KullaniciRol;
import org.tutev.envanterys.entity.Rol;

/**
 *
 * @author Hoca
 */
@Service
public class KullaniciRolService implements ServiceBase<KullaniciRol> {
	@Autowired
	private transient BaseService baseService;
	
    @Override
    public KullaniciRol save(KullaniciRol entity) throws TDbException {
        if (entity.getKullanici() == null) {
            throw new TDbException("Kullanici Boş olmamalıdır.");
        }

        if (entity.getRol() == null) {
            throw new TDbException("Rol Boş olmamalıdır.");
        }

        return (KullaniciRol) baseService.save(entity);
    }

    public KullaniciRol save(KullaniciRol entity, List<Rol> list) throws TDbException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param userId Aktif Kullanıcının Id Bilgisi
     * @return İlgili Kullanıcıya Ait Roller
     */
    @SuppressWarnings("unchecked")
	public List<KullaniciRol> getAllByUserId(Long userId) {

        Criteria criteria = baseService.getSession().createCriteria(KullaniciRol.class);
        criteria.add(Restrictions.eq("kullanici.id", userId));
        return (List<KullaniciRol>) criteria.list();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<KullaniciRol> getAll() {
    	return baseService.getAll(KullaniciRol.class);
    }

    @Override
    public KullaniciRol update(KullaniciRol entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(KullaniciRol entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KullaniciRol getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
	public List<Rol> getAllRol() {
        Criteria criteria = baseService.getSession().createCriteria(Rol.class);
        return (List<Rol>) criteria.list();
    }

}
