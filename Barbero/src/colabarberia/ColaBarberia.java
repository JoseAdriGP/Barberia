/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colabarberia;

/**
 *
 * @author Jose
 */
public class ColaBarberia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // leer parametros, crear vectores y buffer intermedio
        Barberia barberia = new Barberia();
        Cliente[] cliente = new Cliente[5];
           
    // crear hebras
        Barbero barbero = new Barbero(barberia);
        for(int i = 0; i < cliente.length; i++) 
            cliente[i] = new Cliente(barberia,i) ;
    
    // poner en marcha las hebras
        for(int i = 0; i < cliente.length; i++) 
            cliente[i].thr.start();
        barbero.thr.start();
    }
}