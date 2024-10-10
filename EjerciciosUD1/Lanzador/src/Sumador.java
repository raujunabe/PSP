import java.util.Scanner;

public class Sumador {

    public int suma(int n1, int n2){
        int sumaResultado = 0;
        for (int i = n1; i<= n2; i++) sumaResultado += i;
        return sumaResultado;
    }

    public static void main(String[] args) {

        Sumador sumador = new Sumador();


        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce num 01: ");
        int n1  = Integer.parseInt(args[0]);
        System.out.println("Introduce num 02: ");
        int n2 = Integer.parseInt(args[1]);
        System.out.println("El resultado de la suma es "+sumador.suma(n1,n2));



    }
}
