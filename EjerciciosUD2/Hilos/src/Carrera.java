class Corredor extends Thread{

    Corredor(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i<1500; i++){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("El corredor "+getName()+" ha terminado");
    }
}
public class Carrera {
    public static void main(String[] args) {
        String[] corredores = { "Hicham El Guerrouj", "Noah Ngeny", "Mohamed Farah", "Bernard Lagat", "Rashid Ramzi",
        "Ryan Gregson", "Fermín Cacho", "Teddy Flack" };

        for (int i = 0; i<corredores.length; i++){
            Corredor corredor = new Corredor(corredores[i]);
            corredor.start();
        }
    }

}
