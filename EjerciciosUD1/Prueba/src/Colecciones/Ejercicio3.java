package Colecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ejercicio3 {
    public static void main(String[] args) {
        ArrayList<String> listaOriginal = new ArrayList<String>();
        //ArrayList<String> listaOrdenada = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce 10 palabras:  ");
        for (int i = 0; i<10; i++){
            System.out.print(": ");
            listaOriginal.add(sc.next());
        }

        System.out.print("\nLista Original: ");
        imprimirLista(listaOriginal);

        List<String> listaOrdenada = listaOriginal.stream().sorted().collect(Collectors.toList());
        System.out.print("\nLista Ordenada: ");

        imprimirLista(listaOrdenada);

    }

    public static void imprimirLista(List lista){
        for (int i = 0; i<lista.size();i++){
            if (i != lista.size() -1) System.out.print(lista.get(i)+", ");
            else System.out.print(lista.get(i));
        }
    }
}
