import java.util.Scanner;

public class ejemplo2 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int num1,num2,suma,producto;
        System.out.print("Ingrese primer valor: ");
        num1=teclado.nextInt();

        System.out.print("Ingrese segundo valor: ");
        num2=teclado.nextInt();

        suma=num1+num2;
        producto=num1*num2;

        System.out.print("La suma de los valores es: ");
        System.out.println(suma);

        System.out.print("El producto de los valores es: ");
        System.out.println(producto);
    }
}
