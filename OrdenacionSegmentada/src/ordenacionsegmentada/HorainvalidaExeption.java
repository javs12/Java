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
public class HorainvalidaExeption extends Exception {

    /**
     * Creates a new instance of <code>HorainvalidaExeption</code> without
     * detail message.
     */
    public HorainvalidaExeption() {
    }

    /**
     * Constructs an instance of <code>HorainvalidaExeption</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public HorainvalidaExeption(String msg) {
        super(msg);
    }
}
