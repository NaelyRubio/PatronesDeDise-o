/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatronespack;

/**
 * Esta excepción representa un error de cálculo en los Composite ICalculadora.
 * @author Naely Rubio
 */
public class InvalidDataException extends Exception {
    public InvalidDataException(String exception){
        super(exception);
    }
}
