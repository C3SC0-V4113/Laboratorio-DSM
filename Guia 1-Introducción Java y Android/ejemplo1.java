import java.util.*;

public class Main{
  public static void main(String[] args){
    //Creando un objeto de la clase Scanner
    Scanner in=new Scanner(System.in);
    //Obtener el primer dato
    System.out.print("¿Cómo te llamas?");
    String nombre=in.nextLine();

    //Obtener el segundo dato
    System.out.print("¿Cuántos años tienes?");
    Int edad=int.nextInt();

    //Mostrar el resultado en la consola
    System.out.println("Hola, "+nombre+". Dentro de poco tendrás "+(edad+1)+" años");
  }
}