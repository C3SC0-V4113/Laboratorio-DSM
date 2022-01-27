import java.util.Scanner;

public class ejemplo3_1 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        float sueldo;
        System.out.print("Ingrese el suledo: ");
        sueldo=teclado.nextFloat();
        if(sueldo>3000){
            System.out.println("Esta persona debe abonar impuestos");
        }   
    }
}
