package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerClass {
	final static int SERVER_PORT = 80;
	
	ServerClass() {
		// Maak een socket aan om op clients te wachten
				ServerSocket serverSocket = null;
				try {
					serverSocket = new ServerSocket(SERVER_PORT);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// Wacht op binnenkomende client connectie requests.
			
				try {
					Socket socket = serverSocket.accept();
					
					// Als er een verbinding tot stand is gebracht, start een nieuwe thread.
					ClientThread ct = new ClientThread(socket);
					ct.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// start de thread en roept run() aan. Gebruik hier niet
				// run(): dan wordt de code in de huidige thread gedraaid.
	}
	
	public class ClientThread extends Thread {
		private Socket socket;

		public ClientThread(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			// 1. Wacht op berichten van de client.
			// 2. Stuur berichten van de clients door naar de andere
			// clients. (Broadcast)
		}
	}
}
