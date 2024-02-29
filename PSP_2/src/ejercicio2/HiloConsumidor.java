/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;


public class HiloConsumidor extends Thread {
    private Buffer buffer;
    
    public HiloConsumidor(Buffer buffer){
        this.buffer=buffer;
    }
    
    @Override
    public void run(){
        while(true){
            if(buffer.getContenido()!=0){
                String palabraClave = buffer.consumir();
                System.out.println("consumidor: quito " + palabraClave);
                int tiempoAleatorio = generaNumeroAleatorio(1,300);
                try {
                    sleep(tiempoAleatorio);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloConsumidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Me aburro");
                int tiempoAleatorio = generaNumeroAleatorio(1,300);
                try {
                    sleep(tiempoAleatorio);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloConsumidor.class.getName()).log(Level.SEVERE, null, ex);
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
