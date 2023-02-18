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
import proyectoPatrones.models.TipoServicio;

/**
 * Este composite sirve para calcular el tipo de servicio según el dato entregado.
 * @author Naely Rubio
 */
public class TipoServicioComposite extends Resultset implements ICalculadora<TipoServicio> {
    
    public TipoServicioComposite(TipoServicio ... tiposServicio){
       super("Tipo de servicio", tiposServicio);
    }
    
    /**
     * Devuelve un tipo de servicio de acuerdo al tipo indicado.
     * Si no se encuentra, arroja una excepcion tipo InvalidDataException.
     * @param dato
     * @return TipoServicio
     * @throws InvalidDataException
     */
    @Override
    public TipoServicio calcular(String dato) throws InvalidDataException {
        TipoServicio tipoServicio = (TipoServicio)this.findRowByKey(dato);
        
        if (tipoServicio != null)
            return tipoServicio;
        
        throwNotFound(dato);
        return null;
    }
    
}
