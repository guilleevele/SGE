/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1tarea2;

/**
 *
 * @author guill
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Almacen almacen = new Almacen();
        Productor productor = new Productor(almacen);
        Consumidor consumidor = new Consumidor(almacen);
        
        productor.start();
        consumidor.start();
        
    }
    
}
