import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args) {
        System.out.println("server started");
        int port = 8089;

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                System.out.println("New connection accepted");
                out.println("Write your name");
                final String name = in.readLine();
                System.out.println("The client's name is - " + name);
                out.println("Are you child? (yes/no)");
                final String resp = in.readLine();
                System.out.println("The client's replied - " + resp);
                String welcome = (resp.equals("yes")) ? "Welcome to the kids area, " + name + " Let's play!" :
                        "Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!";
                out.println(welcome);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
