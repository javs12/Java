/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package impuesto;

/**
 *
 * @author Alonso Vasquez Francisco Javier
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Particular p=new Particular("12D3FE","123","Ford",2002,120000f);
         Taxi t=new Taxi("123E","123","Nissan",2002,150000f,4f);
         Camioneta c=new Camioneta("13434", "134","Chevrolet",2000,120000f,4f,true);
         Camion c1=new Camion("23ERF1,","2345,","Chafa,",2011,200000f,7f,2,false);
         Listado lista=new Listado();
         try{
             
             lista.agregar(c1);
             lista.agregar(t);
             lista.compara(c);
             lista.agregar(c);
             lista.compara(p);
             lista.agregar(p);
         }catch(placaRepetidaExeption | noSerieRepetidoExeption ex){
             System.out.println(ex.getMessage());
         }finally{
             lista.mostrarCoches();
         }
                 
         
          
        
    }
    
}
