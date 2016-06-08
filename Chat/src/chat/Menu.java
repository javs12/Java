/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author javier
 */
public class Menu extends JPanel {
    static final Boolean bT=new Boolean (true);
    static final Boolean bf=new Boolean (false);
    static ButtonGroup grupoBotones;
    JPanel p = new JPanel();
   
    JFrame f;
   
    static class TipoMenu{
     TipoMenu(int i){}   
    };
    //menu elementos normales
    static final TipoMenu mi = new TipoMenu(1);
    //menu con cajas de seleccion
    static final TipoMenu cb = new TipoMenu(2);
    //Menu con botones de radio
    static final TipoMenu rb = new TipoMenu(3);
    JTextField txt= new JTextField(10);
    //JLabel lbl = new JLabel
    ActionListener al1 = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          txt.setText(((JMenuItem)e.getSource()).getText());
          
            
        }
    };
    
     
      ActionListener salir = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
           
            DialogoC c= new DialogoC(f);
        }
    };
     
        ActionListener acerca = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            DialogoA a = new DialogoA(f);
        }
    };
        
        ActionListener conectar = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            DSeleccion a = new DSeleccion(f,p);
        }
    };
        
         ActionListener desconectar = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
           DDesconetar d= new DDesconetar(f);
        }
    };
    
    public Object menuArchivo[][]= {
        {"Archivo " , new Character ('A')},
        {"Conectarce " , mi, new Character ('C'),conectar,bT},
        {"Desconectarce " , mi, new Character ('D'),desconectar,bT},
       
        {null},//separador
        {"Salir" , mi, new Character ('S'),salir,bT},
        
    };
    
    
    public Object menuAyuda[][]= {
        {"Ayuda " , new Character ('A')},
        {"Acerca de.. " , mi, new Character ('S'),acerca,bT},
       
    };
    
    public Object barraMenu[]={
        menuArchivo,menuAyuda,
    };
    
    static public JMenuBar creaMenuBarra (Object barraMenuDato[]){
        JMenuBar barraMenu= new JMenuBar();
        
        for (int i = 0; i < barraMenuDato.length; i++) 
            barraMenu.add(creaMenu((Object[][])barraMenuDato[i]));
            return (barraMenu);
            
        
    }
    
    static public JMenu creaMenu(Object[][] menuDato){
        JMenu menu= new JMenu();
        
        menu.setText((String) menuDato[0][0]);
        menu.setMnemonic(((Character)menuDato[0][1]).charValue());
        grupoBotones = new ButtonGroup();
        for (int i = 1; i < menuDato.length; i++) {
            if(menuDato[i][0]== null)
                menu.add(new JSeparator());
            else 
                menu.add(creaMenuItem(menuDato[i]));
        }
        return(menu);
    }
    
    static public JMenuItem creaMenuItem(Object[] dato){
        JMenuItem m= null;
        TipoMenu tipo=(TipoMenu)dato[1];
        
        if(tipo== mi)
         m= new JMenuItem();
        else if(tipo==cb)
            m= new JCheckBoxMenuItem();
        else if(tipo==rb){
            m=new JRadioButtonMenuItem();
            grupoBotones.add(m);
            }
        
        m.setText((String)dato[0]);
        m.setMnemonic(((Character)dato[2]).charValue());
        m.addActionListener((ActionListener )dato[3]);
        m.setEnabled(((Boolean) dato[4]).booleanValue());
        return (m);
    }
    
    Menu(JFrame f ){
        this.f=f;
        setLayout(new BorderLayout());
        add(creaMenuBarra(barraMenu),BorderLayout.NORTH);
        
        p.setLayout(null);
        
        add(p);
        
    }
}
