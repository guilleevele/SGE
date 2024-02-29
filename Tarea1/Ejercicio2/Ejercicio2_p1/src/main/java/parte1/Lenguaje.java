package parte1;


import java.io.File;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class Lenguaje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String nombreArchivo;
        FileLock bloqueo = null;
        RandomAccessFile raf = null;
        String letras = "abcdefghijklmnopqrstuvwxyz";

        if (args.length == 2) {
            try {

                int cantidadLineas = Integer.parseInt(args[0]);
                String osName = System.getProperty("os.name");
                //Si el OS es Windows, reemplazará las barras
                if (osName.toLowerCase().contains("win")) {
                    nombreArchivo = args[1].replace("\\", "\\\\");
                } else {
                    nombreArchivo = args[1];
                }

                File archivo = new File(nombreArchivo);
                //Si el archivo no existe, lo creará
                if (!archivo.exists()) {
                    archivo.createNewFile();
                }
                //Le concedemos permisos sobre el fichero
                raf = new RandomAccessFile(archivo, "rwd");
                //Iniciamos el bloqueo para proteger los datos
                bloqueo = raf.getChannel().lock();
                //Nos situamos al final del archivo
                raf.seek(archivo.length());

                for (int i = 0; i < cantidadLineas; i++) {
                    String linea = "";
                    int cantidadChar = 10;
                    //El programa decide qué letra añadir recibiendo un número aleatorio y luego seleccionando esa letra del String letras
                    for (int h = 0; h < cantidadChar; h++) {
                        linea += letras.charAt(generarAleatorio(0, letras.length() - 1));
                    }
                    //Salto de linea
                    raf.writeChars(linea + "\n");
                }
                //Liberamos el bloqueo
                bloqueo.release();
                bloqueo = null;
                raf.close();

            } catch (IOException ex) {
                Logger.getLogger(Lenguaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{System.out.println("El programa necesita dos argumentos.");}

    }

    public static int generarAleatorio(int minimo, int maximo) {
        int numero = (int) (Math.random() * (maximo - minimo + 1) + (minimo));
        return numero;
    }

}
//Añadir el pluggin en el pom.xml