/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Integrante;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

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
    
    public Integrante recuperarIntegrantePorCpf(String cpf) {
        
        List<Integrante> todos = manager.createQuery("FROM Integrante t", Integrante.class).getResultList();
        
        for ( Integrante integrante : todos ) {
            
            if ( integrante.getCpf().equals(cpf) ) {
                return integrante;
            }
            
        }
        
        return null;
        
        
    }
    
    public List<Integrante> recuperarIntegrantePorDataNascimento () { //recupera integrantes nacidos entre 01/01/2000 e 20/04/2016.
     
        List<Integrante> integrantes = new ArrayList<>();
        
        integrantes = manager.createQuery("FROM Integrante i WHERE i.dataDeNascimento BETWEEN :dataInicial and :dataFinal", Integrante.class)
                .setParameter("dataInicial", LocalDate.of(2000, 1, 1))
                .setParameter("dataFinal", LocalDate.of(2016,4,20))
                .getResultList();
        
     
        return integrantes;
    }
    
}
