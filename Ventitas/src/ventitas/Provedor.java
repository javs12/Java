/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventitas;

import java.util.Random;

/**
 *
 * @author javier
 */
public class Provedor extends Thread {
    
    private Recurso oRecurso;
    private String nombre;
    public Provedor(Recurso r, String a){
        oRecurso = r;
        nombre=a;
    }
    
    public void producir() throws InterruptedException{
        Random r = new Random();
            while(true){
                yield();
                oRecurso.surtir(r.nextInt(100)+1,nombre);
                Thread.sleep(r.nextInt(3000));
            }
    }        

    @Override
    public void run(){
        try{    
         producir();   
            
        }catch (InterruptedException ex){
            
    }
  }

    
}
