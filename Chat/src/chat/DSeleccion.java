/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author javier
 */
public class DSeleccion extends JDialog{
    
    private JTextField nombre;
    private JTextField ip;
    private JTextField pue;
    private int puerto;
    
    public DSeleccion(JFrame f, JPanel p){
        
        super(f,"Conectarce",true);
        super.setLayout(null);
        super.setSize(400, 300);
        
        JLabel acerca = new JLabel("Nombre usuario:");
        acerca.setBounds(10, 40, 150, 20);
        super.add(acerca);
        
        nombre = new JTextField();
        nombre.setBounds(169, 40 ,150 , 20);
        super.add(nombre);
        
        JLabel ipq = new JLabel("IP servidor:");
        ipq.setBounds(10, 70, 150, 20);
        super.add(ipq);
        
        ip = new JTextField("127.0.0.1");
        ip.setBounds(169, 70, 150, 20);
        super.add(ip);
        
        JLabel pu = new JLabel("Puerto");
        pu.setBounds(10, 90, 150, 20);
        super.add(pu);
        
        pue = new JTextField("1234");
        pue.setBounds(169, 90, 150, 20);
        super.add(pue);
        
        JButton ok = new JButton("Cancelar");
        ok.setBounds(65, 200, 100, 30);
        ok.addActionListener(oka);
        super.add(ok);
        
        JButton ok1 = new JButton("Aceptar");
        ok1.setBounds(200, 200, 100, 30);
        ok1.addActionListener(new oka1(nombre,p,f,ip,pue));
        super.add(ok1);
        super.repaint();
       
        super.setVisible(true);
        
        
    }

    public JTextField getNombre() {
        return nombre;
    }

    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
    }

    public JTextField getIp() {
        return ip;
    }

    public void setIp(JTextField ip) {
        this.ip = ip;
    }

    public JTextField getPue() {
        return pue;
    }

    public void setPue(JTextField pue) {
        this.pue = pue;
    }

    
    
     ActionListener oka = new ActionListener(){
        
        public void actionPerformed(ActionEvent evt){
            setVisible(false);
        }
    };
    
    
    class oka1 implements ActionListener{
           private JTextField nombre;
           private JPanel pa;
           private JFrame fr;
           private JTextField escribe;
           private JTextArea mostrar;
           private JPanel pane;
           private Cliente portal;
           private String nom;
           private String ip;
           private int puerto;
           
        public JTextField getEscribe() {
            return escribe;
        }

        public void setEscribe(JTextField escribe) {
            this.escribe = escribe;
        }

        public JTextArea getMostrar() {
            return mostrar;
        }

        public void setMostrar(JTextArea mostrar) {
            this.mostrar = mostrar;
        }

           
       
        public oka1(JTextField t,JPanel p,JFrame f,JTextField a,JTextField b){
               nombre=t;
               pa=p;
               fr=f;
               ip=a.getText();
               puerto= Integer.parseInt(b.getText());
           }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            nom=nombre.getText();
            System.out.println(nom);
            int a=0;
        mostrar = new JTextArea();
        mostrar.setBounds(0, 0, 380, 10000);
        //super.add(area);
        
         pane = new JPanel();
         pane.setBounds(20, 20, 400, 350);
         pane.add(mostrar);
         pane.setLayout(null);
         pane.setPreferredSize(new Dimension(400,10000));
         
            
        JScrollPane scroll = new JScrollPane(pane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(20, 20, 400, 350);
        pa.add(scroll);
        
        escribe= new JTextField();
        escribe.setBounds(20, 390, 400, 100);
        pa.add(escribe);
           
        portal=new Cliente(escribe,mostrar,nom,pa,ip,puerto);
        
        
        portal.start();
         
        JButton enviar= new JButton("Enviar");
        enviar.setBounds(460,430, 100,20);
        enviar.addActionListener(new Enviar(portal));
        pa.add(enviar);
        
        JButton enviar1= new JButton("Salir");
        enviar1.setBounds(460,460, 100,20);
        enviar1.addActionListener(new Enviar1(portal,fr));
        pa.add(enviar1);
        
        pa.repaint();
        fr.setSize(590, 550);
        }
    
    }
    
    class Enviar implements ActionListener{

        private Cliente p;   
        public Enviar(Cliente p1){
            
            p=p1;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            p.chatir();
            p.limpia();
            //p.shutdown();
            
        }
        
    }
    
    class Enviar1 implements ActionListener{
        
        private Cliente p;   
        private JFrame fr;
        public Enviar1(Cliente p1,JFrame f){
            fr=f;
            p=p1;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            //p.chat(escribe, mostrar);
            //p.shutdown();
            DialogoC d= new DialogoC(fr);
        }
        
    }
}
