package server;

import java.io.IOException;
import java.net.*;

public class CharacterServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket server = null;
		try {
			server = new DatagramSocket(60000);

			byte[] randomChar = new byte[4];
			DatagramPacket p;

			while(true)
			{
				p = new DatagramPacket(randomChar, randomChar.length);
				server.receive(p);
				CharacterServer s = new CharacterServer(server, p);
				s.start();
			}

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(server != null)
				server.close();
		}
	}
}
