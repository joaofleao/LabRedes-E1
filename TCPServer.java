import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;

class TCPServer {
    public static void main(String argv[]) throws Exception {
        // cria socket do servidor com a porta 1971
        ServerSocket welcomeSocket = new ServerSocket(1971);
        Socket connectionSocket = welcomeSocket.accept();
        InputStream in = connectionSocket.getInputStream();
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(in));
        String fName = inFromClient.readLine();

        File f1 = new File("out_"+fName);

        FileOutputStream out = new FileOutputStream(f1);
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
    }
}
