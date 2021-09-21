/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.jsf;

import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.infra.Bandas;
import java.io.Serializable;
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

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
    
    
    
}
