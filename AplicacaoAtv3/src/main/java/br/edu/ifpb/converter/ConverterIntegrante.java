
package br.edu.ifpb.converter;

import br.edu.ifpb.domain.Integrante;
import br.edu.ifpb.infra.Integrantes;
import java.time.LocalDate;
import java.time.Month;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "converter.integrante", forClass=Integrante.class)
public class ConverterIntegrante implements Converter{
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        if (string == null) return null;
          
        Integrante integrante = new Integrante(Integer.parseInt(string), "", LocalDate.of(1, 1, 1), "");
        
        return integrante;
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        
        if (t == null) return null;
        
        Integrante integrante = new Integrante((int) t, "", LocalDate.of(1, 1, 1), "");
        
        return integrante.getCpf();
        
    }

    
    
}
