package org.tutev.envanterys.converter;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.tutev.envanterys.entity.Sozluk;
import org.tutev.envanterys.service.SozlukService;

@FacesConverter(value="sozlukConverter",forClass=Sozluk.class)
@RequestScoped
public class SozlukConverter implements Converter {

	@ManagedProperty(value = "#{sozlukService}")
	private SozlukService sozlukService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,String value) {
		Sozluk ret = null;

		if (value != null || value != "") {
			ret = sozlukService.getById(Long.parseLong(value));
		}
		return ret;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {

		String str = "";
		if (value instanceof Sozluk) {
			str = "" + ((Sozluk) value).getId();
		}
		return str;
	}
	
	public void setSozlukService(SozlukService sozlukService) {
		this.sozlukService = sozlukService;
	}

}
