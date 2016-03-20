package org.tutev.envanterys.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.envanterys.entity.Kisi;
import org.tutev.envanterys.service.KisiService;

@Controller("kisiConverter")
@Scope("request")
public class KisiConverter implements Converter {

	@Autowired
	private transient KisiService kisiService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		try {
			Kisi ret = null;

			if (value != null || value != "") {
				ret = kisiService.getById(Long.parseLong(value));
			}
			return ret;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		String str = "";
		if (value instanceof Kisi) {
			str = "" + ((Kisi) value).getId();
		}
		return str;
	}

}
