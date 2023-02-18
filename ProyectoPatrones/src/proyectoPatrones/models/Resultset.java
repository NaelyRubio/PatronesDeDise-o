/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoPatrones.models;

import java.util.ArrayList;
import java.util.Arrays;
import proyectopatronespack.InvalidDataException;

/**
 * Esta clase abstracta representa un resultset o pequeño conjunto de base de datos
 * tipo Modelo, se utiliza para buscar entre los Modelo(s) registrados renglones por sus llaves.
 * @author Naely Rubio
 */
public abstract class Resultset {
    protected String nombreModelo;
    protected ArrayList<Modelo> rows;
    
    // Recibe como argumentos el nombre del modelo y los renglones del modelo para agregar.
    public Resultset(String nombreModelo, Modelo ... data){
        this.nombreModelo = nombreModelo;
        rows = new ArrayList();
        rows.addAll(Arrays.asList(data));
    }
    
    /**
     * Esta función devuelve un renglón encontrado en el resultset según sus llaves.
     * Si ninguna llave concuerda del modelo, se devuelve null.
     * @param key
     * @return 
     */
    public Modelo findRowByKey(String key){
        for(Modelo row : rows){
            if (row.matchesKeys(key))
                return row;
        }
        return null;
    }
    
    /**
     * Esta función arroja un InvalidDataException con un mensaje.
     * El mensaje contiene las llaves disponibles de los modelos a identificar.
     * @param dato
     * @throws InvalidDataException 
     */
    public void throwNotFound(String dato) throws InvalidDataException {
        ArrayList<String> modelKeys = new ArrayList();
        
        // Construir lista de llaves disponibles para identificar modelos.
        for(Modelo row : rows){
            for (String key : row.getKeys()){
                modelKeys.add(key);
            }
        }
        
        String message = String.format("Dato inválido para obtener \"%s\". Se admite %s. Se recibió \"%s\"",
                nombreModelo,
                String.join("|", (String[])modelKeys.toArray()),
                dato
        );
        throw new InvalidDataException(message);
    }
}
