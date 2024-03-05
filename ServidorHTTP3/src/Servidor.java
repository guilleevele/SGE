import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
            ServerSocket servidor = new ServerSocket(8888);
            ExecutorService exe = Executors.newFixedThreadPool(3);
            Socket cliente;
            
            while(true){
                cliente = servidor.accept();
                Hilo hilo = new Hilo(cliente);
                exe.execute(hilo);
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
