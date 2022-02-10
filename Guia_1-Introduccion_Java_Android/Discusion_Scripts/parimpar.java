import java.util.*;

public class parimpar {
    public static void main(String[] args) {
        //Creando objeto de clase Scanner
        Scanner in=new Scanner(System.in);
        int par=0;
        int impar=0;
        //Obtener la cantidad n
        System.out.print("Escribe la cantidad de datos: ");
        int n=in.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Ingresa el dato "+(i+1)+": ");
            int x=in.nextInt();
            if (x%2==0) {
                par++;
            } else {
                impar++;
            }
        }
        System.out.println("\n\nHay "+(par)+" datos pares, hay "+(impar)+" datos impares");
    }
}
