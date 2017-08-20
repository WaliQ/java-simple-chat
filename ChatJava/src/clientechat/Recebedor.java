/* ***************************************************************
* Autor: Wali Queiroz Santos
* Matricula: 201411130
* Inicio: 11/09/2016
* Ultima alteracao: 11/09/2016
* Nome: Recebedor
* Funcao: Receber dados do servidor
*************************************************************** */
package clientechat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextArea;
import servidorchat.Mensagem;

/**
 *
 * @author waly_
 */
public class Recebedor extends Thread{
    
    ObjectInputStream entrada;
    Socket cliente;
    TextArea ta;
    String data;
    String nome;
    String conteudo;
    Mensagem msg;
    
    public Recebedor(Socket cliente, TextArea ta) {
        this.cliente = cliente;
        this.ta = ta;
    }
    
/***************************************************************
* Metodo: run
* Funcao: Este metodo fica verificando constantemente se chegaram dados do servidor, quando chega algo, ele imprime na tela de chat
* Parametros: nenhum
* Retorno: void
****************************************************************/
    @Override
    public void run(){
        while(true){
            try {
                entrada = new ObjectInputStream(cliente.getInputStream());//receive
                msg = (Mensagem) entrada.readObject();
            } catch (IOException | ClassNotFoundException ex){ 
                Logger.getLogger(Recebedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            data = msg.getDataEHora().toString();
            conteudo = msg.getConteudo();
            nome = msg.getNomeUsuario();
            
            if(conteudo!=null&&!conteudo.isEmpty()){
                ta.appendText("\n--"+nome+" em: "+data+": --\n"+conteudo);
            }
        }
    }
}
