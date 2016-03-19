package org.tutev.envanterys.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Kisi;
import org.tutev.envanterys.framework.PageModel;

@Service("kisiService")
public class KisiService {
	
	@Autowired
	private transient BaseService baseService;


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

		return (Kisi) baseService.save(entity);
	}

	public List<Kisi> getAll() {
		return baseService.getAll(Kisi.class);
	}

	public Kisi update(Kisi entity)  throws TDbException  {
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

		return (Kisi) baseService.update(entity);
	}

	public Boolean delete(Kisi entity) {
		baseService.delete(entity);
		return true;
	}

	public Kisi getById(Long id) {
		return (Kisi) baseService.getById(Kisi.class, id);
	}

	@Transactional
	public PageModel getByPaging(int first, int pageSize, Map<String, Object> filters) {
		Criteria criteria  = baseService.getSession().createCriteria(Kisi.class);

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
