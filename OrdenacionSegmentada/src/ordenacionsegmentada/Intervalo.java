/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ordenacionsegmentada;

/**
 *
 * @author javier
 */
public class Intervalo {
    private Integer minimo;
    private Integer maximo;
    
    public Intervalo (Integer min , Integer max){
        minimo=min;
        maximo=max;
    }

    public Integer getMinimo() {
        return minimo;
    }

    public void setMinimo(Integer minimo) {
        this.minimo = minimo;
    }

    public Integer getMaximo() {
        return maximo;
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }
    
    
    
}
