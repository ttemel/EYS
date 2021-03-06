package org.tutev.eys.mbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Kisi;
import org.tutev.envanterys.framework.PageModel;
import org.tutev.envanterys.service.KisiService;

//@ManagedBean(name="kisiMB")
//@ViewScoped

@Controller("kisiController")
@Scope(value="request")
public class KisiController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3421343394633338633L;
	
	public static Logger logger=Logger.getLogger(KisiController.class);
	
	@Autowired
	private transient KisiService kisiService;

	LazyDataModel<Kisi> lazy;
	private Kisi kisi;
	
	@PostConstruct
	private void init() {
		listele();
	}
	
	public void kaydet() {
		logger.info("Kişi Kaydı Oluşturuluyor - " + kisi.toString() );
		
		try {
			if(kisi.getId() ==null  || kisi.getId()<1L)
				kisiService.save(kisi);
			else{
				kisiService.update(kisi);
				logger.info("Kişi Kaydı Güncellendi");
			}
			
			listele();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Kayıt Başarılı", "Kişi Kaydedildi") );
		} catch (TDbException e) {			
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Hata",  e.getMessage()) );
			e.printStackTrace();
			logger.error("Kişi Kaydedilirken Hata Alındı " + kisi.toString());
		}
	}
	
	public void yeni() {
		kisi=new Kisi();
	}

	public void sil(Long id) {
		Kisi silinecek =kisiService.getById(id);
		kisiService.delete(silinecek);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Silme", "Kişi Silindi") );
		listele();
	}
	
	public void havaDurumGetir() {
		GlobalWeatherSoap soap = new GlobalWeather().getGlobalWeatherSoap();
		String mesaj = soap.getCitiesByCountry("Turkey");
		System.out.println(mesaj);
	}
	
	public void onRowSelect(SelectEvent event) {
		this.kisi= (Kisi) event.getObject();    
	}


	public Kisi getKisi() {
		if (kisi == null) {
			kisi = new Kisi();

		}
		return kisi;
	}
	
	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}


	private void listele() {
		lazy = new LazyDataModel<Kisi>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1777988557181936414L;
			
			 // Filtre Temizleme oncomplete="PF('tblKisi').clearFilters()" 
			
			@SuppressWarnings("unchecked")
			@Override
			public List<Kisi> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				
				PageModel mdl = kisiService.getByPaging(first, pageSize,filters);
				
				 lazy.setRowCount(mdl.getRowCount());
				
				return (List<Kisi>) mdl.getList();
			}
			
			@Override
			public Kisi getRowData(String rowKey) {				
				return kisiService.getById(Long.parseLong(rowKey));
			}
			
		};
	}
	
	public LazyDataModel<Kisi> getLazy() {
		return lazy;
	}
}



















