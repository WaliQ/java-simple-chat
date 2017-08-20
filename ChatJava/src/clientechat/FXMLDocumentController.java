/* ***************************************************************
* Autor: Wali Queiroz Santos
* Matricula: 201411130
* Inicio: 11/09/2016
* Ultima alteracao: 11/09/2016
* Nome: FXMLDocumentController
* Funcao: Controlar a interface grafica
*************************************************************** */
package clientechat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import servidorchat.Mensagem;

/**
 *
 * @author waly_
 */
public class FXMLDocumentController implements Initializable {

    private ObjectOutputStream saida;
    private Socket cliente;//socket cliente
    private Recebedor recebe;//thread recebedora
    @FXML
    private TextArea taChat;
    @FXML
    private TextField tfMsg;
    @FXML
    private TextField tfSala;
    @FXML
    private TextField tfNick;
    @FXML
    private Button btEntrar;
    @FXML
    private Button btEnviar;
    @FXML
    private Button btSair;
    @FXML
    private Label lbNick;
    @FXML
    private Label lbSala;

    public FXMLDocumentController() {
        try {
            cliente = new Socket("127.0.0.1", 12345);//estabelece a conexao com o server; IP do servidor pode ser alterado aqui
            System.out.println("Chat inicializado");
        } catch (IOException ex) {
            System.out.println("Servidor Offline");
        }
    }
    
/***************************************************************
* Metodo: btEntrar
* Funcao: Controla o botao "entrar" da interface grafica; envia o nome de usuario e a sala que o user quer entrar pela rede
* Parametros: event
* Retorno: void
****************************************************************/
    @FXML
    public void btEntrar(ActionEvent event) {
        Mensagem msg;//APDU da aplicacao
        int sala = 0;
        boolean entrou = false;
        try {
            sala = Integer.parseInt(tfSala.getText());
            msg = new Mensagem(true, false, null, new Date(), sala, tfNick.getText());
            saida = new ObjectOutputStream(cliente.getOutputStream());
            saida.writeObject(msg);//Envia APDU
            saida.flush();
            entrou = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Servidor offline ou sala inválida!");
        }
        if (entrou) {//Se a entrada foi bem sucedida, realiza algumas mudancas na interface
            btEnviar.setVisible(true);
            tfMsg.setVisible(true);
            btSair.setVisible(true);
            btEntrar.setVisible(false);
            lbNick.setVisible(false);
            lbSala.setVisible(false);
            tfNick.setVisible(false);
            tfSala.setVisible(false);
            recebe = new Recebedor(cliente, taChat);
            recebe.start();
            switch(sala){
                case 1:
                    taChat.appendText("------------------- SALA AMIZADE ----------------------");
                    break;
                case 2:
                    taChat.appendText("------------------- SALA BATE-PAPO ----------------------");
                    break;
                case 3:
                    taChat.appendText("------------------- SALA PAQUERA ----------------------");
                    break;
                case 4:
                    taChat.appendText("------------------- SALA MUSICA ----------------------");
                    break;
                case 5:
                    taChat.appendText("------------------- SALA ESPORTES ----------------------");
                default:
            }
        }
    }

/***************************************************************
* Metodo: btEnviar
* Funcao: Controla o botao "enviar" da interface grafica; Envia uma mensagem pela rede
* Parametros: event
* Retorno: void
****************************************************************/
    @FXML
    public void btEnviar(ActionEvent event){
        Mensagem msg;//APDU
        if (!tfMsg.getText().isEmpty()) {//se o campo  não estiver vazio, envia
            try {
                msg = new Mensagem(false, false, tfMsg.getText(), new Date(), Integer.parseInt(tfSala.getText()), tfNick.getText());
                saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.writeObject(msg);
                saida.flush();
                tfMsg.clear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Servidor Offline!");
            }
        }
    }

/***************************************************************
* Metodo: btSair
* Funcao: Controla o botao "Sair" da interface grafica; Finaliza o programa
* Parametros: event
* Retorno: void
****************************************************************/
    @FXML
    public void btSair(ActionEvent event) {       
        Mensagem msg;//APDU      
            try {
                msg = new Mensagem(false, true, tfMsg.getText(), new Date(), Integer.parseInt(tfSala.getText()), tfNick.getText());//mensagem de saida
                saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.writeObject(msg);
                saida.flush();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Servidor Offline!");
            }
        recebe.stop();
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
