/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;

import javax.swing.JDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gargui3
 */
public class DialogoC extends JDialog {
    
   
    
    public DialogoC(JFrame f){
        
        super(f,"SALIR",true);
        super.setLayout(null);
        super.setSize(400, 300);
        
        JLabel acerca = new JLabel("¡¿seguro quieres salir?");
        acerca.setBounds(80, 40, 300, 20);
        super.add(acerca);
        
        
        
        JButton ok = new JButton("Cancelar");
        ok.setBounds(65, 200, 100, 30);
        ok.addActionListener(oka);
        super.add(ok);
        
        JButton ok1 = new JButton("Aceptar");
        ok1.setBounds(200, 200, 100, 30);
        ok1.addActionListener(new oka1());
        super.add(ok1);
        
        super.setVisible(true);
        
    }
    
     ActionListener oka = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            setVisible(false);
        }
    };
    
    
    class oka1 implements ActionListener{

        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    
}
    
}
