/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Integrante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author wendel
 */

@Stateless
public class Integrantes {
    
    @PersistenceContext
    private EntityManager manager;
    
    public void adicionarIntegrante(Integrante integrante) { //insere o integrante no banco
        
        manager.persist(integrante);
        
    }
    
    public List<Integrante> todosOsIntegrantes() { //lista
        
        return manager.createQuery("FROM Integrante i", Integrante.class)
                .getResultList();
        
    }
    
    public void removerIntegrante (Integrante integrante) { //remove
        
        manager.remove(manager.merge(integrante));
        
        
    }
    
    public void atualizarIntegrante (Integrante integrante) { //atual
        
      manager.merge(integrante);
        
    }
    
}
