import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8089;

        try (Socket clientSocket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true)) {
            String resp = in.readLine();
            System.out.println(resp);
            out.println("Arnold");
            String resp1 = in.readLine();
            System.out.println(resp1);
            out.println("no");
            String resp2 = in.readLine();
            System.out.println(resp2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
