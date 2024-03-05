
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author guill
 */
public class Servidor {

    public static void main(String[] args) {
        
        try {
            ServerSocket servidor = new ServerSocket(8066);
            Socket cliente;
            
            while(true){
                cliente = servidor.accept();
                Hilo hilo = new Hilo(cliente);
                hilo.start();
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
