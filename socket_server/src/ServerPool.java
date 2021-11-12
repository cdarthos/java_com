import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
public class ServerPool extends Thread {

    static Object lock;
    static Socket conn;


    public void run() {
        Socket soc;


        while (true) {
            synchronized (lock) {
                try {
                    lock.wait();
                    soc = conn;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            BufferedWriter buf_out = BW(soc);
            BufferedReader buf_in = BR(soc);
            send_message(buf_out, "connection serveur : OK");

            while (true) {
                String recu1 = receive_message(buf_in);
                System.out.println(recu1);
            }
            try {
                soc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        lock = new Object();
        ServerSocket srv1 ;
        try {
            conn = new ServerSocket(5555);

            ServerPool[] threadPool = new ServerPool[2];
            for (ServerPool sp : threadPool) {
                sp = new ServerPool();
                sp.start();
            }

            while (true) {
                synchronized (lock) {
                    conn = srv1.accept();
                    lock.notify();
                }
            } }catch(IOException e){
                e.printStackTrace();
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
*/