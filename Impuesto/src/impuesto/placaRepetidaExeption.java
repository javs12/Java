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
public class placaRepetidaExeption extends Exception {

    /**
     * Creates a new instance of <code>placaRepetidaExeption</code> without
     * detail message.
     */
    public placaRepetidaExeption() {
    }

    /**
     * Constructs an instance of <code>placaRepetidaExeption</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public placaRepetidaExeption(String msg) {
        super(msg);
    }
}
