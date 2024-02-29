/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2tarea3;

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
            Socket socket = new Socket("localhost", 1500);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);

            System.out.println("Indica la ruta del archivo:");
            String ruta = sc.next();

            out.writeUTF(ruta);
            boolean rutaValida = in.readBoolean();
            boolean finTexto = false;

            if (rutaValida) {
                int tamaño = in.readInt();
                byte[] documento = new byte[tamaño];
                for (int i = 0; i < tamaño; i++) {
                    documento[i] = in.readByte();
                }

                String texto = new String(documento);
                System.out.println(texto);

            } else {
                System.out.println("No existe un fichero con esa ruta.");
            }

            sc.close();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
