/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoPatrones.models;

/**
 * La clase modelo representa un modelo de datos como un tipo de medio de
 * transporte, paquete o servicio.
 *
 * @author Naely Rubio
 */
public class Modelo {

    protected String[] keys;
    protected String nombre;
    protected float costo;

    public Modelo(String[] keys, String nombre, float costo) {
        this.keys = keys;
        this.nombre = nombre;
        this.costo = costo;
    }

    /**
     * Esta función devuelve true si dentro del arreglo de "keys" del modelo se
     * encuentra el argumento o dato indicado. Por ejemplo, si tenemos como
     * llaves para identificar a "Caja pequeña" como {"caja_pequena",
     * "cajapequena", ...} si se entrega "caja_pequena" devolverá true.
     *
     * @param arg
     * @return
     */
    public boolean matchesKeys(String arg) {
        for (String key : keys) {
            if (key.equalsIgnoreCase(arg)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devuelve el arreglo de llaves que identifican la modelo.
     *
     * @return
     */
    public String[] getKeys() {
        return keys;
    }

    /**
     * Devuelve el nombre del renglón del modelo.
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el costo del renglón del modelo.
     *
     * @return
     */
    public float getCosto() {
        return costo;
    }
}
