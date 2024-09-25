import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static ArrayList<String> posiciones = new ArrayList<String>();

     static String[][] tablero = {
            {"1a", "1b", "1c","1d","1e","1f","1g","1h"},
            {"2a", "2b", "2c","2d","2e","2f","2g","2h"},
            {"3a", "3b", "3c","3d","3e","3f","3g","3h"},
            {"4a", "4b", "4c","4d","4e","4f","4g","4h"},
            {"5a", "5b", "5c","5d","5e","5f","5g","5h"},
            {"6a", "6b", "6c","6d","6e","6f","6g","6h"},
            {"7a", "7b", "7c","7d","7e","7f","7g","7h"},
            {"8a", "8b", "8c","8d","8e","8f","8g","8h"}


    };

    public static void main(String[] args) {

        String posIntroducida = "";

        int fila,col = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la posición del alfil: ");
        posIntroducida = sc.next();

        fila = Character.getNumericValue(posIntroducida.charAt(0)) -1 ;
        switch (posIntroducida.charAt(1)){
            case 'a':
            case 'A':
                col = 0;
                break;
            case 'b':
            case 'B':
                col = 1;
                break;
            case 'c':
            case 'C':
                col = 2;
                break;
            case 'd':
            case 'D':
                col = 3;
                break;
            case 'e':
            case 'E':
                col = 4;
                break;
            case 'f':
            case 'F':
                col = 5;
                break;
            case 'g':
            case 'G':
                col = 6;
                break;
            case 'h':
            case 'H':
                col = 7;
                break;
        }


        checkDiagonalArriba(fila,col);
        checkDiagonalAbajo(fila,col);
        checkDiagonalINVArriba(fila,col);
        checkDiagonalINVAbajo(fila,col);

        for (int i = 0; i< posiciones.size();i++){
            System.out.print(posiciones.get(i)+" ");
        }

    }

    public static void checkDiagonalArriba(int fila, int columna){
        while (fila < 7 || columna < 7){
            posiciones.add(tablero[fila][columna]);
            fila ++;
            columna++;
        }
    }
    public static void checkDiagonalAbajo(int fila, int columna){
        while (fila > 0 || columna > 0){
            posiciones.add(tablero[fila][columna]);
            fila --;
            columna --;
        }
    }
    public static void checkDiagonalINVArriba(int fila, int columna){
        while (fila < 7 || columna > 0){
            fila ++;
            columna--;
            posiciones.add(tablero[fila][columna]);

        }
    }
    public static void checkDiagonalINVAbajo(int fila, int columna){
        while (fila > 0 || columna < 7){
            fila --;
            columna ++;
            posiciones.add(tablero[fila][columna]);
        }
    }
}