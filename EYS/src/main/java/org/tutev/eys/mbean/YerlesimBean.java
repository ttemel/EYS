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

import org.tutev.envanterys.entity.Yerlesim;
import org.tutev.envanterys.framework.PageModel;
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
	
	
	LazyDataModel<Yerlesim> lazy;
	private Yerlesim yerlesim;

	@PostConstruct
	private void init() {
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		listele();
	}

	public void kaydet() {
		try {
			if(yerlesim.getId() ==null  || yerlesim.getId()<1L)
				yerlesimService.save(yerlesim);
			else
				yerlesimService.update(yerlesim);
			
			listele();
			yerlesim=new Yerlesim();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Kayıt Başarlı", "Güncelleme Kaydedildi!") );
		} catch (TDbException e) {			
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Hata",  e.getMessage()) );
			e.printStackTrace();
		}
	}

	public void sil(Long id) {
		Yerlesim silinecek =yerlesimService.getById(id);
		yerlesimService.delete(silinecek);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Silme", "Kişi Silindi") );
		listele();
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
	
	

	
	public void onRowSelect(SelectEvent event) {
		this.yerlesim= (Yerlesim) event.getObject();        
	}
	
	
	private void listele() {
		lazy = new LazyDataModel<Yerlesim>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1777988557181936414L;
			
			
			@SuppressWarnings("unchecked")
			@Override
			public List<Yerlesim> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				
				PageModel mdl = yerlesimService.getByPaging(first, pageSize,filters);
				
				 lazy.setRowCount(mdl.getRowCount());
				
				return (List<Yerlesim>) mdl.getList();
			}
			
			@Override
			public Yerlesim getRowData(String rowKey) {				
				return yerlesimService.getById(Long.parseLong(rowKey));
			}
			
		};
	}
	
	public LazyDataModel<Yerlesim> getLazy() {
		return lazy;
	}
	
	
}

