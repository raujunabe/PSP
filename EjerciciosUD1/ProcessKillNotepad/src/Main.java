import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        try{
            Process notepad = new ProcessBuilder("kwrite").start();

            Thread.sleep(10000);

            notepad.destroy();

        }catch (IOException | InterruptedException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

}
