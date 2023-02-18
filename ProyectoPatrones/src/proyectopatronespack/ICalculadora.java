/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatronespack;

import java.util.ArrayList;
import proyectoPatrones.models.TipoMedioTransporte;

/**
 * Interfaz composite de Calculadora.
 * @author Naely Rubio
 */
public interface ICalculadora<T> {
    public T calcular(String dato) throws InvalidDataException;
}
