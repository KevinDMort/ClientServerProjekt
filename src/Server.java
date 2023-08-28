import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static int port = 1992;
    static DataInputStream in;
    static DataOutputStream out;
    static ServerSocket server;

    static {
        try {
            server = new ServerSocket(1992);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Socket socket;
    public static void main(String[] args) throws IOException {
        while(true)
        {
            socket = server.accept();
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            int modtaget = in.readInt();
            System.out.println("Nummer modtaget: " + modtaget);

            out.writeInt( modtaget*2);
            socket.close();
        }
    }


}
