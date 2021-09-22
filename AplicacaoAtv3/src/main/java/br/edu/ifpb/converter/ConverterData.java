package br.edu.ifpb.converter;



import java.time.LocalDate;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;



@FacesConverter(value = "converter.data", forClass=LocalDate.class)
public class ConverterData implements Converter { 

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
         if(string == null) return null;
            LocalDate data = LocalDate.of(
                Integer.parseInt(string.substring(0, 4)), //ano
                Integer.parseInt(string.substring(5, 7)), //mês
                Integer.parseInt(string.substring(8, 10)) //dia
        );
        return data;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        
        if (t == null) return null;
        
        LocalDate date = (LocalDate) t;
        
        return date.getYear() + "/" + date.getMonthValue() + "/" + date.getDayOfMonth();
        
        
        
        
    }

  
    
}
