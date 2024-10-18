import java.util.Random;

public class CuentaCorriente {
    public static void main(String[] args) {

        Cuenta cuenta = new Cuenta(50);
        int numPersonasCuenta = 5;
        SacarDinero[] retiradaDinamica = new SacarDinero[numPersonasCuenta];
        Random random = new Random();

        String[] nombres = {"Raul","Javi","Pepe","Ana","Carla"};

        for (int i = 0; i<retiradaDinamica.length;i++){
            int cantidadAleatoria = random.nextInt(11) + 5;;
            retiradaDinamica[i] = new SacarDinero(nombres[i],cuenta,cantidadAleatoria);
            retiradaDinamica[i].start();
        }
    }
}

class Cuenta {
    int saldo;

    Cuenta(int saldo){
        setSaldo(saldo);
    }

    //region GettersAndSetters

    void setSaldo(int saldo){
        this.saldo = saldo;
    }

    int getSaldo(){
        return this.saldo;
    }
    //endregion

    void restar(int cantidad){
        setSaldo(getSaldo()-cantidad);
    }

    synchronized void retirarDinero(int cant, String nom){

        if (getSaldo() >= cant){
            System.out.println(nom+": SE VA A RETIRAR SALDO (ACTUAL ES: "+getSaldo()+")");
            restar(cant);
            System.out.println(nom+" retira "+cant+" ACTUAL("+getSaldo()+")");
        }
        else System.out.println(nom+": No puede retirar dinero, NO HAY SALDO("+getSaldo()+")");
    }
}

class SacarDinero extends Thread {

    private Cuenta cuenta;
    int retirada;

    public SacarDinero(String name, Cuenta cuenta, int cantidadAleatoria){
        super(name);
        this.cuenta = cuenta;
        this.retirada = cantidadAleatoria;
    }

    void sacarDinero(){
        cuenta.retirarDinero(this.retirada, getName());
    }

    @Override
    public void run() {
        sacarDinero();
    }
}
