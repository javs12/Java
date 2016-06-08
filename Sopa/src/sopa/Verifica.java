/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sopa;
import java.io.IOException;
import static sopa.Apertura.REWRITE;

/**
 *
 * @author javier
 */
public class Verifica  {
   
    
    private int[] cor2;
    private int[] cor1;
    private String[] palabra;
    private String[] posision;
    
    
  

    public int[] getCor2() {
        return cor2;
    }

    public void setCor2(int[] cor2) {
        this.cor2 = cor2;
    }

    public int[] getCor1() {
        return cor1;
    }

    public void setCor1(int[] cor1) {
        this.cor1 = cor1;
    }

    public String[] getPalabra() {
        return palabra;
    }

    public void setPalabra(String[] palabra) {
        this.palabra = palabra;
    }

    public String[] getPosision() {
        return posision;
    }

    public void setPosision(String[] posision) {
        this.posision = posision;
    }
    
    public void ver(char [][] sopa,int fila,int columna,int numPalabras,String [] palabras,TextFile t) throws IOException{
        int n=0,ind=0;
        palabra=new String [numPalabras];
        cor2=new int[numPalabras];
        cor1=new int [numPalabras];
        posision= new String [numPalabras];
        String a="";        
                for(int l=0;l<numPalabras;l++){
                  int x,y,k=2,d=2,pos1=0 ,pos2=0,ban=0;
                    a=palabras[l];
                       
                    
                 for(int i=0;i<fila;i++){
                     for(int j=0;j<columna;j++){
                          if(a.charAt(0)==sopa[i][j]){
                              pos1=i+1;pos2=j+1;
                              if(5-j>= (a.length()-1)){
                                if(a.charAt(1)==sopa[i][j+1]){
                                    x=i; y=j+1;
                                    
                                    while (d<=a.length()-1){
                                    if(a.charAt(k)==sopa[x][y+1]){
                                       
                                        y++;
                                        k+=1;
                                    }
                                    d++;
                                    }
                                    if(k==a.length()){
                                        ban=1;
                                        
                                        cor1[ind]=pos1; cor2[ind]=pos2;palabra[ind]=a;posision[ind]="HRIZONTAL";
                                        
                                        ind++;
                                        
                                        k=2;
                                    }
                                }
                              }
                              
                              
                              if(4-i >= (a.length()-1)){
                                  if(a.charAt(1)==sopa[i+1][j]){
                                      x=i+1; y=j;
                                      while (d<= a.length()-1){
                                         if(a.charAt(k)==sopa[x+1][y]){
                                       
                                            x++;
                                            k+=1;
                                         }
                                         d++;
                                      }
                                      if(k==a.length()){
                                          ban=1;
                                        
                                        cor1[ind]=pos1; cor2[ind]=pos2;palabra[ind]=a;posision[ind]="VERTICAL";
                                        
                                        ind++;
                                        
                                        k=2;
                                    }
                                  }
                              }
                              
                              if ((4-i >= (a.length()-1)) && (5-j>= (a.length()-1))){
                                  if(a.charAt(1)==sopa[i+1][j+1]){
                                      x=i+1; y=j+1; 
                                      while (d<= a.length()-1){
                                          if (a.charAt(k)==sopa[x+1][y+1]){
                                              x++;
                                              y++;
                                              k+=1;
                                          }
                                          d++;
                                      }
                                      if(k==a.length()){
                                          ban=1;
                                       
                                         cor1[ind]=pos1; cor2[ind]=pos2;palabra[ind]=a;posision[ind]="DIAGONAL";
                                        ind++;
                                        
                                       
                                        k=2;
                                    }
                                  }
                              }
                              
                          }
                              
                         
                     } 
                 }
                 
                   if(ban==0){
                       n+=1;                 
                   
                     cor1[ind]=0; cor2[ind]=0;palabra[ind]=a;posision[ind]="ERROR";
                    ind++;
                    
                       
                   }
                      
                }
                System.out.println(n);
                t.write(n);
                t.write(SpecialChar.ENTER);
                //imprime las palabras y escribe las palabras en el archivo OUTPUT.txt
                for(int i=0;i<numPalabras;i++){
                    System.out.println(cor1[i]+" "+cor2[i]+" "+palabra[i]+" "+posision[i]);
                    t.writeLn(palabra[i],cor1[i] ,cor2[i] , posision[i]);
                }
                
                 
    }
    
    
   
    
  
    
}
