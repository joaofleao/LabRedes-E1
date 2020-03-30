import java.io.*;
import java.net.*;
import java.util.*;

class TCPClient {
    public static void main(String argv[]) throws Exception {
        // cria o stream do teclado e le
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        // name = "test.txt";
        String name = inFromUser.readLine();

        FileInputStream file = new FileInputStream(name);

        // declara socket cliente
        Socket clientSocket = new Socket("localhost", 1971);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        outToServer.writeBytes(name+"\n");
        outToServer.flush();
        int teste = 0;
        int by;
        while((by = file.read()) != -1) {
            outToServer.write(by);
            //System.out.println(teste++ + ": " + by);
        }

         // fecha o cliente
        clientSocket.close();
    }
}