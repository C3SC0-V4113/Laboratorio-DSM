import java.util.Scanner;
public class ejemplo5 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int suma,i,valor,promedio;
        suma=0;
        for (i = 1; i < 10; i++) {
            System.out.print("Ingrese valor:");
            valor=teclado.nextInt();
            suma=suma+valor;
        }
        System.out.print("La suma es: ");
        System.out.println(suma);
        promedio=suma/10;
        System.out.print("El promedio es: ");
        System.out.println(promedio);
    }
}
