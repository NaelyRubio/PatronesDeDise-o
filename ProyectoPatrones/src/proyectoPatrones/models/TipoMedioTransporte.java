/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoPatrones.models;

/**
 * Esta clase representa un modelo de tipo de medio de transporte.
 * @author Naely Rubio
 */
public class TipoMedioTransporte extends Modelo {
    protected float velocidadPromedio;

    public TipoMedioTransporte(String[] keys, String nombre, float costo, float velocidadPromedio) {
        super(keys, nombre, costo);
        this.velocidadPromedio = velocidadPromedio;        
    }

    public float getVelocidadPromedio() {
        return velocidadPromedio;
    }
    
    
}
