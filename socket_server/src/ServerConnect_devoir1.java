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
            //Socket connexion2 = srv1.accept();

            OutputStream os1 = connexion1.getOutputStream();
            InputStream is1 = connexion1.getInputStream();


            BufferedWriter out1 = new BufferedWriter(new OutputStreamWriter(os1));




            out1.write("client connecté au serveur");
            out1.newLine();
            out1.flush();
            //out1.close();
            System.out.println("flush");
            //connexion1.shutdownOutput();
            //Socket.shutdownInput();


            BufferedReader in1 = new BufferedReader(new InputStreamReader(is1));
            String recu = in1.readLine();
            System.out.println(recu);

            connexion1.close();

//



            /*
            OutputStream os1 = connexion1.getOutputStream();
            OutputStream os2 = connexion2.getOutputStream();
            BufferedWriter out1 = new BufferedWriter(new OutputStreamWriter(os1));
            BufferedWriter out2 = new BufferedWriter(new OutputStreamWriter(os2));

            out1.write("server2client1");
            out2.write("server2client2");
            out1.flush();
            out2.flush();
            */

            connexion1.close();
            //connexion2.close();
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
