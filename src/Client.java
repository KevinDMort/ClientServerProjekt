    import java.io.DataInputStream;
    import java.io.DataOutputStream;
    import java.io.IOException;
    import java.net.Socket;
    import java.util.Scanner;

    public class Client {
        static int port = 1992;
        static String host = "localhost";
        static DataInputStream in;
        static DataOutputStream out;

        static Socket socket;

        static {
            try {
                socket = new Socket(host,port);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void main(String[] args) throws IOException {
            Scanner input = new Scanner(System.in);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            while(true)
            {

                System.out.println("Skriv et nummer");

                int nr = input.nextInt();
                out.writeInt(nr);

                System.out.println("Dit nr er:");
                System.out.println(in.readInt());

            }

        }


    }
