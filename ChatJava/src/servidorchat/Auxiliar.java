/* ***************************************************************
* Autor: Wali Queiroz
* Nome: Auxiliar
* Funcao: Processa uma conexao com um cliente
*************************************************************** */
package servidorchat;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author waly_
 */
public class Auxiliar extends Thread {

    private Socket cliente;
    private Lista listaSalas;
    ObjectOutputStream saida;

    public Auxiliar(Socket c, Lista l) {
        this.cliente = c;
        listaSalas = l;
    }

 /***************************************************************
* Metodo: run
* Funcao: Este metodo fica verificando constantemente se chegaram dados do cliente, quando chega algo, ele verifica e realiza uma acao
* Parametros: nenhum
* Retorno: void
****************************************************************/
    @Override
    public void run() {
        while (true) {
            try {
                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());//receive
                Mensagem msg = (Mensagem) entrada.readObject();
                No sala = listaSalas.buscaPosicao(msg.getNumSala());//pega a sala que o cliente quer entrar ou enviar msg

                if (msg.isEntrar()) {//se o usuario estiver entrando na sala, poe ele na sala desejada
                    sala.getListaUsr().incluirFim(msg.getNomeUsuario(), cliente.getOutputStream());
                }else if(msg.isSair()){//se o usuario estiver saindo de uma sala, remove ele
                    sala.getListaUsr().removerUsuario(msg.getNomeUsuario());
                } else {//senao envia a mensagem para todos os usuarios da sala que o user esta
                    Lista lista = sala.getListaUsr();
                    for (int i = 1; i <= lista.getNumPos(); i++) {
                        No usr = lista.buscaPosicao(i);
                        saida = new ObjectOutputStream(usr.getSaida());//pega o outputstrem do cliente
                        saida.writeObject(msg);
                        saida.flush();
                    }
                }
            } catch (Exception e) {
                    
            }
        }
    }
}
