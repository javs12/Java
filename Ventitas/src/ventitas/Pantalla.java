/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventitas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;

/**
 *
 * @author javier
 */
public class Pantalla extends JFrame {
    private JSpinner consumidores;
    private JSpinner provedores;
    private JButton hacer;
    private JButton parar;
    private JTextArea area;
    
    private JPanel pane;
    public Pantalla(){
        super("Ventas");
        super.setSize(500,500);
        super.setLayout(null);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JLabel ele=new JLabel("No consumidores:");
        ele.setBounds(20,20, 150, 20);
        super.add(ele);
        
        SpinnerNumberModel noCon = new SpinnerNumberModel(0, 0, 10.0, 1);
        consumidores = new JSpinner(noCon);
        consumidores.setBounds(35, 40, 100, 20);
        super.add(consumidores);
        
        JLabel con=new JLabel("No Provedores:");
        con.setBounds(200,20, 150, 20);
        super.add(con);
        
        SpinnerNumberModel noPro = new SpinnerNumberModel(0, 0, 10.0, 1);
        provedores = new JSpinner(noPro);
        provedores.setBounds(210, 40, 100, 20);
        super.add(provedores);
        
         
        area = new JTextArea();
        area.setBounds(20, 20, 350, 10000);
        //super.add(area);
        
         pane = new JPanel();
         pane.setBounds(20, 120, 400, 350);
         pane.add(area);
         pane.setLayout(null);
         pane.setPreferredSize(new Dimension(400,10000));
         
            
        JScrollPane scroll = new JScrollPane(pane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(20, 120, 400, 350);
        this.getContentPane().add(scroll);
         
        
        /*
         pane = new JPanel();
         pane.setBounds(20, 120, 400, 350);
         //pane.add("Center", area);
         super.add(pane);
            
        JScrollPane scroll = new JScrollPane(pane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(270, 210, 300, 300);
        
        //pane.add(scroll);
        super.repaint();
        */
        


            
        
        
        hacer = new JButton("Do It");
        hacer.setBounds(120, 80, 100, 20);
        hacer.addActionListener(new doIt(provedores,consumidores,area,this));
        super.add(hacer);
        
        
        super.setVisible(true);
        
    }

    public JSpinner getConsumidores() {
        return consumidores;
    }

    public void setConsumidores(JSpinner consumidores) {
        this.consumidores = consumidores;
    }

    public JSpinner getProvedores() {
        return provedores;
    }

    public void setProvedores(JSpinner provedores) {
        this.provedores = provedores;
    }

    public JButton getHacer() {
        return hacer;
    }

    public void setHacer(JButton hacer) {
        this.hacer = hacer;
    }

    public synchronized JTextArea getArea() {
        return area;
    }

    public synchronized void setArea(JTextArea area) {
        this.area = area;
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Pantalla();
    }
    
    
    
}

class doIt implements ActionListener {
    private JSpinner cons;
    private JSpinner pro;
    private Provedor []prv;
    private Consumidor []consu;
    private Recurso recurso;
    private JFrame v;
    private int a1,b1;
    private JTextArea area;
    private JFrame frame;
    private String [] nombres ={"Javier","Alondra","Karim","Guillen","Giovani","Mario","Vivas","Pastelin","Victor","Rolando"};
    private String []consumi={"Toomatos","La Gallinita","Elototes","Kel","Hola Mundo","Nestle","Lala","la doña","Tamaletitos","karimnot inc"};
    public doIt (JSpinner a, JSpinner b, JTextArea er,JFrame f){
       
        pro= a;
        cons=b; 
        area=er;
        frame=f;
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        Double n1= (Double)cons.getValue();
        Double n2= (Double)pro.getValue();
        a1 = (int) n2.doubleValue();
        b1= (int) n1.doubleValue();
        System.out.println(a1+" "+b1);
        prv=new Provedor[a1];
        consu=new Consumidor[b1];
        
        recurso= new Recurso(area);
         for (int i = 0; i < prv.length; i++) {
            prv[i]= new Provedor(recurso,consumi[i]);
           
        }
        
        for (int i = 0; i < consu.length; i++) {
            consu[i]= new Consumidor(nombres[i], recurso,area);
            
        }
      
         for (int i = 0; i < prv.length; i++) {
             prv[i].start();
             
            
        }
         for (int i = 0; i < consu.length; i++) {
            consu[i].start();
            
        }
         
         
        JButton parar= new JButton("Parar");
        parar.setBounds(250, 80, 100, 20);
        parar.addActionListener(new Parar(prv,consu));
        frame.add(parar);
        frame.repaint();

        
    }
    
}

class Parar implements ActionListener{
    private Provedor [] pro;
    private Consumidor [] con;
    
    public Parar(Provedor [] p, Consumidor [] o){
        pro=p;
        con=o;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < pro.length; i++) {
             pro[i].suspend();
             
            
        }
         for (int i = 0; i < con.length; i++) {
            con[i].suspend();
            
        }
         
         JOptionPane.showMessageDialog(null,
                              "El proceso a parado  :)",
                                  "Información",JOptionPane.INFORMATION_MESSAGE);
    }
    
}