
class ContadorHilos implements Runnable {

    int numContador = 3;
    String nombreHilo;

    ContadorHilos(String nombre){
        this.nombreHilo = nombre;
    }

    @Override
    public void run() {

        for (int i = 0; i < numContador; i++){
            System.out.println("Hilo: "+nombreHilo+" = "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error en el hilo "+nombreHilo);
            }
        }
    }
}

public class HiloEjemplo1 {

    public static void main(String[] args) throws InterruptedException {
        int numeroDeHilos = 3;
        Thread[] hilos = new Thread[numeroDeHilos];

        for (int i = 0; i<numeroDeHilos;i++){
            hilos[i] = new Thread(new ContadorHilos("Hilo "+(i+1)));
            hilos[i].start();
        }


        System.out.println(numeroDeHilos + " HILOS INICIADOS... y finalizados.");
    }



}
