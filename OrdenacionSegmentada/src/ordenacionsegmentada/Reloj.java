/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ordenacionsegmentada;

import javax.swing.JTextField;

/**
 *
 * @author javier
 */
public class Reloj {
    
    private Integer hora;
    private Integer minuto;
    private Integer segundo;

    /**
     * Variable de clase para el formato de 24/12 hrs.
     */
    public static boolean formato=true;
    private String tiempo="Hrs.";
  
    /**
     *constructor de la clase 
     * @param h
     * @param m
     * @param s
     * 
     */
    public Reloj(Integer h, Integer m, Integer s) throws HorainvalidaExeption {
       
       if(h < 0 ){
           throw new HorainvalidaExeption ("Hora invalida-->"+hora); 
        }
        this.hora=h;
        this.minuto=m;
        this.segundo=s;
        
        
    }

    /**
     *
     * @return hora
     */
    public Integer getHora() {
        return hora;
    }

    /**
     *
     * @param hora
     */
    public void setHora(Integer hora) {
        this.hora = hora;
    }

    /**
     *
     * @return minuto
     */
    public Integer getMinuto() {
        return minuto;
    }

    /**
     *
     * @param minuto
     */
    public void setMinuto(Integer minuto) {
        this.minuto = minuto;
    }

    /**
     *
     * @return segundo
     */
    public Integer getSegundo() {
        return segundo;
    }

    /**
     *
     * @param segundo
     */
    public void setSegundo(Integer segundo) {
        this.segundo = segundo;
    }
    
     public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * Metodo adelanta un segundo
     */
    public void adelanta(){
        
        
         segundo++;
         if(segundo==60){
             segundo=0;
             minuto++;
             
         }
            if(minuto==60){
                minuto=0;
                hora++;
                
            }
            
             if(formato == false){
                if(hora-12 == 12){
                    hora=12;
                    tiempo="am";
                } else {if((hora-12)>0){
                       tiempo="pm";
                        hora=hora-12;
                      }//else tiempo="am";
                          
                  }
            }else{
               if(hora==25){
                 hora=1;
                
              }
            }
             
         
         
        
    }
    
    public void inicia(JTextField f) throws InterruptedException{
         Integer a=1;
         while(a==1){
         
         adelantar();
         Thread.sleep(10);
         f.setText(toString());
         }
    }
    
    public void adelantar(){
         segundo++;
         if(segundo==60){
             segundo=0;
             minuto++;
             
         }
            if(minuto==60){
                minuto=0;
                hora++;
                
            }
            
               
    }
    /**
     *Metodo atrasa un segundo
     */
    public void atrasar(){
        segundo--;
         if(segundo==-1){
             segundo=59;
             minuto--;
             
         }
            if(minuto==-1){
                minuto=59;
                hora--;
                
            }
            
               if(formato == false){
                if(hora-12 == 12){
                    hora=12;
                    tiempo="am";
                } else {if((hora-12)>0){
                       tiempo="pm";
                        hora=hora-12;
                      }else tiempo="am";
                  }
            }else{
               if(hora==-1){
                 hora=23;
                
               }
             }
             
    }
    
    /**
     * Metodo atrasa n segundos
     * @param n
     */
    public void atrasaNSegundos(Integer n){
        for(int i=0;i< n;i++){
            atrasar();
        }
    }
    
    /**
     *Metodo adelanta n segundos 
     * @param n
     */
    public  void adelantaNSegundos(Integer n){
        for(int i=0;i< n;i++){
            adelanta();
        }
    }
    
    /**
     *Metodo de verificacion de formato 24/12 Hrs.
     * @param n
     */
    public static void formato24(Integer n){
        if(n==12)
        formato=false;
        
    }
    
    public Integer compareTo(Reloj a){
        if(a.getSegundo()> this.segundo || (a.getMinuto()> this.minuto)||(a.getHora()> this.hora)){
            return 1;
        }else if(a.getSegundo()< this.segundo || (a.getMinuto()< this.minuto)||(a.getHora()< this.hora)){
            return -1;
        }else return 0;
            
    }
 
 
    
    public Reloj diferencia(Reloj a)throws HorainvalidaExeption{
        Integer min;
        Integer seg;
        Integer hor;
        if(compareTo(a)>0){
          seg=a.getSegundo()-this.segundo;
          min=a.getMinuto()-this.minuto;
          hor=a.getHora()-this.hora;
        }else {
          seg=this.segundo-a.getSegundo();
          min=this.minuto-a.getMinuto();
          hor=this.hora-a.getHora();
        }
       Reloj r = new Reloj(hor,min,seg);
        return r;
    }
    
    

    @Override
    public String toString() {
        return  hora + ":" + minuto + ":" + segundo + "min";
    }

   
    
}
