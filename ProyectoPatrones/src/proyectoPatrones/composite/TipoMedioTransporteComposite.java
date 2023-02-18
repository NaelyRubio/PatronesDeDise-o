/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoPatrones.composite;

import java.util.ArrayList;
import java.util.Arrays;
import proyectopatronespack.ICalculadora;
import proyectopatronespack.InvalidDataException;
import proyectoPatrones.models.Resultset;
import proyectoPatrones.models.TipoMedioTransporte;

/**
 * Este composite sirve para calcular el tipo de medio de transporte según el dato entregado.
 * @author Naely Rubio
 */
public class TipoMedioTransporteComposite extends Resultset implements ICalculadora<TipoMedioTransporte> {
    
    public TipoMedioTransporteComposite(TipoMedioTransporte ... tiposMedioTransporte){
       super("Tipo de medio de transporte", tiposMedioTransporte);
    }

    /**
     * Devuelve un tipo de medio de transporte de acuerdo al tipo indicado.
     * Si no se encuentra, arroja una excepcion tipo InvalidDataException.
     * @param dato
     * @return MedioTransporte
     * @throws InvalidDataException
     */
    @Override
    public TipoMedioTransporte calcular(String dato) throws InvalidDataException {
        TipoMedioTransporte medioTransporte = (TipoMedioTransporte)this.findRowByKey(dato);
        
        if (medioTransporte != null)
            return medioTransporte;
         
        throwNotFound(dato);
        return null;
    }
    
}
