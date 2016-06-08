/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ordenacionsegmentada;

import javax.crypto.SealedObject;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;

/**
 *
 * @author javier
 */
public class OrdenacionSegmentada {

   private Integer [] datos;
   private Segmento [] segmento;
   private Integer noSegmentos;
   private Intervalo valores;
   private JProgressBar[] barra;
   private HiloReloj o;
   private ParaReloj pa;
   public OrdenacionSegmentada(Integer [] n, Integer noSeg,Integer min,Integer max,JProgressBar[] f,HiloReloj m,ParaReloj p){
       datos=n;
       noSegmentos=noSeg;
       valores = new Intervalo (min,max);
       barra= f;
       o=m;
       pa=p;
       creaSegmentos();
     
       
   }
    
   
   private Intervalo obtenValores(){
       int min=0, max=0;
       min=datos[0];
       max=datos[0];
       for (int i = 0; i < datos.length; i++) {
           if(min > datos[i]){
               min=datos[i];
           }
           if(max < datos[i]){
               max=datos[i];
           }
           
       }
       
       return new Intervalo(min,max);
   }
   
  
   public void creaSegmentos(){
    segmento= new Segmento [noSegmentos];
       int medida =((valores.getMaximo()-valores.getMinimo())/noSegmentos);
       int fin, ini= valores.getMinimo();
       int posIni=0;
       int size =0;
       
       for (int i = 0; i < noSegmentos; i++) {
           
           fin = i < segmento.length-1 ? ini + medida : valores.getMaximo();
           Intervalo intervalito= new Intervalo (ini,fin);
           size= obtenTamanio(intervalito);
           segmento[i]=new Segmento(datos, obtenTamanio(intervalito), intervalito, new Intervalo(posIni,posIni+size),barra[i],datos.length,o,i,noSegmentos,pa);
           ini=fin+1;
           posIni+=size;
          
       }
       
      
   }
  
   
   
   private Integer obtenTamanio(Intervalo v){
       int tam=0;
      
       for (int i = 0; i < datos.length; i++) {
           if(datos[i] >= v.getMinimo() && datos[i]<= v.getMaximo()){
               tam++;
           }
           
       }
       return tam;
   }
   
 
   
   
   public void ordenar(){
       for (int i = 0; i < segmento.length; i++) {
           segmento[i].start();
          
       }
   }
}
