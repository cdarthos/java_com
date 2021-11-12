import java.io.*;
import java.net.Socket;


public class Client1_v2 {
    public static void main(String[] args) {
        Socket sock;
        String machineServer = "localhost";
        int port = 5555;

        try {
            sock = new Socket(machineServer,port);

            BufferedReader in1 = util.BR(sock);
            BufferedWriter out1 = util.BW(sock);

            String line = util.receive_message(in1);
            System.out.println(line);

            boolean fin;

            do {
                String clavier_input = util.message_clavier("Entrez le message pour le serveur");
                util.send_message(out1, clavier_input);
                fin = clavier_input.equalsIgnoreCase("fin");
            }while(!fin);
            System.out.println("Connexion closed by client");
            sock.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
