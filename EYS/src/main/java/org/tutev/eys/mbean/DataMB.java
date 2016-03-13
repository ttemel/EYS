package org.tutev.eys.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.tutev.envanterys.entity.Sozluk;
import org.tutev.envanterys.entity.enm.SozlukTip;
import org.tutev.envanterys.service.SozlukService;

@ManagedBean(name = "dataMB")
@ApplicationScoped
public class DataMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6725227000895597453L;

	private List<Sozluk> cinsiyetList;
	private List<Sozluk> uyrukList;

	@ManagedProperty(value="#{sozlukService}")
	private SozlukService sozlukService;

	@PostConstruct
	private void init() {
		initializeData();
	}
	
	public void initializeData(){
		cinsiyetList = sozlukService.getBySozlukTip(SozlukTip.CINSIYET);
		uyrukList = sozlukService.getBySozlukTip(SozlukTip.UYRUK);
	}

	public List<Sozluk> getCinsiyetList() {
		return cinsiyetList;
	}

	public List<Sozluk> getUyrukList() {
		return uyrukList;
	}
	
	public void setSozlukService(SozlukService sozlukService) {
		this.sozlukService = sozlukService;
	}
}
