/* ***************************************************************
* Autor: Wali Queiroz Santos
* Matricula: 201411130
* Inicio: 11/09/2016
* Ultima alteracao: 11/09/2016
* Nome: No
* Funcao: No de uma lista encadeada
*************************************************************** */
package servidorchat;

import java.io.OutputStream;

/**
 *
 * @author Wali
 */
public class No {
    
    private int info;
    private String nomeUsuario;
    private String nomeSala;
    private No proximo;
    private No anterior;
    private OutputStream saida;
    private Lista listaUsr;

    public No(int info, No proximo, No anterior) {
        this.info = info;
        this.proximo = proximo;
        this.anterior = anterior;
    }
    
    public No(String nomeSala){
        this.nomeSala = nomeSala;
        listaUsr = new Lista();
        proximo = null;
    }
    
    public No(String nomeUsuario, OutputStream saida){
        this.nomeUsuario = nomeUsuario;
        this.saida = saida;
        listaUsr = new Lista();
        proximo = null;
    }
    
    public No(int i, No p){
        info = i;
        proximo = p;
    }
    
    public No(int i){
        info = i;
        proximo = null;   
    }

    public OutputStream getSaida() {
        return saida;
    }

    public void setSaida(OutputStream saida) {
        this.saida = saida;
    }

    public Lista getListaUsr() {
        return listaUsr;
    }

    public void setListaUsr(Lista listaUsr) {
        this.listaUsr = listaUsr;
    }
    
    

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }
    

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
    
    
}
