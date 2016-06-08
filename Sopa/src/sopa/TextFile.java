/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sopa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** 
 *
 * @author javier
 */
public class TextFile {

    private File file;
    private FileInputStream reader;
    private FileOutputStream writer;
    
    
    public TextFile( String nameFile, Apertura type, Boolean forzar) throws IOException, ArchivoInexistenteException {
        file = new File(nameFile);
        if (!file.exists()) {
            if (forzar) {
                file.createNewFile();
            } else 
                throw new ArchivoInexistenteException();
        }  
        switch (type) {
            case READ:
                reader = new FileInputStream(file);
                break;
            case REWRITE:
                writer = new FileOutputStream(file);
                break;
            case APPEND:
                writer = new FileOutputStream(file, true);
                break;
            default:
                break;
        }
    }
    
    public void write( String palabra) throws IOException {
        writer.write(palabra.getBytes());
    }
    
    public void write( SpecialChar c) throws IOException {
        writer.write(c.getBytes());
    }
    
    public void writeLn( String s , Integer a, Integer b, String pos) throws IOException {
        write(s);
        write(SpecialChar.ESPACIO);
        write(a);
        write(SpecialChar.ESPACIO);
        write(b);
        write(SpecialChar.ESPACIO);
        write(pos);
        write(SpecialChar.ENTER);
        
    }
    
    
    public void write(Integer i) throws IOException {
        writer.write(i.toString().getBytes());
    }
    
    public String readLn() throws IOException {
        int dato = 0;
        String r="";
        while(!eof() && ((dato = reader.read()) != 10) ) {
            r = r + (char) dato;
        }
        return r;
    }
   
    
    
    public Boolean eof() throws IOException {
        return reader.available() > 0 ? false : true;
        
    }
    
    public void closeReader() throws IOException{
        reader.close();
        
    }
    
    public void closeWriter() throws IOException{
        writer.close();
    }
    
    
}
    

enum SpecialChar {
    ENTER("\n"),
    ESPACIO(" "),
    TABULADOR("\t"),
    COMILLAS("\""),
    APOSROFE("\'"),
    DIAGONAL_INVERTIDA("\\");
    
    private String formato;
    
    private SpecialChar(String formato) {
        this.formato = formato;
    }
    
    public byte[] getBytes() {
        return formato.getBytes();
    }
}


enum Apertura {
    REWRITE, 
    READ,
    APPEND,
    EDIT
}
