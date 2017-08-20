/* ***************************************************************
* Autor: Wali Queiroz 
* Nome: Mensagem
* Funcao: Classe que contem as informacoes a serem enviadas pela rede
*************************************************************** */
package servidorchat;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author waly_
 */
public class Mensagem implements Serializable{
    
    private String conteudo;
    private Date dataEHora;
    private int numSala;
    private String nomeUsuario;
    private boolean entrar;
    private boolean sair;

    public Mensagem(boolean entrar, boolean sair, String conteudo, Date dataEHora, int numSala, String nomeUsuario) {
        this.entrar = entrar;
        this.sair = sair;
        this.conteudo = conteudo;
        this.dataEHora = dataEHora;
        this.numSala = numSala;
        this.nomeUsuario = nomeUsuario;
    }

    public boolean isSair() {
        return sair;
    }

    public void setSair(boolean sair) {
        this.sair = sair;
    }
    
    
    public boolean isEntrar() {
        return entrar;
    }

    public void setEntrar(boolean sinalEntrar) {
        this.entrar = sinalEntrar;
    }

    
    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataEHora() {
        return dataEHora;
    }

    public void setDataEHora(Date dataEHora) {
        this.dataEHora = dataEHora;
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    
    
    
}
