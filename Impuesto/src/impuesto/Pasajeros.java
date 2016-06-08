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
public abstract class Pasajeros extends Vehiculo {
    
    private Float pasajeros;
    
    
        
    
    public Float getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Float pasajeros) {
        this.pasajeros = pasajeros;
    }
    
    public Float calcularTenencia(){
        Float tenencia;
        tenencia= getValorFactura() * calcularBaseGravable();
        return tenencia;
    }
    
}
