/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.converterColumn;

import br.edu.ifpb.domain.CPF;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class ConveterCPF implements AttributeConverter<CPF, String>{

    @Override
    public String convertToDatabaseColumn(CPF cpf) {
      if (cpf == null) return null;
      
      return cpf.getNumero();
    }

    @Override
    public CPF convertToEntityAttribute(String cpf) {
       
        if (cpf == null) return null;
        
        return new CPF(cpf);
        
    }
    
}
