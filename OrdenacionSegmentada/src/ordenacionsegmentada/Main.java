/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ordenacionsegmentada;

import com.sun.jmx.snmp.BerDecoder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

/**
 *
 * @author javier
 */
public class Main extends JFrame {
   private JTextField noElementos;
   private JSlider noSegmentos;
   private JButton generar;
   private JButton ordenar;
   private JTextField minimo;
   private JTextField maximo;
   private JProgressBar [] barra;
   private JTextField reloj;
   private JTextPane pane;
   private JButton ver;
   
    public Main() throws HorainvalidaExeption{
        super("Segmentos");
        super.setSize(700, 700);
        super.setLayout(null);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JLabel elementos = new JLabel("No elementos:");
        elementos.setBounds(20, 20, 150, 20);
        super.add(elementos);
        
        noElementos = new JTextField();
        noElementos.setBounds(160, 20, 100, 20);
        super.add(noElementos);
        
        
        
        reloj=new JTextField("0:0:0");
        reloj.setBounds(300, 20, 100, 20);
        reloj.setForeground(Color.red);
        super.add(reloj);
        HiloReloj h= new HiloReloj(0,0, 0, reloj);
        
        JLabel segmentos = new JLabel("No segmentos:");
        segmentos.setBounds(20, 50, 150, 20);
        super.add(segmentos);
        
        noSegmentos = new JSlider();
        noSegmentos.setBounds(160, 50, 400, 40);
        noSegmentos.setMinimum(1);
        noSegmentos.setMaximum(30);
        noSegmentos.setMajorTickSpacing(2);
        noSegmentos.setPaintTicks( true );
        noSegmentos.setPaintLabels(true);
        noSegmentos.setForeground(Color.red);
        super.add(noSegmentos);
        
        JLabel min = new JLabel("Minimo:");
        min.setBounds(20, 100, 100, 20);
        super.add(min);
        
        minimo= new JTextField();
        minimo.setBounds(90, 100, 50,20);
        super.add(minimo);
        
        JLabel max = new JLabel("Maximo:");
        max.setBounds(150, 100, 100, 20);
        super.add(max);
        
        maximo= new JTextField();
        maximo.setBounds(230, 100, 50,20);
        super.add(maximo);
        
        pane=new JTextPane();
        pane.setBounds(20, 200, 300, 400);
        super.add(pane);
        
        generar = new JButton("Generar");
        generar.setBounds(20,130 , 100, 20);
        generar.setForeground(Color.WHITE);
        generar.setBackground(Color.DARK_GRAY);
        generar.addActionListener(new Hacer(noElementos,noSegmentos,minimo,maximo,this,barra,h,pane));
        super.add(generar);
       
       
        
        
        
        super.setVisible(true);
        
    }

    public JTextField getNoElementos() {
        return noElementos;
    }

    public void setNoElementos(JTextField noElementos) {
        this.noElementos = noElementos;
    }

    public JSlider getNoSegmentos() {
        return noSegmentos;
    }

    public void setNoSegmentos(JSlider noSegmentos) {
        this.noSegmentos = noSegmentos;
    }

    public JButton getGenerar() {
        return generar;
    }

    public void setGenerar(JButton generar) {
        this.generar = generar;
    }

    public JButton getOrdenar() {
        return ordenar;
    }

    public void setOrdenar(JButton ordenar) {
        this.ordenar = ordenar;
    }

    public JTextField getMinimo() {
        return minimo;
    }

    public void setMinimo(JTextField minimo) {
        this.minimo = minimo;
    }

    public JTextField getMaximo() {
        return maximo;
    }

    public void setMaximo(JTextField maximo) {
        this.maximo = maximo;
    }

   

    public JProgressBar[] getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar[] barra) {
        this.barra = barra;
    }

    public JTextField getReloj() {
        return reloj;
    }

    public void setReloj(JTextField reloj) {
        this.reloj = reloj;
    }

    public JTextPane getPane() {
        return pane;
    }

    public void setPane(JTextPane pane) {
        this.pane = pane;
    }
    
    
    
    
    public static void main(String [] args) throws HorainvalidaExeption{
        new Main();
        /*Integer a=500000;
        Integer [] arreglo = new Integer [a];
        Integer [] arreglo1 = {10,2,9,4,5,6,8,7,3,1};
        
         Random rnd = new Random();
        for (int i = 0; i < a; i++) {
                
                arreglo[i]= (int)(rnd.nextDouble() * a + 1);
        }
        
        
        
        OrdenacionSegmentada s= new OrdenacionSegmentada(arreglo,10);
        s.ordenar();
        
        /*or (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
            
        }*/
                
    }
}

class Hacer implements ActionListener{
    private JTextField noElementos;
    private JSlider noSegmentos; 
    private JTextField maximo;
    private JTextField minimo;
    private JFrame f;
    private JProgressBar [] bar;
    private HiloReloj relo;
    private JTextPane pa;
    private JLabel label;
    public Hacer( JTextField elementos, JSlider segmentos,JTextField min,JTextField max,JFrame fr,JProgressBar[] b,HiloReloj r,JTextPane p){
        noElementos=elementos;
        noSegmentos=segmentos;
        minimo=min;
        maximo=max;
        f=fr;
        bar=b;
        relo=r;
        pa=p;
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(noElementos.getText());
        int segmentos = noSegmentos.getValue();
        Integer [] arreglo = new Integer [a];
        Integer [] arreglo1 = new Integer [a];
        bar= new JProgressBar[noSegmentos.getValue()];
        int min = Integer.parseInt(minimo.getText());
        int max= Integer.parseInt(maximo.getText());
        Random rnd = new Random();
        
        for (int i = 0; i < a; i++) {
                
                //arreglo[i]= (int)(rnd.nextDouble() * (max-1) + min);
                
                arreglo[i]=(int)(Math.random()*(max-1) + min);
                //System.out.println(arreglo[i]);
        }
        
        for (int i = 0; i < segmentos; i++) {
            int le=370,ba=480,k=i;
            if(i>14){
                le+=430;
                ba+=430;
                k=i-15;
                f.setSize(1200,1200);
                f.repaint();
            }
            JLabel n = new JLabel("Segmento " + (i + 1) + ":");
            n.setBounds(le, 210 + (k * 30), 100, 20);
            f.add(n);
            bar[i] = new JProgressBar();
            bar[i].setBounds(ba, 210 + (k * 30), 200, 20);
            
            f.add(bar[i]);
        }
        //System.out.println("seg  "+segmentos);
        
        
        //OrdenacionSegmentada o = new OrdenacionSegmentada(arreglo,segmentos,min,max,bar,f,relo,arreglo1);
        
                String cadena="";
                for (int i = 0; i < 100; i++) {
                    
                    cadena=cadena+arreglo[i]+"  ";
                    
                }
                pa.setText(cadena);
                
                
               
                JButton ver = new JButton("ver mas");
                ver.setBounds(290, 170, 100, 20);
                ver.setForeground(Color.WHITE);
                ver.setBackground(Color.DARK_GRAY);
                ver.addActionListener(new ver(arreglo,0,pa,a));
                f.add(ver);
                label=new JLabel("Pres aqui para ver odenado-->");
                //label.setBounds(20,170, 290, 20);
                //f.add(label);
                
                
                JButton ordenar = new JButton("Ordenar");
                ordenar.setBounds(150,130 , 100, 20);
                ordenar.setForeground(Color.WHITE);
                ordenar.setBackground(Color.DARK_GRAY);
                ordenar.addActionListener(new Ordenari(arreglo, segmentos, min, max, bar, relo,label,f));
                f.add(ordenar);
                
                
                f.repaint();
                
                
               
            
        
    }
    
}


class ver implements ActionListener{
private Integer []arr;
private Integer a;
private JTextPane p;
private Integer vi;
private Integer s=0;
 public ver (Integer [] am , Integer b, JTextPane n,Integer v){
     arr=am;
     p=n;
     a=b;
     vi=v;
 }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        String cadena=""; 
        
        for (int i = s; i < s+100; i++) {
            if(i<vi){
            cadena=cadena+arr[i]+" ";
            }
        }
        p.setText(cadena);
        s+=100;
        if(s==vi-100){
            s=0;
            System.out.println(s);
        }
    }
    
    
}
class Ordenari implements ActionListener{
    private Integer []elem;
    private Integer seg;
    private Integer minimo;
    private Integer maximo;
    private JProgressBar [] barra;
    private HiloReloj r;
    private JLabel f;
    private JFrame frame;
    public Ordenari(Integer [] e, Integer a, Integer b,Integer c,JProgressBar[] ba,HiloReloj ro,JLabel m,JFrame of){
        elem=e;
        seg=a;
        minimo=b;
        maximo=c;
        barra=ba;
        r=ro;
        f=m;
        frame=of;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       f.setBounds(20,170, 290, 20);
       f.setForeground(Color.red);
       frame.add(f);
       frame.repaint();
       ParaReloj p= new ParaReloj(seg, r);
       OrdenacionSegmentada o = new OrdenacionSegmentada(elem,seg,minimo,maximo,barra,r,p);
       
       o.ordenar();
       r.start();
       
    }
    
    
}