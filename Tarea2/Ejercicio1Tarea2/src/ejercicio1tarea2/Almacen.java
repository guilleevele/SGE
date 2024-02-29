/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1tarea2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class Almacen {
    
    private char[] almacen;
    private boolean lleno;
    private boolean vacio;
    private int tamaño=6;
    private int ubicacion; //donde vamos a meter el siguiente valor
    
    public Almacen(){
        this.almacen= new char[tamaño];
        this.lleno=false;
        this.vacio=true;
        this.ubicacion=0;
    }
    
    public synchronized char extraerLetra(){
        
        while(this.vacio){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.ubicacion--;
        this.lleno=false;
        if(this.ubicacion==0)this.vacio=true;
        
        notifyAll();
        
        return this.almacen[this.ubicacion];
    }
    
    public synchronized void guardarLetra(char c){
        
        while(this.lleno){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.almacen[this.ubicacion]=c;
        this.ubicacion++;
        this.vacio=false;
        
        if(this.ubicacion==this.almacen.length){
            this.lleno=true;
        }
        
        notifyAll();
    }
    
    
}
