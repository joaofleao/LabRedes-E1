import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientCopy {
	public static void main(String[] args) throws Exception {
	Scanner tc = new Scanner(System.in);
	System.out.println("diga o nome");
	String fName = tc.nextLine();

		File f = new File(fName);
		FileInputStream in = new FileInputStream(f);

		Socket socket = new Socket("localhost", 1900);
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter writer = new BufferedWriter(osw);
		writer.write(f.getName()+"\n");
		writer.flush();
		int c;
		while ((c = in.read()) != -1) {
			System.out.println(c);
			out.write(c);
		}
	}
}