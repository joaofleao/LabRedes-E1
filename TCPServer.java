import java.io.*;
import java.net.*;


public class TCPServer {
    public static void main(String[] args) throws IOException {
            //iniciar socket de servidor e aceitar clientes
            ServerSocket serverSocket = new ServerSocket(1971);
            Socket clientSocket = serverSocket.accept();


            //ler dados do cliente
            InputStream in = clientSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader reader = new BufferedReader(isr);
            

            //pegar nome do arquivo
            String fName = reader.readLine();

            //adicionar out para ficar mais entendivel
            File file = new File("out_"+fName);
            FileOutputStream out = new FileOutputStream(file);
           
            //ler texto char por char
            for (int c = in.read(); c != -1; c = in.read() ) {
                //adicionar o char no arquivo
                out.write(c);
            }
            clientSocket.close();
            System.out.println("Arquivo recebido");
    }
}


