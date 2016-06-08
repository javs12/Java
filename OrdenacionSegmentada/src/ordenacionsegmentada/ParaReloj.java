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
public class ParaReloj {
    private Integer verifica=0;
    private HiloReloj reloj;
    private Integer seg;
    public ParaReloj(Integer a, HiloReloj r){
        seg=a;
        reloj=r;
    }
    
    public void para(){
        verifica++;
        if(verifica==seg){
            reloj.stop();
        }
    }
}
