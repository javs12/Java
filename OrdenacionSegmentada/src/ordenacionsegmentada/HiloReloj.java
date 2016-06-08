/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ordenacionsegmentada;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author javier
 */
public class HiloReloj extends Thread {
    private Reloj reloj;
    private JTextField relo;
    
    public HiloReloj(Integer h,Integer m,Integer s,JTextField r) throws HorainvalidaExeption{
        
        reloj= new Reloj(h,m,s);
        relo=r;
    }
    
    @Override
    public void run() {
        
        try {
            reloj.inicia(relo);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloReloj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
