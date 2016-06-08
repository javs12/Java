/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sopa;


//import rudosopa.Verifica;
import java.io.IOException;
import java.util.StringTokenizer;
import static sopa.Apertura.READ;

import static sopa.Apertura.REWRITE;

/**
 *
 * @author giovanni
 */
public class Main {
    
    public static void main(String[] args) throws IOException, ArchivoInexistenteException {
        TextFile t= new TextFile("INPUT.txt",READ,true);
        TextFile t2= new TextFile("OUPUT.txt",REWRITE,true);
        char letritas[];
        int dimension[]= new int[3],i=0,j=0;
        String [] palabras;
        String  letras;
        String a = t.readLn();
        StringTokenizer tokens=new StringTokenizer(a," ");
	while(tokens.hasMoreTokens()){
            dimension[i]=Integer.parseInt(tokens.nextToken());
            i++;
        }
        char[][] sopita= new char[dimension[1]][dimension[0]];
        palabras= new String [dimension[2]];
        i=0;
      
        while (!t.eof()){
            while(i<dimension[2]){
            palabras[i]=t.readLn();
            i++;
            }
             for(int k=0; k< dimension[1];k++){
                   letras = t.readLn();
                   letritas=letras.toCharArray();
                 for(int l=0; l< dimension[0];l++){
                     sopita[k][l]=letritas[l];
                     
                 }
             }
        }
         t.closeReader();
         Verifica v= new Verifica();
         v.ver(sopita,dimension[1],dimension[0],dimension[2],palabras,t2); 
         t2.closeWriter();
        
    }
    
}
