package chat;


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
public class DialogoA extends JDialog {
    
   
    
    public DialogoA(JFrame f){
        
        super(f,"Acerca de...",true);
        super.setLayout(null);
        super.setSize(300, 300);
        
        JLabel acerca = new JLabel("con el chat podras encontrar  nuevos");
        acerca.setBounds(10, 40, 300, 20);
        super.add(acerca);
        JLabel a = new JLabel("amigos :D");
        a.setBounds(10, 60, 350, 20);
        super.add(a);
        
        
        JButton ok = new JButton("Listo!");
        ok.setBounds(75, 200, 150, 30);
        ok.addActionListener(oka);
        super.add(ok);
        
       
        super.setVisible(true);
        
    }
    
     ActionListener oka = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            setVisible(false);
        }
    };
    
    
    
    
}
