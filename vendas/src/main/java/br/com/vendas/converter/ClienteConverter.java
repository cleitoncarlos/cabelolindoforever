package br.com.vendas.converter;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import br.com.vendas.entity.Cliente;
import br.com.vendas.entity.Produto;

@Named
@Stateful
@ApplicationScoped
public class ClienteConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;

	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		if (arg2 != null && !arg2.isEmpty()) {
            return (Cliente) arg1.getAttributes().get(arg2);
        }
        return null;
    }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		if(arg2 instanceof Cliente) {
			Cliente entity= (Cliente) arg2;
            if (entity != null && entity instanceof Cliente && entity.getCodigo() != null) {
            	arg1.getAttributes().put( entity.getCodigo().toString(), entity);
                return entity.getCodigo().toString();
            }
        }
        return "";
    }	

}
