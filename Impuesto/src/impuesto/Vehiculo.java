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
public abstract class Vehiculo {
    private String placa;
    private String noSerie;
    private String marca;
    private Integer modelo;
    private Float valorFactura;
    
    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public Float getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(Float valorFactura) {
        this.valorFactura = valorFactura;
    }
    
    public abstract Float calcularTenencia();
    public Float calcularBaseGravable(){
        
        Float baseGravable=0f;
        
        
        if(modelo>=2002){
            baseGravable =  0.05f;
        } else if(modelo < 2002){
            baseGravable =  0.02f;
        }
       return baseGravable;   
    }
    @Override
    public String toString() {
        return " Placa: "+getPlaca()+ " Marca: "+getMarca()+" Modelo: "+getModelo()+" Tenencia :"+calcularTenencia();
    }
    
}
