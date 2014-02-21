/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colabarberia;

//import java.util.ArrayList;
import monitor.AbstractMonitor;
import monitor.Condition;
/**
 *
 * @author Jose
 */
public class Barberia extends AbstractMonitor{
    private Condition pelarse;
    private Condition trabajar;
    private Condition finalizar;
    private int n_clientes = 0;
    private boolean sentado = false;
    private boolean ocupado = false;
    
    Barberia(){
       pelarse  = makeCondition(); // la de cortar pelo
       trabajar = makeCondition(); // la de siguiente
       finalizar = makeCondition(); // la de finalizar 
    }
    
    public void cortarPelo(int cliente){
        enter();    
        System.out.println("Entra Mr. " + cliente + " a la barbería y se pone en espera.");
        while(n_clientes != 0 || ocupado)
            pelarse.await();
        if(!trabajar.isEmpty()){
            System.out.println("Mr. " + cliente + " despierta al barbero.");
        }
        n_clientes++;
        sentado = true;
        System.out.println("Mr. " + cliente + " se sienta en la silla del barbero.");
        trabajar.signal();  
        while(ocupado)
            finalizar.await();
        leave();
    }
    
    public void siguienteCliente() {
        enter();
        pelarse.signal();
        while(!sentado){
            System.out.println("Manolo el barbero se duerme.");
            trabajar.await();
        }
        System.out.println("Manolo el barbero se pone manos a la obra.");
        ocupado = true;
        leave();
    }
    
    public void finCliente() {
        enter();
        System.out.println("El barbero despide al cliente con una sonrisa.");
        n_clientes--;
        ocupado = false;
        sentado = false;
        finalizar.signal();
        leave();
    }
}