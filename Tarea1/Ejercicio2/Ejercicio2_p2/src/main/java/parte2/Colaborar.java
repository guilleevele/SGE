package parte2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class Colaborar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (args.length == 1) {
            
            //Un bucle que dará valor a i, que usaremos para indicar el primer argumento del primer programa.
            //i deberá comenzar con un valor de 10 y a cada vuelta del bucle aumentar en otros 10, hasta llegar a 100.
            for (int i = 10; i <= 100; i += 10) {
                try {
                    String comando = "java -jar lenguaje.jar " + i + " " + args[0];
                    Runtime.getRuntime().exec(comando);
                } catch (SecurityException ex) {
                    System.err.println("Ha ocurrido un error de Seguridad.");
                } catch (IOException ex) {
                    Logger.getLogger(Colaborar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{System.out.println("El programa requiere un argumento");}

    }

}
