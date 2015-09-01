package Client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	final static int SERVER_PORT = 80;
	final static String SERVER_ADDRESS = "localhost";
	InputStream inputStream;
	
	Client() {
		// Maak een socket voor de verbinding met de server
		Socket socket = null;
		try {
			socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Creëer een input en output stream
		try {
			inputStream = new BufferedInputStream(
					socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OutputStream outputStream = new BufferedOutputStream(
					socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Creëer een thread om berichten van de server te ontvangen
		ServerListener serverListener = new ServerListener();

	}

	public class ServerListener extends Thread {

		public void run() {
			while (true) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(inputStream));
				try {
					String data = reader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Doe iets met de ingelezen data.
			}
		}
	}

}
