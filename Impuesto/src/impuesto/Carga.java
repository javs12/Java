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
public abstract  class Carga extends Vehiculo  {
    private Float toneladas;
    private Boolean publico;
    
  

    public Float getToneladas() {
        return toneladas;
    }

    public void setToneladas(Float toneladas) {
        this.toneladas = toneladas;
    }

    public Boolean isPublico() {
        return publico;
    }

    public void setPublico(Boolean publico) {
        this.publico = publico;
    }
    
    public Float calcularBaseGravable(){
        
        Float baseGravable=0f;
        if(isPublico()){
           if(getModelo()>=2002){
            baseGravable =  0.03f;
        } else if(getModelo() < 2002){
            baseGravable =  0.01f;
        }   
       }else  if(getModelo()>=2002){
            baseGravable =  0.05f;
        } else if(getModelo() < 2002){
            baseGravable = 0.02f;
        }   
        return baseGravable;
    }
    
}
