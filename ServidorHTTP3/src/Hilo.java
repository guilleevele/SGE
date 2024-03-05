
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

        // Leer la solicitud del cliente
        if (peticion.startsWith("GET")) {
            // Construir la respuesta HTTP
            print.println("HTTP/1.1 200 OK");
                print.println("Content-Type:text/html;charset=UTF-8");
                print.println("Content-Length: 200");
                print.println("\n");
                print.println("<!DOCTYPE html>");
                print.println("<html>");
                print.println("<head>");
                print.println("<title>Fecha y hora</title>");
                print.println("</head>");
                print.println("<body>");
                print.println("<h1>Fecha y hora de Guillermo Torregrosa:</h1>");
                print.println("<p>" + date + "</p>");
                print.println("</body>");
                print.println("</html>");        }

        read.close();
        print.close();
    }

}
