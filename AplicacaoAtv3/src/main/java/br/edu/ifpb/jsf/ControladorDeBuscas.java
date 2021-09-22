
package br.edu.ifpb.jsf;

import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.domain.Gerente;
import br.edu.ifpb.domain.Integrante;
import br.edu.ifpb.infra.Bandas;
import br.edu.ifpb.infra.Gerentes;
import br.edu.ifpb.infra.Integrantes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class ControladorDeBuscas implements Serializable {
 
    private String cpf = "";
    private String localDeOrigem = "";
    private String nomeFantasia = "";
    private List<Integrante> integrantesBanda = new ArrayList<>();
    
    
    private String resultadoDaBusca = "";
    private String BandaEcontrada = "";
    private List<Banda> bandasLocalOrigem = new ArrayList<>();
    
    @Inject
    private Integrantes integrantes;
    
    @Inject
    private Gerentes gerentes;
    
    @Inject
    private Bandas bandas;
    
    
    public String buscar () { //Realiza a busca por CPF
        
        Integrante i = this.integrantes.recuperarIntegrantePorCpf(this.cpf);
        
        if ( i != null ) {
            
            resultadoDaBusca = "Tipo: Integrante" + 
                    " Id: " + i.getId() +  
                    " Nome: " + i.getNome() + 
                    " Data de Nascimento: " + i.getDataDeNascimento() + 
                    " CPF: " + i.getCpf();
            
        } else {
            
            Gerente gerente = this.gerentes.recuperarGerentePorCPf(this.cpf);
            
            
            if ( gerente != null ) {
                
                resultadoDaBusca = "Tipo: Gerente" + 
                        " Id " + gerente.getId() + 
                        " Nome: " + gerente.getNome() + 
                        " Banda: " + ( (gerente.getBanda() != null) ? gerente.getBanda().getNomeFantasia() : "Nenhuma" ) + 
                        " Email: " + gerente.getEmail() + 
                        " CPF: " + gerente.getCpf();
                
            } else {
                
                resultadoDaBusca = "Desculpe, mas não existe nenhuma pessoa cadastrada no sistema com este CPF";
                
            }
            
        }
        
        this.cpf = "";
        
        return "search";
        
        
    }
    
    
    public String buscarPorLocalDeOrigem () { //Busca por Local De Origem
        
        this.bandasLocalOrigem = this.bandas.recuperarBandasPorLocaldeOrigem(this.localDeOrigem);
     
        this.localDeOrigem = "";
        
        return "/Banda/search";
        
    }
    
    public String buscarPorNomeFantasia() {
        
        Banda banda = this.bandas.recuperarBandaPorNomeFantasia(this.nomeFantasia);
        
        if ( banda != null ) {
            
            this.integrantesBanda = banda.getIntegrantes();
            this.BandaEcontrada = "Id: " + banda.getId() +
                                    "Local De Origem: " + banda.getLocalDeOrigem() + 
                                    "Nome Fantasia: " + banda.getNomeFantasia();
            
        } else{
            
            this.integrantesBanda = new ArrayList<>();
            this.BandaEcontrada = "Desculpe, mas não existe nenhuma banda cadastrada com esse nome";
            
        }
            
        this.nomeFantasia = "";
        
        return "/Banda/searchNomeFantasia";
        
    }
    
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getResultadoDaBusca() {
        return resultadoDaBusca;
    }

    public void setResultadoDaBusca(String resultadoDaBusca) {
        this.resultadoDaBusca = resultadoDaBusca;
    }

    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }

    public String getBandaEcontrada() {
        return BandaEcontrada;
    }

    public void setBandaEcontrada(String BandaEcontrada) {
        this.BandaEcontrada = BandaEcontrada;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public List<Integrante> getIntegrantesBanda() {
        return integrantesBanda;
    }

    public void setIntegrantesBanda(List<Integrante> integrantesBanda) {
        this.integrantesBanda = integrantesBanda;
    }

    public List<Banda> getBandasLocalOrigem() {
        return bandasLocalOrigem;
    }

    public void setBandasLocalOrigem(List<Banda> bandasLocalOrigem) {
        this.bandasLocalOrigem = bandasLocalOrigem;
    }
    
    
    
    
    
    
}
