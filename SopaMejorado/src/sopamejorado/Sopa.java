/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sopamejorado;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import static sopamejorado.Apertura.READ;
import static sopamejorado.Apertura.REWRITE;

/**
 *
 * @author giovanni
 */
public class Sopa extends JFrame {
    
    private JTextField edtColumnas;
    private JTextField edtFilas;
    private JTextField nombre;
    private JTextField palabras;
    private JTextPane palabrasEncontradas;
            
    public Sopa() {
        super("Sopa de letras");
        super.setSize(600, 600);
        super.setLayout(null);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JLabel archivo = new JLabel("Archivo");
        archivo.setBounds(10, 10, 100, 20);
        super.add(archivo);
        
        nombre = new JTextField();
        nombre.setBounds(10, 30, 130, 20);
        super.add(nombre);
        
        edtColumnas = new JTextField();
        edtColumnas.setBounds(10, 100, 100, 30);
        super.add(edtColumnas);
        
        edtFilas = new JTextField();
        edtFilas.setBounds(130, 100, 100, 30);
        super.add(edtFilas);
        
        JButton Buscar=new JButton("Buscar");
        Buscar.setBounds(150, 30, 100, 20);
        Buscar.setBackground(Color.LIGHT_GRAY);
        Buscar.setForeground(Color.RED);
        Buscar.addActionListener(new Buscar(nombre,edtColumnas,edtFilas));
        super.add(Buscar);
        
        JLabel lblColumnas = new JLabel("Filas");
        lblColumnas.setBounds(10, 80, 100, 20);
        super.add(lblColumnas);
        
       
        
        JLabel lblFilas = new JLabel("Columnas");
        lblFilas.setBounds(130, 80, 100, 20);
        super.add(lblFilas);
        
         
        JLabel palabras = new JLabel("Palabras Encontradas");
        palabras.setBounds(355, 150, 200, 20);
        super.add(palabras);
        
        palabrasEncontradas =new JTextPane();
        palabrasEncontradas.setBounds(350,200 , 200, 150);
        super.add(palabrasEncontradas);
        
        JButton btnDoIt = new JButton("Do it");
        btnDoIt.setBounds(250, 100, 100, 20);
        btnDoIt.setBackground(Color.LIGHT_GRAY);
        btnDoIt.setForeground(Color.RED);
        btnDoIt.addActionListener(new DoItAction(this));
        super.add(btnDoIt);
        
        super.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new Sopa();
    }

    /**
     * @return the edtColumnas
     */
    public JTextField getEdtColumnas() {
        return edtColumnas;
    }

    public JTextField getPalabras() {
        return palabras;
    }

    public void setPalabras(JTextField palabras) {
        this.palabras = palabras;
    }

    public JTextPane getPalabrasEncontradas() {
        return palabrasEncontradas;
    }

    public void setPalabrasEncontradas(JTextPane palabrasEncontradas) {
        this.palabrasEncontradas = palabrasEncontradas;
    }

    /**
     * @param edtColumnas the edtColumnas to set
     */
    public void setEdtColumnas(JTextField edtColumnas) {
        this.edtColumnas = edtColumnas;
    }

    /**
     * @return the edtFilas
     */
    public JTextField getEdtFilas() {
        return edtFilas;
    }

    /**
     * @param edtFilas the edtFilas to set
     */
    public void setEdtFilas(JTextField edtFilas) {
        this.edtFilas = edtFilas;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
    }
    
    
   
}

class DoItAction implements ActionListener {
    private Integer oColumn;
    private Integer oRow;
    private Sopa oFrame;
    private String txt;
    private JTextPane pane;
    public DoItAction( Sopa fr) {
        oFrame = fr;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Random r = new Random();
        int letra;
        try {
        pane=oFrame.getPalabrasEncontradas();
        oColumn = Integer.valueOf(oFrame.getEdtFilas().getText());
        oRow = Integer.valueOf(oFrame.getEdtColumnas().getText());
        JLabel[][] matriz = new JLabel[oRow][oColumn];
        txt=oFrame.getNombre().getText();
        TextFile t= new TextFile(txt,READ,true);
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
         v.doit(sopita, dimension[1], dimension[0], matriz, oFrame);
         v.ver(sopita,dimension[1],dimension[0],dimension[2],palabras,matriz,oFrame,pane); 
    
                
         
        
        
            
           
            
           
        } catch (NumberFormatException e2) {
            System.out.println("Error");
        
            
        } catch (IOException ex) {
            Logger.getLogger(DoItAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArchivoInexistenteException ex) {
            Logger.getLogger(DoItAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}


class Buscar implements ActionListener{
    Sopa l;
    JTextField lo;
    JTextField col;
    JTextField fil;
    public Buscar(JTextField t,JTextField col,JTextField fil){
        lo=t;
        this.col=col;
        this.fil=fil;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileOpen = new JFileChooser();
        fileOpen.setMultiSelectionEnabled(true);
        fileOpen.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int ret = fileOpen.showDialog(new JPanel(), "Seleecionar Archivos");
        if (ret == JFileChooser.APPROVE_OPTION) {
            lo.setText(fileOpen.getSelectedFile().getPath());
            System.out.println(fileOpen.getSelectedFile().getPath());
            try {
                TextFile t=new TextFile(fileOpen.getSelectedFile().getPath(), READ, true);
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
            col.setText(Integer.toString(dimension[1]));
            fil.setText(Integer.toString(dimension[0]));
            
            
            } catch (IOException ex) {
                Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ArchivoInexistenteException ex) {
                Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
} 