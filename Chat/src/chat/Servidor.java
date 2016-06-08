/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author javier
 */
public class Servidor {
    
    public static void main (String args[]){
        try{
              
            ArrayList<Socket> cliente = new ArrayList<>();
            ArrayList<PrintStream> out = new ArrayList<>();
            ArrayList<String> lol = new ArrayList<>();
            ServerSocket server = new ServerSocket(1234); 
            int localPort = server.getLocalPort();
            System.out.println("Servidor escuchando en puerto: "+localPort+".");
            int i=0;
            while(true){
            
                
            Socket client=server.accept();
            cliente.add(client);
            out.add(new PrintStream(client.getOutputStream()));
           
            new Server(client,cliente,out,lol).start();
            i++;
            
           }
             
          
        }catch (IOException ex){
            System.out.println("exepcion : IOExeption .");
        }
        
        
    }
    
}
    
    
    
 class Server extends Thread {
    //private ServerSocket server;
    private Socket client;
    private ArrayList<Socket>  cli;
    private ArrayList<PrintStream> out;
    private ArrayList<String> lol ;
    int a=0;
    public Server(Socket b,ArrayList c,ArrayList m,ArrayList v){
        //server=a;
        client=b;
        cli=c;
        out=m;
        lol=v;
        
    }
      public void run() {
        
          try {
            String destName = client.getInetAddress().getHostName();
            int destPort= client.getPort();
            System.out.println("Aceptando conexion a "+destName+" en puerto "+destPort+".");
            DataInputStream inStream = new DataInputStream(client.getInputStream());
            //DataOutputStream outStream = new DataOutputStream(client.getOutputStream());
             boolean finished = false;
           
            do {
                String inLine=inStream.readLine();
                   
                    
                    
                
                System.out.println("Recibido "+ inLine);
                if (inLine.equalsIgnoreCase("salir")) {
                    finished = true;
                    System.out.println("hola");
                }
                
                //String outLine = new ReverseString(inLine.trim()).getString();
                /*for (int i = 0; i < outLine.length(); i++) {
                        outStream.write((byte) outLine.charAt(i));
                    
                }
                outStream.write(13);
                outStream.write(10);
                outStream.flush();*/
              
                envia(inLine,lol);
                System.out.println("Enviado: "+inLine);
                
            } while (!finished);
            
            inStream.close();
            cerrarS();
            //outStream.close();
            //server.close();
        } catch (IOException ex) {
             System.out.println("exepcion : IOExeption 11.");
        }
      }
      
    
      
      private void  envia(String s,ArrayList s1) throws IOException{
          System.out.println(out.size());
          System.out.println(lol.size());
          if(a==0){
          for (int i = 0; i < out.size(); i++) {
              out.get(i).println(s);
              out.get(i).flush();
          }
          
          }else if(a==1){
              for (int i = 0; i < out.size(); i++) {
                  for (int j = 0; j < out.size(); j++) {
                      
                      out.get(i).println(s1.get(j));
                       System.out.println(s1.get(j));
                       out.get(i).flush();
                  }
              
              
          }
              a=0;
          }
      }
     
 
      
      private void cerrarS(){
          for (int i = 0; i < out.size(); i++) {
              out.get(i).close();
              
          }
      }
}


 