import java.io.*;
import java.net.*;


public class TCPServer {
    public static void main(String[] args) throws IOException {
            //iniciar socket de servidor e aceitar clientes
            ServerSocket serverSocket = new ServerSocket(1971);
            Socket clientSocket = serverSocket.accept();


            //ler dados do cliente
            InputStream in = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            

            //pegar nome do arquivo
            String fName = reader.readLine();

            //adicionar out para ficar mais entendivel
            File file = new File("out_"+fName);
            FileOutputStream fileWritter = new FileOutputStream(file);
           
            //ler texto char por char
            for (int i = in.read(); i != -1; i = in.read() ) {
                //adicionar o char no arquivo
                fileWritter.write(i);
            }

            System.out.println("Arquivo recebido");
    }
}