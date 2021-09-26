import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnect {
    public static void main(String[] arges) {
        ServerSocket srv;

        try {
            srv = new ServerSocket(5555) ;
            Socket connexion = srv.accept();

            OutputStream os = connexion.getOutputStream();

            byte[] tabloServ = { 1,2,3,4,5};

            os.write(tabloServ);

            connexion.close();
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
