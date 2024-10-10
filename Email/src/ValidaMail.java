
public class ValidaMail {

    public static void main(String[] args) {

        boolean tieneArroba = false;
        boolean tieneIdentificador = false;
        boolean longitudMinima = false;
        boolean tieneDominio = false;
        boolean tienePunto = false;


        int contadorLongitudMinima = 0;


        for (int i = 0; i< args[0].length();i++){
            if (!tieneArroba){
                if (args[0].charAt(i) == '@') tieneArroba = true;
                else contadorLongitudMinima++;
            }
            else if (args[0].charAt(i) == '.') tienePunto = true;
        }

        if (tieneArroba && tienePunto){
            String[] mailSeparado = args[0].split("@");
            mailSeparado = mailSeparado[1].split("\\.");
            for (int i = 0; i < mailSeparado.length;i++){
                if (mailSeparado[0].contentEquals("hotmail") || mailSeparado[0].contentEquals("gmail")) tieneIdentificador = true;
                if (mailSeparado[1].contentEquals("com") || mailSeparado[1].contentEquals("es")
                        || mailSeparado[0].contentEquals("org")) tieneDominio = true;

            }
        }

        if (contadorLongitudMinima >= 3) longitudMinima = true;

        if (!tieneArroba) System.out.println("ERROR: El email no contiene una @!");
        else if (!tieneIdentificador) System.out.println("No existe segundo identificador!");
        else if (!longitudMinima) System.out.println("ERROR: El primer identificador ha de tener una longitud mínima de 3 caracteres!");
        else if (!tieneDominio) System.out.println("ERROR: El dominio no es ni com/es/org!");
        else System.out.println("El email es valido");
    }
}
