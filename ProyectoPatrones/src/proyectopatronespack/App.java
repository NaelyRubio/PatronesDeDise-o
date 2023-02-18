/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatronespack;

import singleton.CommandLineSingleton;
import proyectoPatrones.composite.CalculadoraComposite;
import proyectoPatrones.models.ResultadoCalculo;

/**
 *
 * @author Naely Rubio
 */
public class App {

    /**
     * @param args the command line arguments
     * @throws proyectopatronespack.InvalidDataException
     */
    public static void main(String[] args) throws InvalidDataException {
        // Obtener singleton de la linea de comandos (CLI) con los parametros recibidos.
        CommandLineSingleton cli = CommandLineSingleton.GetSingleton(args);
        
        // Validar que los argumentos recibidos ean correctos.
        if (!cli.isValid())
            return;
        
        
        // Ejecutar calculadora de costos
        CalculadoraComposite calculadora = new CalculadoraComposite();
        ResultadoCalculo calculo = calculadora.calcular(null);
        
        if (calculo == null){
            System.out.println("ERROR: No se pudo calcular el costo.");
            return;
        }
        
        // Una vez obtenido el cálculo del composite, proceder a imprimirlo en consola.
        System.out.println(calculo.toString());
        
    }
    
}
