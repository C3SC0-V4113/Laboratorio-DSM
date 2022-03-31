package udb.edu.sv.guia4.personasdbvc190544.datos;

public class Persona {
    private String dui;
    private String nombre;
    private String genero;
    private String fecha;
    String key;

    public Persona() {
    }

    public Persona(String dui, String nombre, String genero, String fecha) {
        this.dui = dui;
        this.nombre = nombre;
        this.fecha=fecha;
        this.genero=genero;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero=genero;
    }

    public String getFecha(){
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
