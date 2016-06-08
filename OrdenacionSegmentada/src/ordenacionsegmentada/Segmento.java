/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ordenacionsegmentada;

import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;

/**
 *
 * @author javier
 */
public class Segmento extends Thread{
    
    private Integer size;
    private Integer [] aux;
    private Integer [] elementos;
    private Intervalo valor;
    private Intervalo posicion;
    private JProgressBar  barrita;
    private Integer v;
    private HiloReloj r;
    private Integer in;
    private Integer num;
    private Integer verifica=0;
    private ParaReloj par;
    public Segmento(Integer [] elem,Integer sz, Intervalo vl,Intervalo pos,JProgressBar b,Integer lar,HiloReloj reloj,Integer a,Integer k,ParaReloj p){
       elementos=elem;
       valor=vl;
       posicion=pos;
       aux = obtenerValores(sz);
       barrita=b;
       v=lar;
       r=reloj;
       in=a;
       num=k;
       par=p;
       
    }

    
    private Integer[] obtenerValores(int s){
        Integer [] auxi = new Integer [s];
        int cont =0;
        for (int i = 0; i < elementos.length; i++) {
            if(elementos[i]>= valor.getMinimo() && elementos[i]<= valor.getMaximo()){
                auxi[cont]=elementos[i];
                cont++;
            }
            
        }
        return auxi;
    }
    
   
    
    public void run (){
        int auxi;
        int min=0;
        int max=100;
        
        barrita.setValue(min);
        barrita.setMinimum(min);
        barrita.setMaximum(max);
        
        double t=0.0;
        System.out.println("inicia");
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux.length; j++) {
                if(aux[i]<aux[j]){
                    auxi=aux[i];
                    aux[i]=aux[j];
                    aux[j]=auxi;
                }
                
            }
            t +=(100.0f/aux.length);
            if(t>=1){
                min++;
                t=t-1;
                
                
                barrita.setStringPainted(true);
                barrita.setString(""+min+"%");
                barrita.setForeground(Color.GREEN);
                barrita.setBackground(Color.WHITE);
                barrita.setValue(min);
                
            }
            
        }
        auxi=0;
        for (int i = posicion.getMinimo(); i < posicion.getMaximo(); i++) {
            
            elementos[i]=aux[auxi];
           
            auxi++;
        }
        barrita.setValue(max);
        barrita.setString(""+100+"%");
        System.out.println("Termino");
        
        par.para();
    } 
    
}
