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
public class Camion extends Carga {
    private Integer ejes;
    
    
    public Camion(String placa,String noSerie,String marca,Integer modelo,Float valorFactura,Float toneladas,Integer ejes,boolean s){
            setMarca(marca);
            setModelo(modelo);
            setNoSerie(noSerie);
            setPlaca(placa);
            setValorFactura(valorFactura);
            setToneladas(toneladas);
            setEjes(ejes);
            setPublico(s);
      }

    public Integer getEjes() {
        return ejes;
    }

    public void setEjes(Integer ejes) {
        this.ejes = ejes;
    }
    
   
    public Float calcularBaseGravable(){
         Float baseGravable=0f;
        if(isPublico()){
           if(getModelo()>=2002){
            baseGravable =   0.03f;
        } else if(getModelo() < 2002){
            baseGravable =  0.01f;
        }   
       }else  if(getModelo()>=2002){
            baseGravable =  0.05f;
        } else if(getModelo() < 2002){
            baseGravable =  0.02f;
        }
        
        baseGravable= baseGravable+0.1f*(float)ejes;
        return baseGravable;
    }
    
    public Float calcularTenencia(){
        Float tenencia;
        tenencia= getValorFactura()*(1+(getToneladas()/10))*calcularBaseGravable();
        return tenencia;
    }
    
    
    
}
