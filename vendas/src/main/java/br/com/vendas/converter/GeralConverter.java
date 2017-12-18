package br.com.vendas.converter;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named
@Stateful
@ApplicationScoped
public class GeralConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Integer counter = null;
		
		if (value != null) {
			if (! uiComponent.getAttributes().containsValue(value) ){
				counter = new Integer(uiComponent.getAttributes().size() + 1);
				uiComponent.getAttributes().put(Integer.toString(counter), value);
				return Integer.toString(counter);
			}
		}
		return null;
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 != null) {
			return arg1.getAttributes().get(arg2);
		}
		return null;
	}

}
