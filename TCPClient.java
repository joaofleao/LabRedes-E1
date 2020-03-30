import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient {
	public static void main(String[] args) throws Exception {
		//pegar nome do arquivo
		Scanner tc = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo:");
		String fName = tc.nextLine();

		//abrir arquivo
		File f = new File(fName);
		FileInputStream in = new FileInputStream(f);

		//criar socket do cliente
		Socket clientSocket = new Socket("localhost", 1971);

		//definir como enviar informacoes
		DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

		//enviar nome do arquivo para o server
		out.writeBytes(f.getName()+"\n");

		//mandar texto para o server
		//ler arquivo todo char por char
		for (int c = in.read(); c != -1; c = in.read() ) {
			//enviar o char 
			out.write(c);
		}
		System.out.println("Arquivo enviado");
	}
}