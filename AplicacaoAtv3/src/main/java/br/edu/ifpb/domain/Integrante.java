
package br.edu.ifpb.domain;

import br.edu.ifpb.converterColumn.ConverterLocalDate;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author wendel
 */
@Entity
public class Integrante implements Serializable{
 
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @Convert(converter = ConverterLocalDate.class)
    private LocalDate dataDeNascimento;
    private String cpf;
    
    public Integrante () {
        
    }

    public Integrante(String nome, LocalDate dataDeNascimento, String cpf) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
}
