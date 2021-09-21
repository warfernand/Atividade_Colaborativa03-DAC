
package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.domain.Integrante;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author wendel
 */
@Stateless
public class Bandas {

    @PersistenceContext
    private EntityManager manager;
    
    public void salvarBanda (Banda banda) {
        
        manager.persist(banda);
        
    }
    
    public List<Banda> todasAsBandas () {
        
        return manager.createQuery("FROM Banda b", Banda.class)
                .getResultList();
        
    }
    
    public void remover (Banda banda) {
        
        manager.remove(manager.merge(banda));
        
    }
    
    public void atualizar (Banda banda) {
        
        manager.merge(banda);
        
    }
    
    public List<Integrante> recuperarIntegrantesDisponiveis (Banda banda) {
     
        List<Integrante> todos = manager.createQuery("FROM Integrante i", Integrante.class).getResultList();
        
        List<Integrante> integrantesDisponiveis = new ArrayList<>();
        
        for (Integrante integrante : todos) {
            
            if (!banda.getIntegrantes().contains(integrante)) {
                integrantesDisponiveis.add(integrante);
            }
            
        }
        
        return integrantesDisponiveis;
        
    }
    
}
