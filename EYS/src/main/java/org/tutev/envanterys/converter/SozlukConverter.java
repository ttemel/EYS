package org.tutev.envanterys.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.envanterys.entity.Sozluk;
import org.tutev.envanterys.service.SozlukService;

//@FacesConverter(value="sozlukConverter",forClass=Sozluk.class)

@Controller("sozlukConverter")
@Scope("request")
public class SozlukConverter implements Converter {

	@Autowired
	private transient SozlukService sozlukService;

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
	
}
