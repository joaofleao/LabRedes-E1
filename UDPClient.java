import java.io.*;
import java.net.*;

class UDPClient {
   public static void main(String args[]) throws Exception {
      // cria o stream do teclado e le
      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
      String sentence = inFromUser.readLine();

      // declara socket cliente
      DatagramSocket clientSocket = new DatagramSocket();

      // obtem endereço IP do servidor com o DNS
      InetAddress IPAddress = InetAddress.getByName("localhost");

      //converter string para bytes
      byte[] sendData = new byte[1024];
      sendData = sentence.getBytes();

      // cria pacote com o dado, o endereço do server e porta do servidor
      //data lenght address port
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 1971);

      //envia o pacote
      clientSocket.send(sendPacket);

      // fecha o cliente
      clientSocket.close();
   }
}
