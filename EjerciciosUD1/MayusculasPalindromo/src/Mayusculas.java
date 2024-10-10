import java.io.*;

public class Mayusculas {

    public String devolverCadenaEnMayusculas(String cadena){
        return cadena.toUpperCase();
    }

    public boolean esPalindromo(String cadena){
        String cadenaReves = "";
        for (int i = cadena.length()-1; i>=0; i--){
            cadenaReves += cadena.charAt(i);
        }
        if (cadenaReves.replace(" ","").toLowerCase().contentEquals
                (cadena.replace(" ","").toLowerCase())) return true;
        else return false;
    }

    public static void main(String[] args) {
        Mayusculas mayus = new Mayusculas();

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br= new BufferedReader(in);
        String texto;
        try {
            System.out.println("Introduce Cadena:");
            texto=br.readLine();
            System.out.println("Su cadena en mayusuclas -> "+mayus.devolverCadenaEnMayusculas(texto));
            if (mayus.esPalindromo(texto)) System.out.println("{"+texto+"} es Palindromo");
            else System.out.println("{"+texto+"} no es Palindromo");
            in.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


}
