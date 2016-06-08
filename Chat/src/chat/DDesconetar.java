/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author javier
 */
public class DDesconetar extends JDialog{
    
    public DDesconetar(JFrame f){
        
        super(f,"SALIR",true);
        super.setLayout(null);
        super.setSize(400, 300);
        
        JLabel acerca = new JLabel("¡¿seguro quieres desconectarte?");
        acerca.setBounds(90, 40, 300, 20);
        super.add(acerca);
        
        
        
        JButton ok = new JButton("Cancelar");
        ok.setBounds(75, 200, 100, 30);
        ok.addActionListener(oka);
        super.add(ok);
        
        JButton ok1 = new JButton("Aceptar");
        ok1.setBounds(210, 200, 100, 30);
        ok1.addActionListener(new oka1(f));
        super.add(ok1);
        
        super.setVisible(true);
        
    }
    
     ActionListener oka = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            setVisible(false);
        }
    };
    
    
    class oka1 implements ActionListener{
        private JFrame frame;
        public oka1(JFrame f){
            frame=f;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            Pantalla b = new Pantalla();
        }
    
}
}
