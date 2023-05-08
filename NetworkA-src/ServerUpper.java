import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class ServerUpper {

    public static void main(String[] args) {
        ServerUpper server=new ServerUpper();
        server.run();
    }

    public void run(){
        try {
            ServerSocket srv = new ServerSocket(9876);

            while(true){
                System.out.println("Waiting for next client connection ...");

                Socket client=srv.accept();
                System.out.println("Client from "+client.getInetAddress().toString()+" connected");

                InputStream in =client.getInputStream();
                InputStreamReader reader=new InputStreamReader(in);
                BufferedReader bReader=new BufferedReader(reader);
                String content=bReader.readLine();
                System.out.println("Received: "+content);

                PrintStream ps =new PrintStream(client.getOutputStream());
                String responseContent=content.toUpperCase();
                ps.println(responseContent);
                System.out.println("Sent: "+responseContent);
                ps.flush();
                ps.close();

                client.close();
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
