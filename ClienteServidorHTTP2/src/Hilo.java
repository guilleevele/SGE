
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author guill
 */
public class Hilo extends Thread {

    private Socket cliente;

    public Hilo(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        try {
            ejecutarPeticion(cliente);
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ejecutarPeticion(Socket cliente) throws IOException {
        PrintWriter print = new PrintWriter(cliente.getOutputStream(), true);
        BufferedReader read = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        String peticion;
        peticion = read.readLine();
        peticion = peticion.replaceAll(" ", "");
        
        Date date = new Date();
        
        String html = "<html>"
            + "<head><title>Fecha y Hora de Guillermo</title></head>"
            + "<body>"
            + "<h1>La fecha y hora de Guillermo Torregrosa</h1>"    
            + date
            + "</body>"
            + "</html>";
        String htmlError = "<html>"
            + "<head><title>noEncontrado</title></head>"
            + "<body>"
            + "<h1>¡ERROR! Página no encontrada</h1>"
            + "<p>La página no existe en nuestro servidor</p>"
            + "</body>"
            + "</html>";

        // Leer la solicitud del cliente
        if (peticion.startsWith("GET")) {
            peticion = peticion.substring(3, peticion.lastIndexOf("HTTP")); //extraemos la subcadena entre get y http/1.1
            if (peticion.length() == 0 || peticion.equals("/")) { //si  la peticion corresponde con la pagina de inicio
                print.println("HTTP/1.1 200 OK");
                print.println("Content-Type:text/html;charset=UTF-8");
                print.println("Content-Length: " + html.length() + 1);
                print.println("Date: " + date);                
                print.println("\n");
                print.println(html);
            }
            else {
                print.println("HTTP/1.1 404 Not Found");
                print.println("Content-Type:text/html;charset=UTF-8");
                print.println("Content-Length: " + htmlError.length() + 1);
                print.println("Date: " + date);                
                print.println("\n");
                print.println(htmlError);
            }
        }

        // Cerrar los streams y el socket del cliente
        read.close();
        print.close();
    }

}