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
public class Barbero implements Runnable {
    public Thread thr;
    Barberia barberia;
    
    public Barbero( Barberia p_barberia ) { 
        barberia = p_barberia;
        thr   = new Thread((Runnable) this,"Barbero" );
    }
    
    public void run() { 
        while(true){
            barberia.siguienteCliente();
            try{     
                Thread.sleep(2000);
            }
            catch( InterruptedException e ) {}
            barberia.finCliente();
        }
    }
}