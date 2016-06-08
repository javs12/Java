/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;

import java.awt.Color;
import java.io.*;
import java.lang.System;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author giovanni
 */
//public class PortTalkApp {

    /**
     * @param args the command line arguments
     */
   /* public static void main(String[] args) {
        PortTalk portTalk = new PortTalk(args);
        portTalk.displayDestinationParameters();
        portTalk.displayLocalParameters();
        portTalk.chat();
        portTalk.shutdown();
    }*/
    
//}

public class Cliente extends Thread {
    Socket connection;
    DataOutputStream outStream;
    BufferedReader inStream;
    private JTextField oField;
    private JTextArea oArea;
    DataInputStream dis;
    private String nombre;
    private JPanel pane;
    private ArrayList<String> lol = new ArrayList<>();
    int a=0;
    public Cliente(JTextField f, JTextArea a ,String nom,JPanel p,String ip ,int pu) {
        nombre=nom;
        pane=p;
        oField=f;
        oArea=a;
        String destination = ip;
        int port = pu;
        
        try {
            connection = new Socket(destination, port);
        } catch (UnknownHostException ex) {
            error("Servidor desconocido");
        } catch (IOException ex){
            error("Error E/S: al crear el socket");
        }
        try {
            dis = new DataInputStream(connection.getInputStream());
           /* inStream = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));*/
            outStream = new DataOutputStream(connection.getOutputStream());
        } catch (IOException e) {
            error("Error E/S: obteniendo el flujo");
        }
        System.out.println("Conectando a: " + destination + " puerto " + 
                port + ".");
    }
    
    
   
    
    public void chatir(){
         try {
                
                
                            String sendLine = ""+nombre+": "+oField.getText();
                            outStream.writeBytes(sendLine);
                            outStream.write(13);
                            outStream.write(10);
                            outStream.flush();
                           
                           } catch (IOException e) {
                error("Error leyendo del teclado o socket");
            }
    }
    
    public  void  run () {
        
       boolean finished = false;
        
            try {
                
                     while(true){
                         
                           String mensaje = dis.readLine();
                           
                           if(mensaje==null){
                               System.out.println("mm");
                               break;
                              
                           }
                            System.out.println(mensaje);
                           oArea.setText(oArea.getText()+mensaje);
                            System.out.println();
                            oArea.setText(oArea.getText()+'\n');
                           
                     }
            } catch (IOException e) {
                error("Error leyendo del teclado o socket");
            }
        
                    
    }
    
    public void shutdown() {
        try {
            connection.close();
        } catch (IOException e) {
            error("Error E/S cerrando");
        }
    }
    
    public void error(String s) {
        System.out.println(s);
        System.exit(1);
    }
    
    public void limpia(){
        oField.setText(null);
    }
}
