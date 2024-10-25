import java.util.Random;

public class ReservaEntradas {

    public static void main(String[] args) throws InterruptedException {
        Thread[] usuarios = new Thread[10];

        for (int i = 0; i< usuarios.length;i++){
            usuarios[i] = new Usuario("Cliente "+(i+1));
            usuarios[i].start();
        }

        for (int i = 0; i< usuarios.length;i++){
            usuarios[i].join();
        }

        System.out.println("Total entradas vendidas: "+Reservar.getEntradasVendidas());

    }
}
class Usuario extends Thread{

    Usuario(String name){
        super(name);
    }

    @Override
    public void run() {

        Random rand = new Random();
        int cantidadEntradas = rand.nextInt(10) + 1;
        Reservar.reservaEntrada(getName(),cantidadEntradas);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Reservar {
    static int entradasDisponibles = 100;
    static int entradasVendidas;

    public static synchronized void reservaEntrada(String cliente, int cantidad) {
        if (cantidad <= entradasDisponibles) {
            entradasDisponibles -= cantidad;
            entradasVendidas += cantidad;
            System.out.println(cantidad + " reservadas para " + cliente);
        } else {
            System.out.println("No quedan entradas para " + cliente);
        }
    }

    public static int getEntradasVendidas() {
        return entradasVendidas;
    }
}
