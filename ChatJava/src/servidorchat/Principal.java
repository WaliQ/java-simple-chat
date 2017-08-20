/* ***************************************************************
* Autor: Wali Queiroz
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
