package clientServer;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;

	public Client() {
		try {
			InetAddress host = InetAddress.getLocalHost();
			socket = new Socket(host.getHostName(), 5600);

			dos = new DataOutputStream(socket.getOutputStream());

			dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeStream() {
		try {
			dos.close();
			dis.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean sendQuery(String jsonQuery) {
		try {
			dos.writeUTF(jsonQuery);
			dos.flush();
			return true;
		} catch (IOException ioe) {
			System.out.println("Sending error: " + ioe.getMessage());
			return false;
		}
	}

	public String readAnswer() {
		String line = "";
		
		while (true) {
			try {
				line = dis.readUTF();
				System.out.println(line);
			} catch (EOFException eof) {
				break;
			} catch (IOException ioe) {
				System.out.println("Reading error: " + ioe.getMessage());
			}
		}
		
		this.closeStream();
		return line;
	}
}