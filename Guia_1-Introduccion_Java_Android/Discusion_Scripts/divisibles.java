import java.util.*;

public class divisibles{
    public static void main(String[] args) {
        //Creando elemento scanner
        Scanner in=new Scanner(System.in);
        //Entrada de Datos
        System.out.print("Escribe el dividendo: ");
        int dividendo=in.nextInt();
        System.out.print("Escribe el divisor: ");
        int divisor=in.nextInt();

        //Proceso de datos
        int residuo=dividendo%divisor;
        if (residuo==0) {
            System.out.println("No hay residuo, por lo tanto son divisibles");
        } else {
            System.out.println("El residuo es: "+(residuo)+", son indivisibles");
        }

    }
}