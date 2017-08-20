/* ***************************************************************
* Autor: Wali Queiroz Santos
* Matricula: 201411130
* Inicio: 11/09/2016
* Ultima alteracao: 11/09/2016
* Nome: Lista
* Funcao: Lista Encadeada usada no servidor do chat
*************************************************************** */
package servidorchat;

import java.io.OutputStream;

/**
 *
 * @author Wali
 */
public class Lista {

    private No inicio;
    private int numPos;

    public Lista() {
        inicio = null;
        numPos = 0;
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }
    
    public int getNumPos() {
        return numPos;
    }

    public boolean isEmpty() {
        return (inicio == null);
    }
    
/***************************************************************
* Metodo: incluirFim
* Funcao: Incluir um elemento no fim da lista
* Parametros: NomeU: String, saida: OutputStream
* Retorno: void
****************************************************************/
    
    public void incluirFim(String nomeU, OutputStream saida){
        No novo = new No(nomeU, saida);
        if (isEmpty()) {
            inicio = novo;
        } else {
            No temp = inicio;
            while(temp.getProximo()!=null){
                temp = temp.getProximo();
            }
            temp.setProximo(novo);
        }
        numPos++;
    }
    
/***************************************************************
* Metodo: incluirFim
* Funcao: Incluir um elemento no fim da lista
* Parametros: NomeS: String
* Retorno: void
****************************************************************/
    public void incluirFim(String nomeS){//reservado para o nome da sala
        No novo = new No(nomeS);
        if (isEmpty()) {
            inicio = novo;
        } else {
            No temp = inicio;
            while(temp.getProximo()!=null){
                temp = temp.getProximo();
            }
            temp.setProximo(novo);
        }
        numPos++;
    }
/***************************************************************
* Metodo: removerUsuario
* Funcao: Remover um usuario da lista da sala de chat
* Parametros: e: String
* Retorno: void
****************************************************************/
    public void removerUsuario(String e) {//remove um usuario pelo nome
        No temp = inicio;
        No ant = inicio;
        String valor = inicio.getNomeUsuario();

        if (valor.equals(e)) {
            inicio = inicio.getProximo();
            numPos--;
        } else {
            while (temp.getProximo() != null && !valor.equals(e)) {
                ant = temp;
                temp = temp.getProximo();
                valor = temp.getNomeUsuario();
            }
            if (valor.equals(e)) {
                ant.setProximo(temp.getProximo());
                numPos--;
            } else {
                System.out.println("Usuario nao encontrado!");
            }
        }
    }
  
    
/***************************************************************
* Metodo: buscarPosicao
* Funcao: Retornar o elemento de uma determinada posicao da lista
* Parametros: pos: int
* Retorno: void
****************************************************************/
    //Faz a busca e retorna o elemento de determinada posicao
    public No buscaPosicao(int pos){//recebe como argumento  posicao desejada
        int p = 1;
        No temp = inicio;
        if ((pos < 1) || (pos > numPos)) { //verifica se a posicao inserida eh maior que a quantidade de osicoes na lista, se for, imprime um aviso.
            System.out.println("Posicao invalida!");
        } else {
            while(p < pos){ //enquanto a variavel p for menor que a posicao inserida, temp ira apontar para cada elemento da lista, ateh chegar no desejado.
                temp = temp.getProximo();
                p++;
        }
            //System.out.println("O valor da posicao "+pos+" eh: "+temp.getInfo()); //imprime o valor da posicao digitada.
        }
        return temp;
    }
            
}
