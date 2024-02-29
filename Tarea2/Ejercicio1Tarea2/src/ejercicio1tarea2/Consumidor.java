/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1tarea2;

/**
 *
 * @author guill
 */
public class Consumidor extends Thread{
    
    private Almacen almacen;
    private int consumidas;
    private final int limite = 15;
    
    public Consumidor(Almacen almacen){
        this.consumidas=0;
        this.almacen=almacen;
    }
    
    public void run(){
        while(consumidas<limite){
            char c = almacen.extraerLetra();
            consumidas++;
            System.out.println("Se ha extraido el caracter "+c+" del almacen");
        }
    }
    
}
