package br.com.vendas.converter;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import br.com.vendas.entity.Produto;

@Named
@Stateful
@ApplicationScoped
public class ProdutoConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;

	/*@Override
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
	}*/
	/*@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                ThemeService service = (ThemeService) fc.getExternalContext().getApplicationMap().get("themeService");
                return service.getThemes().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }
	@Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Produto) object).getCodigo());
        }
        else {
            return null;
        }
    }   */
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		if (arg2 != null && !arg2.isEmpty()) {
            return (Produto) arg1.getAttributes().get(arg2);
        }
        return null;
    }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		if(arg2 instanceof Produto) {
			Produto entity= (Produto) arg2;
            if (entity != null && entity instanceof Produto && entity.getCodigo() != null) {
            	arg1.getAttributes().put( entity.getCodigo().toString(), entity);
                return entity.getCodigo().toString();
            }
        }
        return "";
    }	

}
