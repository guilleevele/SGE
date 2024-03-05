
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

        // Leer la solicitud del cliente
        if (peticion.startsWith("GET")) {
            // Construir la respuesta HTTP
            StringBuilder respuesta = new StringBuilder();
            respuesta.append("HTTP/1.1 200 OK\r\n");
            respuesta.append("Content-Type: text/html;charset=UTF-8\r\n\r\n");
            respuesta.append("<html><body>");
            respuesta.append("<h1>La fecha y hora de Guillermo Torregrosa</h1>");
            respuesta.append("<p>");
            respuesta.append("Fecha y hora del servidor: ").append(new Date());
            respuesta.append("</p>");
            respuesta.append("</body></html>");

            // Enviar la respuesta al cliente
            print.println(respuesta.toString());
        }

        // Cerrar los streams y el socket del cliente
        read.close();
        print.close();
    }

}
