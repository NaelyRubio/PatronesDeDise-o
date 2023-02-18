/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoPatrones.models;

import proyectoPatrones.models.TipoMedioTransporte;
import proyectoPatrones.models.TipoServicio;
import proyectoPatrones.models.TipoPaquete;

/**
 * Esta clase representa el resultado de un cálculo y es necesaria
 * por el Composite de Calculadora (CalculadoraComposite).
 * @author Naely Rubio
 */
public class ResultadoCalculo {
    private TipoServicio tipoServicio;
    private TipoPaquete tipoPaquete;
    private TipoMedioTransporte tipoMedioTransporte;
    private float costoTotal;
    private float costoKmExcedidos;
    private int tiempoAproximado;

    public ResultadoCalculo(TipoServicio tipoServicio, TipoPaquete tipoPaquete, 
            TipoMedioTransporte tipoMedioTransporte, float costoTotal, float costoKmExcedidos, int tiempoAproximado) {
        this.tipoServicio = tipoServicio;
        this.tipoPaquete = tipoPaquete;
        this.tipoMedioTransporte = tipoMedioTransporte;
        this.costoTotal = costoTotal;
        this.costoKmExcedidos = costoKmExcedidos;
        this.tiempoAproximado = tiempoAproximado;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public TipoPaquete getTipoPaquete() {
        return tipoPaquete;
    }

    public TipoMedioTransporte getTipoMedioTransporte() {
        return tipoMedioTransporte;
    }

    public float getCostoTotal() {
        return costoTotal;
    }
    
    public int getTiempoAproximado() {
        return tiempoAproximado;
    }

    /**
     * Devuelve un mensaje con el resultado del calculo.
     * @return 
     */
    @Override
    public String toString() {
        return String.format(
                "El costo del servicio es $%.2f, se entregará en %s en un tiempo aproximado de %s minuto%s\n"
                        + "\n"
                        + "----------------\n"
                        + "$%.2f por servicio %s\n"
                        + "$%.2f por %s\n"
                        + "$%.2f por servicio en %s\n"
                        + "$%.2f por sobrepasar los 10 km ($5 por km adicional)\n"
                        + "----------------\n"
                        + "TOTAL ====> $%.2f",
                costoTotal,
                tipoMedioTransporte.nombre,
                tiempoAproximado,
                (tiempoAproximado > 1 || tiempoAproximado < 1 ? "s" : ""),
                tipoServicio.getCosto(), tipoServicio.getNombre(),
                tipoPaquete.getCosto(), tipoPaquete.getNombre(),
                tipoMedioTransporte.getCosto(), tipoMedioTransporte.getNombre(),
                costoKmExcedidos,
                costoTotal
        );
    }
    
    
    
}
