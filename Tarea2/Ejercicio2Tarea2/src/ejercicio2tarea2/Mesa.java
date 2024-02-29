/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2tarea2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author guill
 */
public class Mesa {
    
    private Semaphore[] palillos;
    private int comensales = 5; 
    
    public Mesa(){
        this.palillos= new Semaphore[comensales];
        for(int i=0;i<comensales;i++){
            this.palillos[i]=new Semaphore(1);//El 1 indica cuántos hilos permite el semaforo(si alguien tiene el palillo, nadie mas lo tiene)
        }
    }
    
    /**
     * El filosofo coge los palillos de su derecha e izquierda y los deja inutilizados para el resto de comensales
     * @param nombre Número asignado al filósofo
     * @throws InterruptedException 
     */
    public void cogerPalillo(int nombre) throws InterruptedException{
        this.palillos[this.cogerIzquierdo(nombre)].acquire();
        this.palillos[this.cogerDerecho(nombre)].acquire();
    }
    
    /**
     * El filosofo deja libres los palillos que estuvo utilizando
     * @param nombre Número asignado al filósofo
     */
    public void soltarPalillo(int nombre){
        this.palillos[this.cogerIzquierdo(nombre)].release();
        this.palillos[this.cogerDerecho(nombre)].release();
    }
    
    /**
     * Indicar cuál es el palillo de la izquierda
     * @param i Índice del filósofo
     * @return Devuelve el número del palillo, que siempre es igual al índice del filósofo
     */
    public int cogerIzquierdo(int i){
        return i;
    }
    
    /**
     * Indicar cuál es el palillo de la derecha
     * @param i Índice del filósofo
     * @return Devuelve el número del palillo, que siempre es igual al índice del filósofo menos uno excepto si es el índice 0, que entonces usa el último palillo del índice
     */
    public int cogerDerecho(int i){
        if(i==0){
            return this.palillos.length - 1;
        }
        else{
            return i-1;
        }
    }
    
}
