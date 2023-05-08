import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTime {

    // Protocollo DAYTIME

    private String hostName;

    public ClientTime(String hostName) {
        this.hostName = hostName;
    }

    public String getCurrentTime(){
        try {
            InetAddress address = InetAddress.getByName(hostName);
            System.out.println("Connecting to : "+address.getHostAddress());

            Socket socket = new Socket(address,13);
            InputStream in = socket.getInputStream();

            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            String s = new String(buffer, 0, bytesRead);
            return s;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}









/*

            InetAddress address = InetAddress.getByName(hostName);
            System.out.println("Connecting to : "+address.getHostAddress());

            Socket socket = new Socket(address,13)
            InputStream in = socket.getInputStream();
            DataInputStream din=new DataInputStream(in);
            byte[] buffer =new byte[4096];
            int bytesRead=din.read(buffer);
            socket.close();

            return new String(buffer,0,bytesRead);


BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                return in.readLine();
 */