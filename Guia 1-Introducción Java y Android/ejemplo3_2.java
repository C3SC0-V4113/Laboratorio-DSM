import java.util.Scanner;

public class ejemplo3_2 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int nota1,nota2,nota3;

        System.out.print("Ingrese primer nota: ");
        nota1=teclado.nextInt();
        System.out.print("Ingrese segunda nota: ");
        nota2=teclado.nextInt();
        System.out.print("Ingrese tercera nota: ");
        nota3=teclado.nextInt();

        int promedio=(nota1+nota2+nota3)/3;
        if (promedio>=7) {
            System.out.print("Promocionado");
        } else {
            if (promedio>=4) {
                System.out.print("Regular");
            } else {
                System.out.print("Reprobado");
            }
        }
    }
}
