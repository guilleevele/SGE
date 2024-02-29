/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;


public class HiloGenerador extends Thread {
    private Buffer buffer;
    //private int producido;
    private String[] palabras = {"piedra","papel","tijera"};
    
    public HiloGenerador(Buffer buffer){
        this.buffer=buffer;
        //this.producido = 0;
    }
    
    @Override
    public void run(){
        while(true){ //hay que hacer que no genere más palabras de las que caben
            if(buffer.getContenido()!= 6){
                String palabraClave = palabras[generaNumeroAleatorio(0,2)];
                System.out.println("GENERADOR: Añado " + palabraClave);
                this.buffer.generar(palabraClave);
                try {
                    sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloGenerador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloGenerador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }
    
    
    //Método para generar números aleatorios
    private static int generaNumeroAleatorio(int minimo, int maximo) {
        int numero = (int)(Math.random()*(maximo-minimo+1)+(minimo));
        return numero;
    }
}
