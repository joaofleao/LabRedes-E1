import java.io.*;
import java.net.*;
import java.util.*;

class UDPClient {
   public static void main(String args[]) throws Exception {
      //pegar nome do arquivo
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo:");
      String fileName = keyboard.nextLine();
      
		//abrir arquivo
		File file = new File(fileName);
      FileInputStream fileReader = new FileInputStream(file);
            
      // declara socket cliente
      DatagramSocket clientSocket = new DatagramSocket();

      // obtem endereço IP do servidor com o DNS
      InetAddress IPAddress = InetAddress.getByName("localhost");

      //criar array pra enviar dados
      ByteArrayOutputStream sendData = new ByteArrayOutputStream();

      //adicionar o nome do arquivo aos dados a serem enviados
      sendData.write((fileName + "\n").getBytes());
         
      //adicionar o conteudo do arquivo aos dados a serem enviados
      for (int i = fileReader.read(); i != -1; i = fileReader.read() ) {
			sendData.write(i);
		}
      
      //transformar dados em array de 1024 de tamanho
      byte[] out = new byte[1024];
      out = sendData.toByteArray();

      // cria pacote com o dado, o endereço do server e porta do servidor
      DatagramPacket sendPacket = new DatagramPacket(out, out.length, IPAddress, 1971);

      //envia o pacote
      clientSocket.send(sendPacket);
      
      // fecha o cliente
      clientSocket.close();
      
      System.out.println("Arquivo enviado");
   }
}
