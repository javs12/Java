/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author javier
 */
public class Pantalla  extends JFrame {
   
    public Pantalla(){
        super("Chat");
        
         
        
        Menu panel = new Menu(this);
        
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.add(panel, BorderLayout.CENTER);
        super.setSize(500, 500);
            
        
        
        super.setVisible(true);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
         new Pantalla();
    }
    
}
