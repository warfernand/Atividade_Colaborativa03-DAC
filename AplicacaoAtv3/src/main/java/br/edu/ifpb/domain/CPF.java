
package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class CPF{
    
    private static final int TAMANHO=11;
    private String numero;

    public CPF(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
    
    
}
