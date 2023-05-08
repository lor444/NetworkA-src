import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientUpper {

    private String host;

    public ClientUpper(String host){
        this.host=host;
    }

    public void run(){
        String message="";
        while(message.compareTo("quit")!=0) {
            System.out.print("Testo da inviare al server: ");
            Scanner s = new Scanner(System.in);
            message = s.nextLine();
            if(message.equalsIgnoreCase("quit"))
                return;
            try {
                Socket sock = new Socket(host,9876);
                PrintStream out=new PrintStream(sock.getOutputStream());
                out.println(message);
                BufferedReader reader=new BufferedReader(new InputStreamReader(sock.getInputStream()));
                String response=reader.readLine();
                System.out.println("Risposta: "+response);
                sock.close();
                sock=null;
            }catch (Exception ex){
                System.out.println("Impossibile dialogare con il server: "+ex.toString());
            }
        }
    }

}
