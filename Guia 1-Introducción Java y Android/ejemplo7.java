import java.util.Scanner;

public class ejemplo7 {
    private Scanner teclado;
    private String[] nombres;
    private String[] mail;

    /*Clase armadora siempre debe llevar el mismo nombre */
    public ejemplo7(){
        teclado=new Scanner(System.in);
        nombres=new String[5];
        mail=new String[5];
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingrese nombre: ");
            nombres[i]=teclado.nextLine();
            System.out.print("Ingrese mail");
            mail[i]=teclado.nextLine();
        }
    }

    public void listar(){
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i]+" - "+mail[i]);
        }
    }

    public void consultaMail(){
        String aux;
        System.out.print("Ingrese el nombre de la persona:");
        aux=teclado.nextLine();
        boolean existe=false;
        for (int i = 0; i < nombres.length; i++) {
            if (aux.equals(nombres[i])) {
                System.out.println("Mail de la persona: "+mail[i]);
                existe=true;
            }
        }
        if (existe==false) {
            System.out.println("No existe una persona con ese nombre");
        }
    }

    public void sinArroba(){
        for (int i = 0; i < mail.length; i++) {
            boolean tiene=false;
            for (int j = 0; j < mail[i].length(); j++) {
                if (mail[i].charAt(j)=='@') {
                    tiene=true;
                }
            }
            if (tiene==false) {
                System.out.println(mail[i]+"No tiene @");
            }
        }
    }

    public static void main(String[] args) {
        ejemplo7 cad=new ejemplo7();
        cad.listar();
        cad.consultaMail();
        cad.sinArroba();
    }
}
