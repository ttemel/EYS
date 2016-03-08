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
import org.tutev.envanterys.entity.Yerlesim;
import org.tutev.envanterys.service.KisiService;
import org.tutev.envanterys.service.YerlesimService;

@ManagedBean(name="yerlesimMB")
@ViewScoped
public class YerlesimBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2997924790472680262L;

	@ManagedProperty(value = "#{yerlesimService}")
	private YerlesimService yerlesimService;
	private List<Yerlesim> liste;
	private Yerlesim yerlesim;


	@PostConstruct
	private void init() {
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		setListe(yerlesimService.getAll());
	}

	public void kaydet() {
		try {
			yerlesimService.save(yerlesim);
			liste=yerlesimService.getAll();
			yerlesim=new Yerlesim();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Kayıt Başarlı", "Kişi Kaydedildi!") );
		} catch (TDbException e) {			
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Hata",  e.getMessage()) );
			e.printStackTrace();
		}
	}

	public void sil(Long id) {
		Yerlesim silinecek =yerlesimService.getById(id);
		yerlesimService.delete(silinecek);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Silme", "Kişi Silindi") );
		liste=yerlesimService.getAll();
	}
	
	
	
	
	
	
	public List<Yerlesim> getListe() {
		return liste;
	}


	public void setListe(List<Yerlesim> liste) {
		this.liste = liste;
	}


	public Yerlesim getYerlesim() {
		if(yerlesim==null){
			yerlesim=new Yerlesim();
		}
		return yerlesim;
	}


	public void setYerlesim(Yerlesim yerlesim) {
		this.yerlesim = yerlesim;
	}
	
	public void setYerlesimService(YerlesimService yerlesimService) {
		this.yerlesimService = yerlesimService;
	}
	
	
}

