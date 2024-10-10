package Colecciones;

import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<String>();
        String[] listaNombres = {"Ivan","Daniel","Emilia","Alejandro","Pruden","Nacho"};

        for (int i = 0; i< listaNombres.length;i++){
            nombres.add(listaNombres[i]);
        }

        for (int i = 0; i< nombres.size(); i++){
            System.out.println("Alumno -> "+nombres.get(i));
        }
    }
}
