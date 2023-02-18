/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatronespack;

/**
 * Clase de utilidades.
 * @author Naely Rubio
 */
public class Utils {
    /*
    Esta funcion desensambla un argumento de comando recibido. Por ejemplo, si se recibe:
    --servicio=estandar
    Devolvera un arreglo con [servicio, estandar] tipo String.
    */
    public static String SplitCommand(String[] args, String key, String defaultValue){
       // Iterar sobre cada argumento del arreglo de argumentos
       for(String arg : args){
           // Descomponer argumentos por "="
           String[] chunks = arg.split("=");
           // Remover los primeros dos caracteres del argumento "--" y validar su nombre.
           if (chunks[0].substring(2).toLowerCase().equals(key.toLowerCase())){
               // Si concuerda, entonces devolver el dato del argumento entregado.
               return chunks[1].toLowerCase();
           }
                   
       }
       // Si no, devolver el valor por defecto.
       return defaultValue;
    }
}
