import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient {
	public static void main(String[] args) throws Exception {
		//pegar nome do arquivo
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo:");
		String fileName = keyboard.nextLine();

		//abrir arquivo
		File file = new File(fileName);
		FileInputStream fileReader = new FileInputStream(file);

		//criar socket do cliente
		Socket clientSocket = new Socket("localhost", 1971);

		//definir como enviar informacoes
		DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

		//enviar nome do arquivo para o server
		out.writeBytes(fileName+"\n");

		//mandar texto para o server
		//ler arquivo todo char por char
		for (int i = fileReader.read(); i != -1; i = fileReader.read() ) {
			//enviar o char 
			out.write(i);
		}
		clientSocket.close();
		System.out.println("Arquivo enviado");
	}
}