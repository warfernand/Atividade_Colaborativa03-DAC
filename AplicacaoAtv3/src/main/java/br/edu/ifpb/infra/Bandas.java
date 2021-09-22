
package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.domain.Gerente;
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
    
   public List<Gerente> todosOsGerentes () {
       return manager.createQuery("FROM Gerente g", Gerente.class)
       .getResultList();
   }
    
   public List<Banda> recuperarBandasPorLocaldeOrigem(String localDeOrigem) {
       
       List<Banda> todas = manager.createQuery("FROM Banda b", Banda.class).getResultList();
       List<Banda> bandasEncontradas = new ArrayList<>();
       
       todas.stream().filter(banda -> ( banda.getLocalDeOrigem().equals(localDeOrigem) )).forEachOrdered(banda -> {
           bandasEncontradas.add(banda);
        });
       
       return bandasEncontradas;
  }
   
   public Banda recuperarBandaPorNomeFantasia(String nomeFantasia) {
       
       List<Banda> todas = manager.createQuery("FROM Banda b", Banda.class).getResultList();
       
       for ( Banda banda : todas ) {
           
           if ( banda.getNomeFantasia().equals(nomeFantasia) ) {
               return banda;
           }
           
       }
       
       return null;
       
   }
   
   
}
