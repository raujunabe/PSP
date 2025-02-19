package Stream_Datos;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Profesional> profesionales = new ArrayList<Profesional>();

    public static void main(String[] args) {

        profesionales.add(new Profesional("Juan", 30, 'M', 1));
        profesionales.add(new Profesional("María", 28, 'F', 2));
        profesionales.add(new Profesional("Pedro", 35, 'M', 1));
        profesionales.add(new Profesional("Ana", 25, 'F', 3));
        profesionales.add(new Profesional("Carlos", 40, 'M', 2));
        profesionales.add(new Profesional("Laura", 33, 'F', 1));
        profesionales.add(new Profesional("Luis", 29, 'M', 3));
        profesionales.add(new Profesional("Claudia", 31, 'F', 2));
        profesionales.add(new Profesional("Javier", 38, 'M', 1));
        profesionales.add(new Profesional("Elena", 26, 'F', 3));

        int numMenu = 0;


        while (numMenu != 4){
            System.out.println("SOFTWARE DE GESTIÓN DEL IBIS SPORT CLUB\n" +
                    "=======================================\n" +
                    "1. Introducir datos de un profesional\n" +
                    "2. Consulta con filtro\n" +
                    "3. Listado de nombres\n" +
                    "4. Salir");
            numMenu = sc.nextInt();

            switch (numMenu){
                case 1:
                    introducirDatos();
                    break;
                case 2:
                    int consulta = submenuConsultas();
                    consultas(consulta);
                    break;
                case 3:
                    listarNombres();
                    break;
                case 4:
                    System.out.println("Hasta luego! ");
                    break;
                default:
                    System.out.println("Opción incorrecta, porfavor introduzca una opción válida.");
            }


        }

    }

    static void introducirDatos(){
        System.out.println("Introduce el nombre del profesional: ");
        String nombreProfesional = sc.next();
        System.out.println("Introduce la edad del profesional: ");
        int edadProfesional = sc.nextInt();
        char genero = 'a';
        while (Character.toLowerCase(genero) != 'm' && Character.toLowerCase(genero) != 'f'){
            System.out.println("Introduce el genero del profesional (m-f): ");
            genero = sc.next().charAt(0);
            genero = Character.toLowerCase(genero);
        }
        int tipo = 0;
        while (tipo <= 0 || tipo >= 4){
            System.out.println("Introduce el tipo del profesional [1 (Jugador), 2 (Directivo), 3 (Fisio)]: ");
            tipo = sc.nextInt();
        }
        profesionales.add(new Profesional(nombreProfesional,edadProfesional,genero,tipo));
    }

    static int submenuConsultas(){
        int menuConsulta = 0;
        while (menuConsulta <= 0 || menuConsulta >= 5){
            System.out.println("Submenú de Consultas\n" +
                    "--------------------\n" +
                    "1. Profesionales por género\n" +
                    "2. Profesionales por tipo\n" +
                    "3. Profesionales por edad\n" +
                    "4. Volver");
            menuConsulta = sc.nextInt();
        }
        return menuConsulta;
    }

    static void consultas(int menu){
        switch (menu){
            case 1:
                System.out.println("Lista Hombres: ");
                profesionales.stream().filter(h -> h.getGenero() == 'm')
                        .forEach(System.out::println);
                System.out.println("Lista Mujeres: ");
                profesionales.stream().filter(f -> f.getGenero() == 'f')
                        .forEach(System.out::println);
                break;
            case 2:
                System.out.println("Lista Jugadores: ");
                profesionales.stream().filter(p -> p.getTipo_profesional() == 1)
                        .forEach(System.out::println);
                System.out.println("Lista Directivos: ");
                profesionales.stream().filter(p -> p.getTipo_profesional() == 2)
                        .forEach(System.out::println);
                System.out.println("Lista Fisios: ");
                profesionales.stream().filter(p -> p.getTipo_profesional() == 3)
                        .forEach(System.out::println);
                break;
            case 3:
                System.out.println("Introduce edad minima: ");
                int edadMinima = sc.nextInt();
                System.out.println("Introduce edad maxima: ");
                int edadMaxima = sc.nextInt();
                profesionales.stream().filter(p -> p.getEdad() >= edadMinima && p.getEdad() <= edadMaxima)
                        .forEach(System.out::println);
                break;
            case 4:
                break;
        }
    }

    static void listarNombres(){
        String nombres = profesionales.stream()
                .map(Profesional::getNombre)
                .collect(Collectors.joining(", ")) + ".";

        System.out.println(nombres);
    }

}
