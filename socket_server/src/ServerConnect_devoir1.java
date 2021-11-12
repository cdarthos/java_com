import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerConnect_devoir1 {
    public static void main(String[] args) {
        ServerSocket srv1;


        try {
            srv1 = new ServerSocket(5555) ;

            System.out.println("attente connexion");
            Socket connexion1 = srv1.accept();
            System.out.println("client 1 connecté");

            Socket connexion2 = srv1.accept();
            System.out.println("client 2 connecté");

//client 1
            BufferedWriter out1 = BW(connexion1);
            BufferedReader in1 = BR(connexion1);

            send_message(out1, "connection serveur : OK");

            String recu1 = receive_message(in1);
            System.out.println(recu1);

//client 2
            BufferedWriter out2 = BW(connexion2);
            BufferedReader in2 = BR(connexion2);

            send_message(out2, "connection serveur : OK");

            String recu2 = receive_message(in2);
            System.out.println(recu2);

            connexion1.close();
            connexion2.close();
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void send_message(BufferedWriter out, String message) throws IOException {
        out.write(message);
        out.newLine();
        out.flush();
    }
    public static String receive_message(BufferedReader in) throws IOException {
        String receive_message = in.readLine();
        return receive_message;
    }
    public static BufferedWriter BW(Socket sock) throws IOException {
        OutputStream os1 = sock.getOutputStream();
        BufferedWriter out1 = new BufferedWriter(new OutputStreamWriter(os1));
        return out1;
    }
    public static BufferedReader BR(Socket sock) throws IOException {
        InputStream is1 = sock.getInputStream();
        BufferedReader in1 = new BufferedReader(new InputStreamReader(is1));
        return in1;
    }

}
