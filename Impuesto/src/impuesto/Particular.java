/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package impuesto;

/**
 *
 * @author javier
 */
public class Particular extends Pasajeros {

         public Particular(String placa,String noSerie,String marca,Integer modelo,Float valorFactura){
            setMarca(marca);
            setModelo(modelo);
            setNoSerie(noSerie);
            setPlaca(placa);
            setValorFactura(valorFactura);
             
          
             
         }
    
    
}
