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
public class noSerieRepetidoExeption extends Exception {

    /**
     * Creates a new instance of <code>noSerieRepetidoExeption</code> without
     * detail message.
     */
    public noSerieRepetidoExeption() {
    }

    /**
     * Constructs an instance of <code>noSerieRepetidoExeption</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public noSerieRepetidoExeption(String msg) {
        super(msg);
    }
}
