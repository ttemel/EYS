package org.tutev.eys.mbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Kisi;
import org.tutev.envanterys.entity.Kullanici;
import org.tutev.envanterys.framework.PageModel;
import org.tutev.envanterys.service.KisiService;
import org.tutev.envanterys.service.KullaniciService;

@Controller("kullaniciController")
@Scope(value="request")
public class KullaniciMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private transient KullaniciService kullaniciService;
	
	@Autowired
	private transient KisiService  kisiService;

	


	LazyDataModel<Kullanici> lazy;
	private Kullanici kullanici;
	
	@PostConstruct
	private void init() {
		listele();
	}

	public void kaydet() {
		try {
			if(kullanici.getId() ==null  || kullanici.getId()<1L)
				kullaniciService.save(kullanici);
			else
				kullaniciService.update(kullanici);
			
			listele();
			kullanici=new Kullanici();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Kayıt Başarılı", "Kişi Kaydedildi") );
		} catch (TDbException e) {			
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Hata",  e.getMessage()) );
			e.printStackTrace();
		}
	}

	public void sil(Long id) {
		Kullanici silinecek =kullaniciService.getById(id);
		kullaniciService.delete(silinecek);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Silme", "Kişi Silindi") );
		listele();
	}
	
	public void onRowSelect(SelectEvent event) {
		this.kullanici= (Kullanici) event.getObject();        
	}

	public void setKullaniciService(KullaniciService kullaniciService) {
		this.kullaniciService = kullaniciService;
	}
	
	
	private void listele() {
		lazy = new LazyDataModel<Kullanici>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1777988557181936414L;
			
			
			@SuppressWarnings("unchecked")
			@Override
			public List<Kullanici> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				
				PageModel mdl = kullaniciService.getByPaging(first, pageSize,filters);
				
				 lazy.setRowCount(mdl.getRowCount());
				
				return (List<Kullanici>) mdl.getList();
			}
			
			@Override
			public Kullanici getRowData(String rowKey) {				
				return kullaniciService.getById(Long.parseLong(rowKey));
			}
			
			
			@Override
			public Object getRowKey(Kullanici object) {
				return object.getId();
			}
			
		};
	}
	
	public List<Kisi> getKisi(String query) {
		return kisiService.getByNameOrSurname(query);
	}
	
	
	public LazyDataModel<Kullanici> getLazy() {
		return lazy;
	}
	
	public Kullanici getKullanici() {
		if(kullanici==null){
			kullanici=new Kullanici();
			kullanici.setKisi(new Kisi());
		}
		return kullanici;
	}
	
	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}
}
