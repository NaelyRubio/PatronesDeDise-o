/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoPatrones.composite;

import proyectopatronespack.ICalculadora;
import proyectopatronespack.InvalidDataException;
import proyectoPatrones.models.Resultset;
import proyectoPatrones.models.TipoPaquete;

/**
 * Este composite sirve para calcular el tipo de paquete según el dato entregado.
 * @author Naely Rubio
 */
public class TipoPaqueteComposite extends Resultset implements ICalculadora<TipoPaquete>{
    
    public TipoPaqueteComposite(TipoPaquete ... tiposPaquete){
       super("Tipo de paquete", tiposPaquete);
    }
    
    /**
     * Devuelve un tipo de paquete de acuerdo al tipo indicado.
     * Si no se encuentra, arroja una excepcion tipo InvalidDataException.
     * @param dato
     * @return TipoPaquete
     * @throws InvalidDataException
     */
    @Override
    public TipoPaquete calcular(String dato) throws InvalidDataException {
        TipoPaquete tipoPaquete = (TipoPaquete)this.findRowByKey(dato);
        
        if (tipoPaquete != null)
            return tipoPaquete;
         
        throwNotFound(dato);
        return null;
    }
}
