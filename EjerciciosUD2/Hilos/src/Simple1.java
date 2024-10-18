
class Hilo implements Runnable{

    static int contador = 0;


    @Override
    public void run() {
        contador += 1000;
        System.out.println(Thread.currentThread().getName()+": "+contador);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error en el hilo "+Thread.currentThread().getName());
        }
    }
}

public class Simple1 {
    public static void main(String[] args) {
        int numeroDeHilos = 5;
        Thread[] hilos = new Thread[numeroDeHilos];

        for (int i = 0; i<numeroDeHilos;i++){
            hilos[i] = new Thread(new Hilo());
            hilos[i].start();
        }
    }
}
