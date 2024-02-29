
/**
 *
 * @author guill
 */
public class Aleatorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int cantidad = generarAleatorio(50, 70);
        
        for (int i=0; i<cantidad; i++){
            System.out.print(generarAleatorio(0, 90)+" ");
        }
    }
    
    public static int generarAleatorio(int minimo, int maximo){
        int numero = (int)(Math.random()*(maximo-minimo+1)+(minimo));
        return numero;
    }  
}
