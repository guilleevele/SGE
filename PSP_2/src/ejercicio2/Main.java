/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;


public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(6); //es de 6 porque es del 0-6 (7)
        HiloGenerador h1 = new HiloGenerador(buffer);
        HiloConsumidor h2 = new HiloConsumidor(buffer);
    
        h1.start();
        h2.start();
    }
    
}
