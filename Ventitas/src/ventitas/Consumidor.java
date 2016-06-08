/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventitas;

import java.util.Random;
import javax.swing.JTextArea;

/**
 *
 * @author javier
 */
public class Consumidor extends Thread {
    
    private Recurso oRecurso;
    private JTextArea area;
    
    public Consumidor(String nombre, Recurso recurso,JTextArea ar){
        super(nombre);
        oRecurso = recurso;
        area=ar;
        
    }

   

    public void consumir() throws InterruptedException{
        
        Random r = new Random();
        int aux;    
            while(true){
                 
                aux = r.nextInt(10)+1;
                //System.out.println(getName()+"  Solicita: "+aux);
                area.setText(area.getText()+getName()+"  Solicita: "+aux+"\n");
                oRecurso.vender(aux);
                
            }
    }
    
    public void run(){
        try{
            consumir();
        }catch (InterruptedException ex){
        
        }
    
    }

}

