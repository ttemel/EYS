package org.tutev.eys.mbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "homeMB")
@SessionScoped
public class HomeManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8737443963339782355L;



	@PostConstruct
	private void init() {
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);

	}
	


}
