/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1tarea2;

/**
 *
 * @author guill
 */
public class Productor extends Thread{
    
    private Almacen almacen;
    private final String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int producidas;
    private final int limite = 15;
    
    public Productor(Almacen almacen){
        this.producidas=0;
        this.almacen=almacen;
    }
    
    public void run(){
        while(producidas<limite){
            char c = letras.charAt((int)(Math.random()*letras.length()));
            almacen.guardarLetra(c);
            producidas++;
            System.out.println("Se ha guardado el caracter "+c+" en el almacen");
        }
    }
    
    
}
