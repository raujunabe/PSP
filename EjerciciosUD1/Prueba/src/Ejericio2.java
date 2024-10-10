public class Ejericio2 {
    public static void main(String[] args) {
        int[][] num = {
                {0,30,2,0,0,5},
                {75,0,0,0,0,0},
                {0,0,-2,9,0,11}
        };

        System.out.println("     ");
        for (int i = 0; i<num[0].length;i++){
            System.out.print(" Columna "+i+" ");
        }
        for (int i = 0; i<num.length;i++){
            System.out.print("\nFila "+i);
            for (int j = 0; j< num[0].length;j++){
                System.out.print(" "+num[i][j]);
            }
        }
    }
}
