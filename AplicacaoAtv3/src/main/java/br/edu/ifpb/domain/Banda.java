/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author wendel
 */
@Entity
public class Banda implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    private String localDeOrigem;
    private String nomeFantasia;
    
    @OneToMany
    @JoinColumn(name = "banda_id")
    private List<Integrante> integrantes;
    @OneToOne(mappedBy = "banda")
    private Gerente gerente; 
 
    public Banda () {
        
    }

    public Banda(String localDeOrigem, String nomeFantasia, List<Integrante> integrantes, Gerente gerente) {
        this.localDeOrigem = localDeOrigem;
        this.nomeFantasia = nomeFantasia;
        this.integrantes = integrantes;
        this.gerente = gerente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
    
    public void adicionarIntegrante(Integrante integrante) {
        this.integrantes.add(integrante);
    }
    
   
    
}
