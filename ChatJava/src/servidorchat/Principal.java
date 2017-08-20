/* ***************************************************************
* Autor: Wali Queiroz Santos
* Matricula: 201411130
* Inicio: 11/09/2016
* Ultima alteracao: 11/09/2016
* Nome: Principal
* Funcao: Incializar o servidor
*************************************************************** */
package servidorchat;

/**
 *
 * @author waly_
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.start();
        
    }
    
}
