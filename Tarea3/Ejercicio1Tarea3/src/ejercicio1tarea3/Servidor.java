/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1tarea3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            int numeroSecreto = (int) (Math.random()*100)+1;
            ServerSocket servidor = new ServerSocket(2000);
            
            while(true){
                Socket socket= servidor.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                
                int numeroCliente;
                do{
                    numeroCliente= in.readInt();
                    
                    if(numeroCliente < numeroSecreto){
                        out.writeUTF("El número secreto es mayor");
                        out.writeBoolean(false);
                    } else if (numeroCliente > numeroSecreto){
                        out.writeUTF("El número secreto es menor");
                        out.writeBoolean(false);
                    } else {
                        out.writeUTF("¡Enhorabuena! Has acertado el número");
                        out.writeBoolean(true);
                    }
                    
                }while(numeroCliente != numeroSecreto);
                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
}
