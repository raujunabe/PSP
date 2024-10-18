import java.util.Scanner;

class Coche extends Thread{

    int distanciaRecorrida = 0;

    Coche(String name){
        super(name);
    }

    @Override
    public void run() {
        while (distanciaRecorrida < 500){

            int cantidadAleatoria = (int)(Math.random() * 100);
            distanciaRecorrida += cantidadAleatoria;
            System.out.println(getName()+" lleva recorrido "+distanciaRecorrida+"km!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("El "+getName()+" ha finalizado al recorrer "+distanciaRecorrida+"km.");
    }
}

public class Coches {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el número de coches a competir: ");
        int numCoches = sc.nextInt();

        Coche[] cochesParticipantes = new Coche[numCoches];

        for (int i = 0; i<numCoches; i++){
            System.out.println("Introduzca marca del coche "+(i+1)+": ");
            String marca = sc.next();
            cochesParticipantes[i] = new Coche(marca+"("+(i+1)+")");
        }

        System.out.println("Que empieze la carrera!\n");

        for (int i = 0; i<numCoches; i++){
            cochesParticipantes[i].start();
        }
    }
}
