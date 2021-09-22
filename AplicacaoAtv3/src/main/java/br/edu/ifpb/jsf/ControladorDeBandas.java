/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jsf;

import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.domain.Gerente;
import br.edu.ifpb.domain.Integrante;
import br.edu.ifpb.infra.Bandas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author wendel
 */
@Named
@SessionScoped
public class ControladorDeBandas implements Serializable {
    
    private Banda banda = new Banda();
    
    @Inject
    private Bandas bandas;
    
    public String remover (Banda banda) {
        
        this.bandas.remover(banda);
        
        return "/Banda/list";
        
    }
    
    public String editar(Banda banda) {
        
        this.banda = banda;
        
        return "/Banda/edit?faces-redirect=true";
        
    }

    public String adicionar () {
        
        if ( this.banda.getId() > 0 ) {
            
            this.bandas.atualizar(banda);
            
        } else {
            
            this.bandas.salvarBanda(this.banda);
            
        }
             
        this.banda = new Banda();
        
        return "/Banda/list?faces-redirect=true";
        
    }
    
    public List<Banda> listar () {
        return this.bandas.todasAsBandas();
    }
    
    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

  
}
