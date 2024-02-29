/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("¿Preparados?");
        Scanner sc = new Scanner(System.in);
        String respuestaUsuario = sc.next();
        
        if(respuestaUsuario.equals("si")){
            
            try {
                System.out.println("Jugador 1:");
                //ejecutar programa del apartado (PSP_Examen1a)
                String comando = "java -jar PSP_Examen1a.jar";
                Runtime.getRuntime().exec(comando);
                //recoger la salida
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader bf = new BufferedReader(isr);
                String jugada1 = bf.readLine();
                //imprimir
                System.out.println(jugada1);
            } catch (Exception e) {e.printStackTrace();}
            
            
            try {
                System.out.println("Jugador 2:");
                //ejecutar programa del apartado (PSP_Examen1a)
                String comando = "java -jar PSP_Examen1a.jar";
                Runtime.getRuntime().exec(comando);
                //recoger la salida
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader bf = new BufferedReader(isr);
                String jugada2 = bf.readLine();
                //imprimir
                System.out.println(jugada2);
            } catch (Exception e) {e.printStackTrace();}
            
        }
        
        
        sc.close();
    }
            
}
