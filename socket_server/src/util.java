import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class util {
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
    public static String message_clavier(String prompt){
        System.out.println(prompt);
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        return input;
    }
}
