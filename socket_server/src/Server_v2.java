import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Server_v2 {
    ServerSocket myServerSocket;
    boolean ServerOn = true;
    public Server_v2() {
        try {
            myServerSocket = new ServerSocket(5555);
        } catch(IOException ioe) {
            System.out.println("Could not create server socket on port 5555. Quitting.");
            System.exit(-1);
        }

        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat(
                "E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println("It is now : " + formatter.format(now.getTime()));

        while(ServerOn) {
            try {
                Socket clientSocket = myServerSocket.accept();
                ClientServiceThread cliThread = new ClientServiceThread(clientSocket);
                cliThread.start();
            } catch(IOException ioe) {
                System.out.println("Exception found on accept. Ignoring. Stack Trace :");
                ioe.printStackTrace();
            }
        }
        try {
            myServerSocket.close();
            System.out.println("Server Stopped");
        } catch(Exception ioe) {
            System.out.println("Error Found stopping server socket");
            System.exit(-1);
        }
    }

    public static void main (String[] args) {
        new Server_v2();
    }

    class ClientServiceThread extends Thread {
        Socket myClientSocket;
        boolean m_bRunThread = true;
        public ClientServiceThread() {
            super();
        }

        ClientServiceThread(Socket s) {
            myClientSocket = s;
        }

        public void run() {
            BufferedReader buf_in = null;
            BufferedWriter buf_out = null;
            System.out.println(
                    "Accepted Client Address - " + myClientSocket.getInetAddress() + ":" + myClientSocket.getPort());
            try {
                buf_out = BW(myClientSocket);
                buf_in = BR(myClientSocket);
                send_message(buf_out,"connection serveur : OK");


                while(m_bRunThread) {
                    String clientCommand = buf_in.readLine();
                    System.out.println("Client Says :" + clientCommand);

                    if(!ServerOn) {
                        System.out.print("Server has already stopped");
                        send_message(buf_out, "Server has already stopped");
                        m_bRunThread = false;
                    }
                    if(clientCommand.equalsIgnoreCase("fin")) {
                        m_bRunThread = false;
                        System.out.print("Stopping client thread for client : ");
                    } else if(clientCommand.equalsIgnoreCase("end")) {
                        m_bRunThread = false;
                        System.out.print("Stopping client thread for client : ");
                        ServerOn = false;
                    } else {
                        send_message(buf_out,"Server Says : " + clientCommand);
                    }
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    buf_in.close();
                    buf_out.close();
                    myClientSocket.close();
                    System.out.println("...Stopped");
                } catch(IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public static void send_message(BufferedWriter out, String message) throws IOException {
        out.write(message);
        out.newLine();
        out.flush();
    }
    public static String receive_message(BufferedReader in) throws IOException {
        return in.readLine();
    }
    public static BufferedWriter BW(Socket sock) throws IOException {
        OutputStream os1 = sock.getOutputStream();
        return new BufferedWriter(new OutputStreamWriter(os1));
    }
    public static BufferedReader BR(Socket sock) throws IOException {
        InputStream is1 = sock.getInputStream();
        return new BufferedReader(new InputStreamReader(is1));
    }
}