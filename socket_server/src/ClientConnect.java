import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientConnect {
    public static void main(String[] args) {
        Socket sock;
        String machineServer = "server";
        int port = 5555;

        try {
            sock = new Socket(machineServer,port);
            InputStream is = sock.getInputStream();

            byte[] tabloCli = new byte[5];
            int recu = is.read(tabloCli);

            sock.close();

            System.out.println(recu);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
