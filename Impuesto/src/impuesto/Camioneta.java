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
public class Camioneta extends Carga {
        
    public Camioneta(String placa,String noSerie,String marca,Integer modelo,Float valorFactura,Float toneladas,boolean s){
            setMarca(marca);
            setModelo(modelo);
            setNoSerie(noSerie);
            setPlaca(placa);
            setValorFactura(valorFactura);
            setToneladas(toneladas);
            setPublico(s);
            
      }
    
    public Float calcularTenencia(){
        Float tenencia;
        tenencia= getValorFactura()*(1+(getToneladas()  / 10 ))*calcularBaseGravable();
        return tenencia;
    }
    
  
}
