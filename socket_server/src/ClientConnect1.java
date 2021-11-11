import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientConnect1 {
    public static void main(String[] args) {
        Socket sock;
        String machineServer = "localhost";
        int port = 5555;

        try {
            sock = new Socket(machineServer,port);

            InputStream is1 = sock.getInputStream();
            OutputStream os1 = sock.getOutputStream();


            BufferedReader in1 = new BufferedReader(new InputStreamReader(is1));


            System.out.println("1");
            String line;
            while(in1.ready() && (line = in1.readLine()) != null) {
                System.out.println(line);
            }



            System.out.println("2");




            BufferedWriter out1 = new BufferedWriter(new OutputStreamWriter(os1));
            System.out.println("Entrez le message pour le serveur");

            Scanner in = new Scanner(System.in);
            String input = in.nextLine();



            //out1.write(input);
            //out1.flush();
            sock.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
