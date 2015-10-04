package client;

import java.io.IOException;
import java.net.*;

public class CharacterClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket client = new DatagramSocket();
			client.connect(InetAddress.getLocalHost(), 60000);
			byte[] receive = new byte[4];
			DatagramPacket p = new DatagramPacket(receive, receive.length);
			client.send(p);
			
			p = new DatagramPacket(receive, 4);
			
			client.receive(p);
			byte[] data = p.getData();
			int randomReceived = (data[0] << 24) | (data[1] << 16) | (data[2] << 8) | data[3];
			System.out.println(randomReceived);
			System.out.println(new String(p.getData()));
			
			client.close();
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
