package ejercicio1_p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author guill
 */
public class ordenarNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            String linea = sc.nextLine();
            String[] numerosLinea = linea.split(" ");
            
            int numeros[] = new int[numerosLinea.length];
            for(int i=0; i<numeros.length; i++){
                numeros[i] = Integer.parseInt(numerosLinea[i]);
            }
            
            Arrays.sort(numeros);
            System.out.println("Números ordenados:");
            for(int i=0;i<numeros.length;i++){
                System.out.print(numeros[i]+" ");
            }
    }
    
}