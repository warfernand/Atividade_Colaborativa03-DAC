
package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Gerente;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class Gerentes {
    
    @PersistenceContext
    private EntityManager manager;
    
    public void adicionarGerente(Gerente gerente) {
        
        manager.persist(gerente);
        
    }
    
    public List<Gerente> todosOsGerentes () {
        
        return manager.createQuery("FROM Gerente g", Gerente.class).getResultList();
        
 
    }
    
    public void removerGerente(Gerente gerente) {
        
        manager.remove(gerente);
        
    }
    
    public void atualizarGerente(Gerente gerente) {
        
        Gerente gerenteEncontrado = manager.find(Gerente.class, gerente.getId());
        
        gerenteEncontrado = gerente;
        
        manager.persist(gerenteEncontrado);
        
    }
    
    public Gerente recuperarGerentePorCPf(String cpf) {
        
        List<Gerente> todos = manager.createQuery("FROM Gerente g", Gerente.class).getResultList();
        
        for ( Gerente gerente : todos ) {
            
            if ( gerente.getCpf().equals(cpf) ) {
                
               return gerente;
                
            }
        
        }
        
        return null;
        
    }
    
    
}
