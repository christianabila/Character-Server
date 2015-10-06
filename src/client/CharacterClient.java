package client;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class CharacterClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket client = new DatagramSocket();
			Scanner s = new Scanner(System.in);

			client.connect(InetAddress.getByName("abila.at"), 60000);
			byte[] receive = new byte[4];
			DatagramPacket p = new DatagramPacket(receive, receive.length);

			System.out.print("Press the Return button to send a request...");

			p = new DatagramPacket(receive, 4);
			byte[] data;
			int randomReceived;

			while(s.nextLine() != null)
			{
				client.send(p);
				p = new DatagramPacket(receive, 4);
				
				client.receive(p);
				data = p.getData();
				
				randomReceived = 0;
				randomReceived |= (data[2] << 8) | data[3];
				System.out.println(new Integer(randomReceived) + ": " + (char) (new Integer(randomReceived)).intValue());
			}

			client.close();
			s.close();

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
