/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

import proyectopatronespack.Utils;

/**
 * Esta clase representa un singleton de la linea de comandos.
 * @author Naely Rubio
 */
public class CommandLineSingleton {
    private String servicio;
    private String paquete;
    private String distancia;
    private static CommandLineSingleton singleton;
    
    public CommandLineSingleton(String[] args){
        servicio = Utils.SplitCommand(args, "servicio", null);
        paquete = Utils.SplitCommand(args, "paquete", null);
        distancia = Utils.SplitCommand(args, "distancia", null);
    }

    public String getServicio() {
        return servicio;
    }

    public String getPaquete() {
        return paquete;
    }

    public String getDistancia() {
        return distancia;
    }
    
    public boolean isValid(){
        
        if (getServicio() == null){
            System.out.println("[-] Debe escribir un parametro --servicio valido.");
            return false;
        }
        
        if (getPaquete() == null){
            System.out.println("[-] Debe escribir un parametro --paquete valido.");
            return false;
        }
        
        if (getDistancia() == null){
            System.out.println("[-] Debe escribir un parametro --distancia valido.");
            return false;
        }
        
        return true;
    }
    
    public static CommandLineSingleton GetSingleton(String[] args){
        if (singleton == null){
            singleton = new CommandLineSingleton(args);
        }
        
        return singleton;
    }
}
