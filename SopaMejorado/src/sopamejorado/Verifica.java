/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sopamejorado;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import static sopamejorado.Apertura.REWRITE;

/**
 *
 * @author javier
 */
public class Verifica  {
   
    
    private int[] cor2;
    private int[] cor1;
    private String[] palabra;
    private String[] posision;
    private JTextPane pane;
    
  

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
    
    public void doit(char [][] sopa,int fila,int columna, JLabel[][] b,Sopa frame){
       for(int i=0;i<fila;i++){
                     for(int j=0;j<columna;j++){
                        b[i][j]=new JLabel(String.valueOf(sopa[i][j]));
                        b[i][j].setBounds(10 + j * 20, 150 + i * 20, 20, 20);
                        
                        //b[i][j].setFont(new Font("Arial", Font.BOLD, 14));
                   
                          frame.add(b[i][j]);
                          frame.repaint();
    
                     }
       }
    }
    
    public void ver(char [][] sopa,int fila,int columna,int numPalabras,String [] palabras,JLabel[][] b,Sopa frame,JTextPane p) throws IOException{
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
                              if((columna-1)-j>= (a.length()-1)){
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
                                        int cont=0,fil=j;
                                        while(cont<k){
                                           
                                            
                                         b[i][fil].setBounds(10 + fil * 20, 150 + i * 20, 20, 20);
                                         b[i][fil].setForeground(Color.RED);
                                         b[i][fil].setFont(new Font("Arial", Font.BOLD, 14));
                   
                                        frame.add(b[i][fil]);
                                        frame.repaint();
                                        fil++;
                                        cont++;
                                    }
                                        cor1[ind]=pos1; cor2[ind]=pos2;palabra[ind]=a;posision[ind]="HRIZONTAL";
                                        
                                        ind++;
                                        
                                        k=2;
                                    }
                                }
                              }
                              
                              
                              if((fila-1)-i >= (a.length()-1)){
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
                                          
                                        int cont=0,col=i;
                                        while(cont<k){
                                           
                                            
                                         b[col][j].setBounds(10 + j * 20, 150 + col * 20, 20, 20);
                                         b[col][j].setForeground(Color.blue);
                                         b[col][j].setFont(new Font("Arial", Font.BOLD, 14));
                   
                                        frame.add(b[col][j]);
                                        frame.repaint();
                                        col++;
                                        cont++;
                                    }
                                          
                                        cor1[ind]=pos1; cor2[ind]=pos2;palabra[ind]=a;posision[ind]="VERTICAL";
                                        
                                        ind++;
                                        
                                        k=2;
                                    }
                                  }
                              }
                              
                              if (((fila-1)-i >= (a.length()-1)) && ((columna-1)-j>= (a.length()-1))){
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
                                       
                                        int cont=0,col=i,fil=j;
                                        while(cont<k){
                                           
                                            
                                         b[col][fil].setBounds(10 + fil * 20, 150 + col * 20, 20, 20);
                                         b[col][fil].setForeground(Color.green);
                                         b[col][fil].setFont(new Font("Arial", Font.BOLD, 14));
                   
                                        frame.add(b[col][fil]);
                                        frame.repaint();
                                        col++;
                                        fil++;
                                        cont++;
                                    }
                                          
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
                String palabritas="";
                palabritas=Integer.toString(n)+"\n";
                
                //imprime las palabras y escribe las palabras en el archivo OUTPUT.txt
                
                for(int i=0;i<numPalabras;i++){
                    System.out.println(cor1[i]+" "+cor2[i]+" "+palabra[i]+" "+posision[i]);
                    palabritas+=cor1[i]+" "+cor2[i]+" "+palabra[i]+" "+posision[i]+"\n";
                }
                p.setText(palabritas);
                 
    }
    
    
   
    
  
    
}
