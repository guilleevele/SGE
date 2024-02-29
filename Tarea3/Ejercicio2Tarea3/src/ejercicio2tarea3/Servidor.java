/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2tarea3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.net.ServerSocket;
import java.net.Socket;

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
            ServerSocket servidor = new ServerSocket(1500);

            while (true) {
                Socket socket = servidor.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String ruta = in.readUTF();

                File fichero = new File(ruta);
                if (fichero.exists()) {
                    out.writeBoolean(true);

                    BufferedReader br = new BufferedReader(new FileReader(ruta));
                    String linea = "";
                    String texto = "";
                    while ((linea = br.readLine()) != null) {
                        texto += linea + "\r\n";
                    }
                    byte[] documento = texto.getBytes();

                    out.writeInt(documento.length);
                    for (int i = 0; i < documento.length; i++) {
                        out.writeByte(documento[i]);
                    }

                    br.close();
                } else {
                    out.writeBoolean(false);
                }

                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
