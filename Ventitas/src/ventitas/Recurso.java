/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventitas;

import javax.swing.JTextArea;

/**
 *
 * @author javier
 */
public class Recurso {
    
    private int recurso;
    private JTextArea area;
    public Recurso(JTextArea a){
        recurso = 0;
        area=a;
        
    }
    
    public synchronized void surtir(int cantidad,String nombre){
        recurso += cantidad;
        //System.out.println("Surtir: "+cantidad+" Saldo: "+recurso);
        area.setText(area.getText()+nombre+"Surtio: "+cantidad+" Saldo: "+recurso+"\n");
        notify();
    }
    
    public synchronized void vender(int cantidad) throws InterruptedException{
        
        while(recurso < cantidad){
           
            area.setText(area.getText()+"A la chonita No le sale ..."+"\n");
            //System.out.println("No me sale...");
            wait();
        }
        recurso -= cantidad;
         area.setText(area.getText()+"La chonita Vende: "+cantidad+" Saldo "+recurso+"\n");
        //System.out.println("Vender: "+cantidad+" Saldo "+recurso);
    
    }
    
}
