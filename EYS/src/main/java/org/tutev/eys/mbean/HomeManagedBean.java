package org.tutev.eys.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Kisi;
import org.tutev.envanterys.service.KisiService;

@ManagedBean(name = "homeMB")
@ViewScoped
public class HomeManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8737443963339782355L;

	@ManagedProperty(value = "#{kisiService}")
	private KisiService kisiService;
	private List<Kisi> liste;
	private Kisi kisi;

	@PostConstruct
	private void init() {
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		liste = kisiService.getAll();
	}
	
	public void kaydet() {
		try {
			kisiService.save(kisi);
			liste=kisiService.getAll();
			kisi=new Kisi();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Kay�t Ba�ar�l�", "Ki�i Kaydedildi") );
		} catch (TDbException e) {			
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Hata",  e.getMessage()) );
			e.printStackTrace();
		}
	}

	public void sil(Long id) {
		Kisi silinecek =kisiService.getById(id);
		kisiService.delete(silinecek);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Silme", "Kişi Silindi") );
		liste=kisiService.getAll();
	}
	
	public List<Kisi> getListe() {
		return liste;
	}

	public void setKisiService(KisiService kisiService) {
		this.kisiService = kisiService;
	}
	
	public Kisi getKisi() {
		if(kisi==null){
			kisi=new Kisi();
		}
		return kisi;
	}
	
	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}

}
