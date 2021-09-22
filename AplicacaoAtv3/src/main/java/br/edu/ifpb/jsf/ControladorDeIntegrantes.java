
package br.edu.ifpb.jsf;

import br.edu.ifpb.domain.Gerente;
import br.edu.ifpb.domain.Integrante;
import br.edu.ifpb.infra.Gerentes;
import br.edu.ifpb.infra.Integrantes;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ControladorDeIntegrantes implements Serializable {
    
    private Integrante integrante = new Integrante();
    
    @Inject
    private Integrantes integrantes;
   
    
    public String remover(Integrante integrante) {
        this.integrantes.removerIntegrante(integrante);
        return "/Integrante/list";
    }
    
    public String editar (Integrante integrante) {
        
        this.integrante = integrante;
        return "/Integrante/edit?faces-redirect=true";
        
    }
    
    public String adicionar () {
        
        if (this.integrante.getId() > 0) { //edita
            
            this.integrantes.atualizarIntegrante(this.integrante);
            
        } else { //insere
       
            this.integrantes.adicionarIntegrante(this.integrante);
            
        }
       
        this.integrante = new Integrante();
        return "/Integrante/list?faces-redirect=true";
        
    }
    
    
    public List<Integrante> listar () {
        return this.integrantes.todosOsIntegrantes();
    }
    
    public List<Integrante> listarPorDataDeNascimento() {
        return this.integrantes.recuperarIntegrantePorDataNascimento();
    }
    
    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }


    
    
}
