/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2tarea2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class Filosofo extends Thread{
    
    private Mesa mesa;
    private int nombre;
    private int indice;
    
    public Filosofo(Mesa mesa, int nombre){
        this.nombre=nombre;
        this.indice=nombre-1;
        this.mesa=mesa;
    }
    
    public void run(){
        while(true){
            try {
                System.out.println("Filósofo "+nombre+" Pensando");
                Thread.sleep(3000);
                System.out.println("Filósofo "+nombre+" Hambriento");
                mesa.cogerPalillo(indice);
                System.out.println("Filósofo "+nombre+" Comiendo");
                Thread.sleep(3000);
                System.out.println("Filósofo "+nombre+" Termina de comer. Palillos libres: "+(this.mesa.cogerIzquierdo(indice)+1)+" y "+(this.mesa.cogerDerecho(indice)+1));
                mesa.soltarPalillo(indice);
            } catch (InterruptedException ex) {
                Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    }
    
}
