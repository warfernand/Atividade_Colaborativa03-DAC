
package br.edu.ifpb.converter;

import br.edu.ifpb.domain.Gerente;
import br.edu.ifpb.infra.Gerentes;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;


@FacesConverter(value = "converter.gerente", forClass=Gerente.class)
public class ConverterGerente implements Converter {

    @Inject
    private Gerentes gerentes;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
      
        if (string == null) return null;
       
        Gerente gerente = this.gerentes.recuperarGerentePorCPf(string);
        
        return gerente;
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
       
        if (t == null) return null;
        
        Gerente gerente = (Gerente) t;
        
        return gerente.getCpf();
        
    }
    
}
