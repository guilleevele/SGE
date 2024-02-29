/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Buffer {
    private String[] buffer;
    private int contenido;
    private boolean lleno;
    private boolean vacio;
    
    public Buffer(int size){
        this.buffer = new String[size];
        this.contenido = 0;
        this.lleno = false;
        this.vacio = true;
    }
    
    public synchronized void generar(String palabra){
        //mientras esté lleno, espera.
        while(this.lleno){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        buffer[contenido] = palabra;
        this.contenido++;
        this.vacio=false;
        if(this.contenido==this.buffer.length){
            this.lleno=true;
        }
        notifyAll();
    }
    
    public synchronized String consumir(){
        //mientras esté vacío, espera.
        while(this.vacio){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.contenido--;
        if(this.contenido==0){
            this.vacio=true;
        }
        notifyAll();
        return this.buffer[this.contenido];
    }

    public int getContenido() {
        return contenido;
    }
    
    
}
