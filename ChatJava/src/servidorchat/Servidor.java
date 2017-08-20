/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author waly_
 */
public class Servidor extends Thread {

    Lista listaSalas = new Lista();//Lista de salas de chat

    /***************************************************************
* Metodo: run
* Funcao: Aguarda por conexoes de clienes e cria salas de chat
* Parametros: event
* Retorno: void
****************************************************************/
    @Override
    public void run() {
        //Cria salas de chat
        listaSalas.incluirFim("Amizade");//1
        listaSalas.incluirFim("Bate-Papo");//2
        listaSalas.incluirFim("Paquera");//3
        listaSalas.incluirFim("Musica");//4
        listaSalas.incluirFim("Esportes");//5
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor online!");
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado!");
                Auxiliar aux = new Auxiliar(cliente,listaSalas);
                aux.start();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
        }
    }

}
