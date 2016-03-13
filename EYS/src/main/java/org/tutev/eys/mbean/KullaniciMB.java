package org.tutev.eys.mbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Kisi;
import org.tutev.envanterys.entity.Kullanici;
import org.tutev.envanterys.framework.PageModel;
import org.tutev.envanterys.service.KisiService;
import org.tutev.envanterys.service.KullaniciService;

@ManagedBean(name="kullaniciMB")
@ViewScoped
public class KullaniciMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{kullaniciService}")
	private KullaniciService kullaniciService;
	
	public KullaniciService getKullaniciService() {
		return kullaniciService;
	}

	public void setKullaniciService(KullaniciService kullaniciService) {
		this.kullaniciService = kullaniciService;
	}

	public void setLazy(LazyDataModel<Kullanici> lazy) {
		this.lazy = lazy;
	}

	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}



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

	public void setKisiService(KisiService kisiService) {
		this.kullaniciService = kullaniciService;
	}
	
	public Kullanici getKullanici() {
		if(kullanici==null){
			kullanici=new Kullanici();
		}
		return kullanici;
	}
	
	public void setKullanic(Kullanici kullanici) {
		this.kullanici = kullanici;
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
			
		};
	}
	
	
	
	public LazyDataModel<Kullanici> getLazy() {
		return lazy;
	}
}
