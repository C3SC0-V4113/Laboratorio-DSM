import java.util.*;

public class notas {

    public static void main(String[] args) {
        //Creando elemento scanner
        Scanner in=new Scanner(System.in);
        //Variables necesarias
        Estudiante[] estudiantes=new Estudiante[10];
        int aprobados=0;
        int reprobados=0;
        //Lazo for de Entradas
        for (int i = 0; i < 10; i++) {
            System.out.println("Alumno "+(i+1));
            System.out.print("Escribe el nombre: ");
            String nombre=in.nextLine();
            System.out.print("Escribe el apellido: ");
            String apellido=in.nextLine();
            System.out.print("Escribe la nota final: ");
            int nota=Integer.parseInt(in.nextLine());
            Estudiante estudiante=new Estudiante(nombre, apellido, nota);
            estudiantes[i]=estudiante;
        }
        //Lazo for de Proceso y Salida
        System.out.println("\n\nDatos de los estudiantes");
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].getNota()>=7) {
                aprobados++;
            } else {
                reprobados++;
            }
            System.out.println(estudiantes[i].NombreCompleto());
        }
        System.out.println("\nEstudiantes aprobados: "+(aprobados)+", estudiantes reprobados: "+(reprobados));
        
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

    public Integer getNota(){
        return nota;
    }
    public void setNota(Integer nota){
        this.nota=nota;
    }

    public String NombreCompleto(){
        return "Nombre: "+(this.nombre)+" "+(this.apellido)+", Nota: "+(this.nota);
    }
}
