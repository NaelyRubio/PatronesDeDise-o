/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoPatrones.composite;

import singleton.CommandLineSingleton;
import proyectopatronespack.ICalculadora;
import proyectopatronespack.InvalidDataException;
import proyectoPatrones.models.ResultadoCalculo;
import proyectoPatrones.models.TipoMedioTransporte;
import proyectoPatrones.models.TipoPaquete;
import proyectoPatrones.models.TipoServicio;

/**
 * Este composite sirve para calcular el costo del servicio de paquetería en general.
 * @author Naely Rubio
 */
public class CalculadoraComposite implements ICalculadora<ResultadoCalculo> {

    @Override
    public ResultadoCalculo calcular(String dato) throws InvalidDataException {
        // Obtener singleton con los argumentos indicados. Al momento de la llamada,
        // Ya se debió haber creado un singleton anteriormente (en el main de la aplicación).
        CommandLineSingleton cli = CommandLineSingleton.GetSingleton(null);
        if (!cli.isValid()) {
            throw new InvalidDataException("No hay un singleton válido de la línea de comandos. Se debe invocar el singleton en el main de la aplicación con los args recibidos.");
        }

        // Crear composites con los tipos de transporte/servicio/paquetes disponibles.
        
        TipoMedioTransporteComposite tipoMedioTransporteComposite = new TipoMedioTransporteComposite(
                new TipoMedioTransporte(
                        new String[]{"bicicleta"}, "Bicicleta", 5.0f, 20.0f
                ),
                new TipoMedioTransporte(
                        new String[]{"dron"}, "Dron", 20.0f, 60.0f
                ),
                new TipoMedioTransporte(
                        new String[]{"motocicleta", "moto"}, "Motocicleta", 15.0f, 45.0f
                ),
                new TipoMedioTransporte(
                        new String[]{"automovil", "auto"}, "Automovil", 30.0f, 40.0f
                )
        );
        TipoPaqueteComposite tipoPaqueteComposite = new TipoPaqueteComposite(
                new TipoPaquete(
                        new String[]{"sobre"}, "Sobre", 5.0f
                ),
                new TipoPaquete(
                        new String[]{"caja_pequena", "caja_pequeña", "cajapequena", "cajapequeña", "pequeño", "pequeno"}, "Caja pequeña", 10.0f
                ),
                new TipoPaquete(
                        new String[]{"caja_mediana", "cajamediana", "mediano"}, "Caja mediana", 20.0f
                ),
                new TipoPaquete(
                        new String[]{"caja_grande", "cajagrande", "grande"}, "Caja grande", 50.0f
                )
        );

        TipoServicioComposite tipoServicioComposite = new TipoServicioComposite(
                new TipoServicio(
                        new String[]{"estandar", "estándar"}, "Estándar", 30.0f
                ),
                new TipoServicio(
                        new String[]{"express"}, "Express", 50.0f
                )
        );

        // 1) Determinar distancia, tipo de servicio y paquete segun argumentos.
        // Si calcular() no encuentra un registro, automaticamente arroja una excepcion InvalidDataException.
        float distancia = Float.valueOf(cli.getDistancia());
        if (distancia < 0 || Float.isInfinite(distancia) || Float.isNaN(distancia)) {
            throw new InvalidDataException("Argumento \"distancia\" inválido. Debe ser númerico y mayor a cero.");
        }

        TipoPaquete tipoPaquete = tipoPaqueteComposite.calcular(cli.getPaquete());
        TipoServicio tipoServicio = tipoServicioComposite.calcular(cli.getServicio());

        // 2) Realizar calculo dependiendo de la distancia y tipo de paquete.
        float costoTotal = 0.0f;
        TipoMedioTransporte tipoMedioTransporte = null;

        /* Especificacion pagina 10. Si el tipo de paquete es un sobre o caja pequeña y la 
        distancia es 1 Km o menos y el tipo de servicio es 
        Express, se utilizará el dron como medio de transporte. 
        En cambio si el tipo de servicio es Estándar, se utilizará 
        la bicicleta como medio de transporte. */
        if ((tipoPaquete.matchesKeys("sobre") || tipoPaquete.matchesKeys("pequeño"))
                && distancia <= 1) {
            if (tipoServicio.matchesKeys("express")) {
                tipoMedioTransporte = tipoMedioTransporteComposite.calcular("dron");
            } else {
                tipoMedioTransporte = tipoMedioTransporteComposite.calcular("bicicleta");
            }
        }

        /* Especificacion pagina 11. Si el tipo de paquete es un sobre o caja pequeña y la 
        distancia es mayor a 1 Km y el tipo de servicio es 
        Estándar, se utilizará la bicicleta como medio de 
        transporte. En cambio si el tipo de servicio es Express, 
        se utilizará la moto como medio de transporte.
         */
        else if ((tipoPaquete.matchesKeys("sobre") || tipoPaquete.matchesKeys("pequeño"))
                && distancia > 1) {
            if (tipoServicio.matchesKeys("express")) {
                tipoMedioTransporte = tipoMedioTransporteComposite.calcular("moto");
            } else {
                tipoMedioTransporte = tipoMedioTransporteComposite.calcular("bicicleta");
            }
        }
        
        /* Especificacion pagina 12. Si el tipo de paquete es mediano y la distancia es de 
        hasta 5 Km o menos y el tipo de servicio es Estándar, se 
        utilizará la bicicleta como medio de transporte. En 
        cambio si el tipo de servicio es Express o la distancia es 
        mayor a 5 Km se utilizará la moto como medio de transporte
         */
        else if ((tipoPaquete.matchesKeys("mediano"))) {
            if (tipoServicio.matchesKeys("express") || distancia > 5) {
                tipoMedioTransporte = tipoMedioTransporteComposite.calcular("moto");
            } else {
                tipoMedioTransporte = tipoMedioTransporteComposite.calcular("bicicleta");
            }
        }
        
        /* Especificacion pagina 13. Si el tipo de paquete es grande sin
        importar la distancia  ni el tipo de servicio, se utilizará el auto
        como medio de transporte
         */
        else if ((tipoPaquete.matchesKeys("grande"))) {
            tipoMedioTransporte = tipoMedioTransporteComposite.calcular("auto");
        }
        
        if (tipoMedioTransporte == null){
            throw new InvalidDataException("No se ha encontrado un tipo de medio de transporte según los parámetros indicados.");
        }
        
        // Sumar costos bases
        costoTotal += tipoServicio.getCosto();
        costoTotal += tipoPaquete.getCosto();
        costoTotal += tipoMedioTransporte.getCosto();
        
        /* Especificacion pagina 9.  Distancia (distancia entre la dirección de 
        recolección y entrega) en kilómetros (adiciona $5 pesos por cada 
        kilómetro si la distancia es mayor a 10 Km)
        */
        
        float costoKmExcedidos = 0.0f;
        if (distancia > 10.0f){
            int kmExcedidos = Math.round(distancia - 10);
            costoKmExcedidos = 5.0f * kmExcedidos;
        }
        costoTotal += costoKmExcedidos;
        
        int tiempoAproximado = Math.round((float)(distancia / tipoMedioTransporte.getVelocidadPromedio()) * 60.0f);
        
        // Crear objeto de resultado y devolverlo.
        ResultadoCalculo resultado = new ResultadoCalculo(tipoServicio, tipoPaquete, tipoMedioTransporte, costoTotal, costoKmExcedidos, tiempoAproximado);
        return resultado;
    }

}
