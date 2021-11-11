import java.io.*;
import java.net.Socket;

public class ClientConnect2 {
    public static void main(String[] args) {
        Socket sock;
        String machineServer = "localhost";
        int port = 5555;

        try {
            sock = new Socket(machineServer,port);
            OutputStream os1 = sock.getOutputStream();
            BufferedWriter out1 = new BufferedWriter(new OutputStreamWriter(os1));
            out1.write("client2toServer");
            out1.flush();
            sock.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
