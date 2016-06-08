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
public class Taxi extends Pasajeros {
    private Integer aniosConcesion;
    
    
 public Taxi(String placa,String noSerie,String marca,Integer modelo,Float valorFactura,Float pasajeros){
     
     
            setMarca(marca);
            setModelo(modelo);
            setNoSerie(noSerie);
            setPlaca(placa);
            setValorFactura(valorFactura);
            setPasajeros(pasajeros);
    
 }
    public Integer getAniosConcesion() {
        return aniosConcesion;
    }

    public void setAniosConcesion(Integer aniosConcesion) {
        this.aniosConcesion = aniosConcesion;
    }
     
     public Float calcularTenencia(){
        Float tenencia;
        tenencia= (getValorFactura() * calcularBaseGravable())*(1+(getPasajeros()/10));
        return tenencia;
     }
    
    
}
