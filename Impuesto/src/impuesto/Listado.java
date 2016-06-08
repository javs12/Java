/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package impuesto;

import java.util.ArrayList;


/**
 *
 * @author javier
 */
public class Listado {
     ArrayList<Vehiculo> vehiculos = new ArrayList<>();
     
     
     public void compara(Vehiculo p)throws placaRepetidaExeption, noSerieRepetidoExeption{
        
         for(int i = 0; i< vehiculos.size(); i++){
           if(vehiculos.get(i).getNoSerie().equals(p.getNoSerie())){
                    throw new placaRepetidaExeption("El No de serie esta repetido--> "+p.getNoSerie());
                }else if(vehiculos.get(i).getPlaca().equals(p.getPlaca())){

                    throw new noSerieRepetidoExeption("La placa esta repetida--> "+p.getPlaca());
                }
         }

     }
     
     public void agregar(Vehiculo p){
        
         vehiculos.add(p);
         
     }
     
     public void mostrarCoches(){
         System.out.println("*****Lista de vehiculos*****");
        for(int i = 0; i< vehiculos.size(); i++)
            System.out.println(vehiculos.get(i));  //se invoca el método toString de la clase Coche
    }
    
}
