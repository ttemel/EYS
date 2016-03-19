package org.tutev.eys.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.envanterys.entity.Sozluk;
import org.tutev.envanterys.entity.enm.SozlukTip;
import org.tutev.envanterys.service.SozlukService;

@Controller("dataMB")
@Scope("singleton") //@ApplicationScope
public class DataMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6725227000895597453L;

	private List<Sozluk> cinsiyetList;
	private List<Sozluk> uyrukList;

	@Autowired
	private transient SozlukService sozlukService;

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
