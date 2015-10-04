package server;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Random;

public class CharacterServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket server = null;
		try {
			server = new DatagramSocket(60000);
			Random r = new Random();
			
			byte[] randomChar = new byte[4];
			DatagramPacket p = new DatagramPacket(randomChar, randomChar.length);
			server.receive(p);
			
			randomChar = ByteBuffer.allocate(4).putInt(r.nextInt(256)).array();
			p = new DatagramPacket(randomChar, randomChar.length, p.getAddress(), p.getPort());
			server.send(p);
			
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
