package Colecciones;


import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {

        ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
        int tamanyoArray = (int)(Math.random()*10+10);

        for (int i = 0; i<tamanyoArray;i++){
            int aux = (int)(Math.random()*100);
            listaNumeros.add(aux);
        }

        int sumaTot = calcularSuma(listaNumeros);
        System.out.println(sumaTot);

        double media = calcularMedia(listaNumeros);
        System.out.println(media);

        int maximo = listaNumeros.get(0);
        for (int i = 0; i<listaNumeros.size();i++){
            if (maximo < listaNumeros.get(i)) maximo = listaNumeros.get(i);
        }
        System.out.println(maximo);

        int minimo = listaNumeros.get(0);
        for (int i = 0; i<listaNumeros.size();i++){
            if (minimo > listaNumeros.get(i)) minimo = listaNumeros.get(i);
        }
        System.out.println(minimo);
    }

    static int calcularSuma(List lista){
        int sumatorio = 0;
        for (int i = 0; i<lista.size();i++){
            sumatorio += (int) lista.get(i);
        }
        return sumatorio;
    }
    static double calcularMedia(List lista){
        return (double) calcularSuma(lista) / lista.size();
    }
}
