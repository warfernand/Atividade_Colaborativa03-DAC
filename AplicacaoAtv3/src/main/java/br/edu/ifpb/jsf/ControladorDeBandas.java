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
    private List<Integrante> integrantesBanda = new ArrayList<>();
    private Gerente gerente = new Gerente();
    
    @Inject
    private Bandas bandas;

    public String adicionar () {
        
        this.banda.setIntegrantes(this.integrantesBanda);
        this.banda.setGerente(this.gerente);
        
        this.bandas.salvarBanda(this.banda);
        
        this.banda = new Banda();
        this.integrantesBanda = new ArrayList<>();
        this.gerente = new Gerente();
        
        return "/Banda/list?faces-redirect=true";
        
    }
    
    public List<Gerente> listaDeGerentes() {
        return this.bandas.todosOsGerentes();
    }
    
    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    
    public List<Integrante> getIntegrantesBanda() {
        return integrantesBanda;
    }

    public void setIntegrantesBanda(List<Integrante> integrantesBanda) {
        this.integrantesBanda = integrantesBanda;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
    
    
    
    
}
