import java.util.*;

public class coordenadas {
    public static void main(String[] args) {
        // Creando objeto de clase Scanner
        Scanner in = new Scanner(System.in);
        int cuadrante1=0;
        int cuadrante2=0;
        int cuadrante3=0;
        int cuadrante4=0;
        int inter=0;
        System.out.print("Escribe la cantidad de datos: ");
        int n=in.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Ingresa la coordenada 'x' del dato "+(i+1)+": ");
            int x=in.nextInt();
            System.out.print("Ingresa la coordenada 'y' del dato "+(i+1)+": ");
            int y=in.nextInt();
            if (x<0) {
                if (y<0) {
                    cuadrante3++;
                } else {
                    if (y==0) {
                        inter++;
                    } else {
                        cuadrante2++;
                    }
                }
            } else {
                if (x==0) {
                    inter++;
                } else {
                    if(y<0){
                        cuadrante4++;
                    }
                    else{
                        if (y==0) {
                            inter++;
                        } else {
                            cuadrante1++;
                        }
                    }
                }
            }
        }
        System.out.println("\n\nLos cuadrantes están asi: \nCuadrante 1: "+(cuadrante1)+"\nCuadrante 2: "+(cuadrante2)+"\nCuadrante 3: "+(cuadrante3)+"\nCuadrante 4: "+(cuadrante4)+"\nEntre cuadrantes: "+(inter));
    }
}
