import java.util.*;

public class notas {

    public static void main(String[] args) {
        //Creando elemento scanner
        Scanner in=new Scanner(System.in);
        Estudiante[] estudiantes;

        for (int i = 0; i < 2; i++) {
            System.out.print("Escribe el nombre: ");
            String nombre=in.nextLine();
            System.out.print("Escribe el apellido: ");
            String apellido=in.nextLine();
            System.out.print("Escribe la nota final: ");
            int nota=in.nextInt();
            Estudiante estudiante=new Estudiante(nombre, apellido, nota);
            estudiantes[i]=estudiante;
        }
        
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.print(estudiantes[i].NombreCompleto());
        }
        
    }

}

//Objeto Estudiante
class Estudiante{
    //Variables de Clase
    private String nombre;
    private String apellido;
    private int nota;

    //Constructor
    public Estudiante(String nombre, String apellido, Integer nota){
        this.nombre=nombre;
        this.apellido=apellido;
        this.nota=nota;
    }

    //Encapsulamiento
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }

    public Int getNota(){
        return nota;
    }
    public void setNota(Integer nota){
        this.nota=nota;
    }

    public String NombreCompleto(){
        return "Nombre: "+(this.nombre)+" "+(this.apellido);
    }
}
