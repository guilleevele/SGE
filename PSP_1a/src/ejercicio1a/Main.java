/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1a;


public class Main {
    
    public static void main(String[] args) {
        String[] palabra = {"piedra","papel","tijera"};
        int indice = generaNumeroAleatorio(0,2);
        System.out.println(palabra[indice]);
    }
    
    //Método para generar números aleatorios
    private static int generaNumeroAleatorio(int minimo, int maximo) {
        int numero = (int)(Math.random()*(maximo-minimo+1)+(minimo));
        return numero;
    }
    
}
