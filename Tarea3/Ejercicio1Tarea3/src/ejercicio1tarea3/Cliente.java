/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1tarea3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Socket socket = new Socket("localhost",2000);
            
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            Scanner sc= new Scanner(System.in);
            int numeroCliente;
            boolean exito = false;
            do{
                System.out.println("Indique un número entre 0 y 100");
                numeroCliente=sc.nextInt();
                out.writeInt(numeroCliente);
                
                String mensaje = in.readUTF();
                System.out.println(mensaje);
                exito = in.readBoolean();
            }while(!exito);
            
            sc.close();
               
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
