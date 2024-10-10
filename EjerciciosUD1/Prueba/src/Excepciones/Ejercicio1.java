package Excepciones;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contador = 0;


        do {
            try {

                    System.out.print("N "+(contador+1)+": ");
                    sc.nextInt();
                    contador++;

            }catch (Exception e){
                System.out.println("El dato introducido no es correcto, debe ser un numero entero.");
                System.out.println("Por favor intentelo de nuevo");
                sc.next();
            }
        }while (contador < 10);

    }
}
