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
public class Cliente implements Runnable{
    public Thread thr;
    int cliente;
    Barberia barberia;
    
    public Cliente(Barberia p_barberia, int p_cliente){
        barberia = p_barberia;
        cliente = p_cliente;
        thr   = new Thread((Runnable) this,"Cliente" + cliente );
    }
    
    public void run(){
        while (true) {
            barberia.cortarPelo(cliente);
            try { 
                Thread.sleep(20000); 
            } 
            catch (InterruptedException e) { } 
        }
        
    }
}